package org.qualipso.factory.client.test.performance;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.auth.callback.UsernamePasswordHandler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.qualipso.factory.FactoryNamingConvention;
import org.qualipso.factory.bootstrap.BootstrapService;
import org.qualipso.factory.bootstrap.BootstrapServiceException;
import org.qualipso.factory.client.test.AllTests;
import org.qualipso.factory.core.CoreService;
import org.qualipso.factory.core.entity.File;
import org.qualipso.factory.eventqueue.EventQueueService;
import org.qualipso.factory.eventqueue.EventQueueServiceException;
import org.qualipso.factory.membership.MembershipService;
import org.qualipso.factory.membership.MembershipServiceException;
import org.qualipso.factory.notification.Event;
import org.qualipso.factory.notification.NotificationServiceException;
import org.qualipso.factory.notification.NotificationServicePerfTest;
import org.qualipso.factory.security.SecurityService;

public class NotificationServicePTest {

    private static Log logger = LogFactory.getLog(NotificationServicePTest.class);
    
    private static Context context;
    private static EventQueueService eqs;
    private static LoginContext loginContext;
    private static MembershipService membership;
    private static SecurityService security;
    private static NotificationServicePerfTest notification;
    private static CoreService core;
    
    /**
     * Set up service for all tests.
     * 
     * @throws LoginException
     * @throws NotificationServiceException
     * @throws MembershipServiceException
     */
    @BeforeClass
    public static void before() throws Exception {
        Properties properties = new Properties();
        properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        properties.put("java.naming.provider.url", "localhost:1099");
        System.setProperty("java.security.auth.login.config", ClassLoader.getSystemResource("jaas.config").getPath());
        context = new InitialContext(properties);

        BootstrapService bootstrap = (BootstrapService) context.lookup(FactoryNamingConvention.getJNDINameForService("bootstrap"));
        try {
            bootstrap.bootstrap();
        } catch (BootstrapServiceException e) {
            logger.error(e);
        }

        eqs = (EventQueueService) context.lookup(FactoryNamingConvention.SERVICE_PREFIX + EventQueueService.SERVICE_NAME);
        membership = (MembershipService) context.lookup(FactoryNamingConvention.SERVICE_PREFIX + MembershipService.SERVICE_NAME);
        security = (SecurityService) context.lookup(FactoryNamingConvention.SERVICE_PREFIX + SecurityService.SERVICE_NAME);
        core = (CoreService) context.lookup(FactoryNamingConvention.SERVICE_PREFIX + CoreService.SERVICE_NAME);
        notification = (NotificationServicePerfTest)context.lookup(FactoryNamingConvention.SERVICE_PREFIX+NotificationServicePerfTest.SERVICE_NAME);
        
        loginContext = new LoginContext("qualipso", new UsernamePasswordHandler("root", AllTests.ROOT_ACCOUNT_PASS));
        loginContext.login();

        membership.createProfile("kermit", "Kermit", "kermit@thefrog", 0);

        core.createFolder("/tests", "Tests", "Tests folder");
        security.addSecurityRule("/tests", "/profiles/kermit", "read,write,create,update");

        loginContext.logout();

        loginContext = new LoginContext("qualipso", new UsernamePasswordHandler("kermit", "thefrog"));
        loginContext.login();
    }

    @Before
    public void setUp() throws Exception {
        String path = "/q";
        for (int i = 0; i < 100; i++) {
            eqs.createEventQueue(path + i);
            eqs.register("/profiles/kermit", Event.buildEventType(CoreService.SERVICE_NAME, File.RESOURCE_NAME, "create"), "/tests.*", path + i);
            eqs.register("/profiles/kermit", Event.buildEventType(CoreService.SERVICE_NAME, File.RESOURCE_NAME, "read"), "/tests.*", path + i);
            eqs.register("/profiles/kermit", Event.buildEventType(CoreService.SERVICE_NAME, File.RESOURCE_NAME, "delete"), "/tests.*", path + i);
        }
    }

    @After
    public void tearDown() throws Exception {
        String path = "/q";
        for (int i = 0; i < 100; i++) {
            eqs.unregister("/profiles/kermit", Event.buildEventType(CoreService.SERVICE_NAME, File.RESOURCE_NAME, "create"), "/tests.*", path + i);
            eqs.unregister("/profiles/kermit", Event.buildEventType(CoreService.SERVICE_NAME, File.RESOURCE_NAME, "read"), "/tests.*", path + i);
            eqs.unregister("/profiles/kermit", Event.buildEventType(CoreService.SERVICE_NAME, File.RESOURCE_NAME, "delete"), "/tests.*", path + i);
            eqs.removeQueue(path + i);
        }
    }

    @AfterClass
    public static void after() throws Exception {
        loginContext.logout();

        loginContext = new LoginContext("qualipso", new UsernamePasswordHandler("root", AllTests.ROOT_ACCOUNT_PASS));
        loginContext.login();

        security.removeSecurityRule("/tests", "/profiles/kermit");
        core.deleteFolder("/tests");

        membership.deleteProfile("/profiles/kermit");

        loginContext.logout();
    }
    /**
     * Test Boundary - Performance throws 10000 events in 1 queue
     * 
     * @throws GreetingServiceException
     * @throws EventQueueServiceException
     * @throws NotificationServiceException 
     */
    @Test
    public void testNotification100Events() throws NotificationServiceException {
        logger.info("testNotification10000Events called");
        
        Event e = new Event("/tests", "/profiles/kermit", File.RESOURCE_NAME, Event.buildEventType(CoreService.SERVICE_NAME, File.RESOURCE_NAME, "read"), "");
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
        	long start1 = System.nanoTime();
        	notification.throwEvent(e);
        	long stop1 = System.nanoTime();
        	logger.debug("Event "+i+"Time to throws : " + (stop1 - start1) + " ns");
        }
        long stop = System.nanoTime();
        logger.debug("Time to throw 100 event : " + (stop - start) + " ns");
        
    }

    /**
     * Test Boundary - Performance throws 1 event into 10000 queues
     * 
     * @throws EventQueueServiceException
     * @throws NotificationServiceException
     * @throws GreetingServiceException
     */
    /*@Test(timeout = 2000000)
    public void testNotification10000Queues() throws EventQueueServiceException, NotificationServiceException, GreetingServiceException {
        logger.info("testNotification10000Queues called");
        String path = "/q";
        for (int i = 0; i < 1; i++) {
            eqs.createEventQueue(path + i);
            eqs.register("/profiles/.*", "greeting.name.read", "/m2logTestPerf.*", path + i);
        }

        greeting.readName(pathResource);

        logger.info("testNotification10000Queues : 10000 queue created, pushing 1 event matching by all queue...");
        PersistentEvent[] lEvent = new PersistentEvent[] {};
        for (int i = 0; i < 1; i++) {
            while (lEvent.length < 1) {
                lEvent = eqs.getEvents(path + i);
            }
            assertTrue("TestNotification10000Queues : expected 1 event but found " + lEvent.length, lEvent.length == 1);
        }

        logger.info("testNotification10000Queues : deleting all queue...");
        // delete
        for (int i = 0; i < 1; i++) {
            eqs.removeQueue(path + i);
            eqs.unregister("/profiles/.*", "greeting.name.read", "/m2logTestPerf.*", path + i);
        }
    }*/
}


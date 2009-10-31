package org.qualipso.factory.indexing;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.jboss.ejb3.annotation.SecurityDomain;
import org.qualipso.factory.indexing.IndexerService;
import org.qualipso.factory.FactoryResourceIdentifier;


@MessageDriven(
		name = "Indexer",
		mappedName = "IndexerService",
		activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/indexingQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "AUTO_ACKNOWLEDGE"),
        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "4"),
        @ActivationConfigProperty(propertyName = "SubscriptionDurability", propertyValue = "Durable") },
        messageListenerInterface = MessageListener.class)
        
@SecurityDomain(value = "JBossWSDigest")


public class IndexerServiceBean implements IndexerService{
	
	@Resource
    private MessageDrivenContext msgDrivCtx;
	
	private Index index;
	
	public void onMessage(Message msg) throws IndexingServiceException {
		try{
			if (msg.propertyExists("fri")&&msg.propertyExists("action")){
				FactoryResourceIdentifier fri = FactoryResourceIdentifier.deserialize(msg.getStringProperty("fri"));
				if(msg.getStringProperty("action").equals("index"))
					this.index(fri);
				if(msg.getStringProperty("action").equals("reindex"))
					this.reindex(fri);
				if(msg.getStringProperty("action").equals("remove"))
					this.remove(fri);
			}
		}catch(JMSException e){
			e.printStackTrace();
		}
		
	}

	
	public void index(FactoryResourceIdentifier fri) throws IndexingServiceException {
		index.index(fri);
		
	}

	public void reindex(FactoryResourceIdentifier fri) throws IndexingServiceException {
		index.reindex(fri);
		
	}

	public void remove(FactoryResourceIdentifier fri) throws IndexingServiceException {
		index.remove(fri);	
		
	}



}

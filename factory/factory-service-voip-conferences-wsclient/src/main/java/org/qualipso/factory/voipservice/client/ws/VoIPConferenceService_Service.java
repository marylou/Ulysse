
package org.qualipso.factory.voipservice.client.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "VoIPConferenceService", targetNamespace = "http://org.qualipso.factory.ws/service/voip", wsdlLocation = "http://localhost:3000/factory-service-voip/voipconference?wsdl")
public class VoIPConferenceService_Service
    extends Service
{

    private final static URL VOIPCONFERENCESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.qualipso.factory.voipservice.client.ws.VoIPConferenceService_Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.qualipso.factory.voipservice.client.ws.VoIPConferenceService_Service.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:3000/factory-service-voip/voipconference?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:3000/factory-service-voip/voipconference?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        VOIPCONFERENCESERVICE_WSDL_LOCATION = url;
    }

    public VoIPConferenceService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VoIPConferenceService_Service() {
        super(VOIPCONFERENCESERVICE_WSDL_LOCATION, new QName("http://org.qualipso.factory.ws/service/voip", "VoIPConferenceService"));
    }

    /**
     * 
     * @return
     *     returns VoIPConferenceService
     */
    @WebEndpoint(name = "VoIPConferenceServicePort")
    public VoIPConferenceService getVoIPConferenceServicePort() {
        return super.getPort(new QName("http://org.qualipso.factory.ws/service/voip", "VoIPConferenceServicePort"), VoIPConferenceService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VoIPConferenceService
     */
    @WebEndpoint(name = "VoIPConferenceServicePort")
    public VoIPConferenceService getVoIPConferenceServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://org.qualipso.factory.ws/service/voip", "VoIPConferenceServicePort"), VoIPConferenceService.class, features);
    }

}

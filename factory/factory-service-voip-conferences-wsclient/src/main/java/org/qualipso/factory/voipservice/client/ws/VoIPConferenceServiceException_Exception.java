
package org.qualipso.factory.voipservice.client.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "VoIPConferenceServiceException", targetNamespace = "http://org.qualipso.factory.ws/service/voip")
public class VoIPConferenceServiceException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private VoIPConferenceServiceException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public VoIPConferenceServiceException_Exception(String message, VoIPConferenceServiceException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public VoIPConferenceServiceException_Exception(String message, VoIPConferenceServiceException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.qualipso.factory.voipservice.client.ws.VoIPConferenceServiceException
     */
    public VoIPConferenceServiceException getFaultInfo() {
        return faultInfo;
    }

}

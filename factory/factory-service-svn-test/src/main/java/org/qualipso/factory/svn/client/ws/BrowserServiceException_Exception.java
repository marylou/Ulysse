
package org.qualipso.factory.svn.client.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "BrowserServiceException", targetNamespace = "http://org.qualipso.factory.ws/service/browser")
public class BrowserServiceException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private BrowserServiceException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public BrowserServiceException_Exception(String message, BrowserServiceException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public BrowserServiceException_Exception(String message, BrowserServiceException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.qualipso.factory.svn.client.ws.BrowserServiceException
     */
    public BrowserServiceException getFaultInfo() {
        return faultInfo;
    }

}
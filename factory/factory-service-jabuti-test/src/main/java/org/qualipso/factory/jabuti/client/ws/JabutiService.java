
package org.qualipso.factory.jabuti.client.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "JabutiService", targetNamespace = "http://org.qualipso.factory.ws/service/jabuti")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface JabutiService {


    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.jabuti.client.ws.FactoryResource
     * @throws FactoryException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public FactoryResource findResource(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws FactoryException_Exception
    ;

    /**
     * 
     * @return
     *     returns org.qualipso.factory.jabuti.client.ws.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    public StringArray getResourceTypeList();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String getServiceName();

    /**
     * 
     * @return
     *     returns java.lang.String
     * @throws JabutiServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "message", partName = "message")
    public String sayJabuti()
        throws JabutiServiceException_Exception
    ;

}

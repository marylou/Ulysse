
package ws.factory.qualipso.org.service.browser;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "BrowserService", targetNamespace = "http://org.qualipso.factory.ws/service/browser")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ws.factory.qualipso.org.resource.link.ObjectFactory.class,
    net.java.dev.jaxb.array.ObjectFactory.class,
    ws.factory.qualipso.org.service.browser.ObjectFactory.class,
    ws.factory.qualipso.org.resource.folder.ObjectFactory.class,
    ws.factory.qualipso.org.resource.profile.ObjectFactory.class,
    ws.factory.qualipso.org.resource.group.ObjectFactory.class,
    ws.factory.qualipso.org.resource.file.ObjectFactory.class
})
public interface BrowserService {


    /**
     * 
     * @param path
     * @return
     *     returns ws.factory.qualipso.org.service.browser.FactoryResource
     * @throws BrowserServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "resource", partName = "resource")
    public FactoryResource findResource(
        @WebParam(name = "path", partName = "path")
        String path)
        throws BrowserServiceException_Exception
    ;

    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
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
     * @param path
     * @return
     *     returns boolean
     * @throws BrowserServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "has-children", partName = "has-children")
    public boolean hasChildren(
        @WebParam(name = "path", partName = "path")
        String path)
        throws BrowserServiceException_Exception
    ;

    /**
     * 
     * @param path
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     * @throws BrowserServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "children", partName = "children")
    public StringArray listChildren(
        @WebParam(name = "path", partName = "path")
        String path)
        throws BrowserServiceException_Exception
    ;

    /**
     * 
     * @param typePattern
     * @param path
     * @param servicePattern
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     * @throws BrowserServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "children", partName = "children")
    public StringArray listChildrenOfType(
        @WebParam(name = "path", partName = "path")
        String path,
        @WebParam(name = "service-pattern", partName = "service-pattern")
        String servicePattern,
        @WebParam(name = "type-pattern", partName = "type-pattern")
        String typePattern)
        throws BrowserServiceException_Exception
    ;

}
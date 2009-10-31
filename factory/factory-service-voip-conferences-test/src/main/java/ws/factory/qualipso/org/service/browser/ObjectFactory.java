
package ws.factory.qualipso.org.service.browser;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ws.factory.qualipso.org.resource.folder.Folder;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.factory.qualipso.org.service.browser package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Folder_QNAME = new QName("http://org.qualipso.factory.ws/service/browser", "folder");
    private final static QName _BrowserServiceException_QNAME = new QName("http://org.qualipso.factory.ws/service/browser", "BrowserServiceException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.factory.qualipso.org.service.browser
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BrowserServiceException }
     * 
     */
    public BrowserServiceException createBrowserServiceException() {
        return new BrowserServiceException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Folder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.qualipso.factory.ws/service/browser", name = "folder")
    public JAXBElement<Folder> createFolder(Folder value) {
        return new JAXBElement<Folder>(_Folder_QNAME, Folder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BrowserServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://org.qualipso.factory.ws/service/browser", name = "BrowserServiceException")
    public JAXBElement<BrowserServiceException> createBrowserServiceException(BrowserServiceException value) {
        return new JAXBElement<BrowserServiceException>(_BrowserServiceException_QNAME, BrowserServiceException.class, null, value);
    }

}


package org.factory.qualipso.service.skillmanagement.org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SelectLevResult" type="{http://tempuri.org/}ArrayOfSupportSQLLev" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "selectLevResult"
})
@XmlRootElement(name = "SelectLevResponse")
public class SelectLevResponse {

    @XmlElement(name = "SelectLevResult")
    protected ArrayOfSupportSQLLev selectLevResult;

    /**
     * Gets the value of the selectLevResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSupportSQLLev }
     *     
     */
    public ArrayOfSupportSQLLev getSelectLevResult() {
        return selectLevResult;
    }

    /**
     * Sets the value of the selectLevResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSupportSQLLev }
     *     
     */
    public void setSelectLevResult(ArrayOfSupportSQLLev value) {
        this.selectLevResult = value;
    }

}

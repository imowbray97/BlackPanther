//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.05 at 03:22:47 AM EDT 
//


package com.panthers.panthers_ws;

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
 *         &lt;element name="characterInfo" type="{http://www.panthers.com/panthers-ws}characterInfo"/>
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
    "characterInfo"
})
@XmlRootElement(name = "updateCharacterRequest")
public class UpdateCharacterRequest {

    @XmlElement(required = true)
    protected CharacterInfo characterInfo;

    /**
     * Gets the value of the characterInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterInfo }
     *     
     */
    public CharacterInfo getCharacterInfo() {
        return characterInfo;
    }

    /**
     * Sets the value of the characterInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterInfo }
     *     
     */
    public void setCharacterInfo(CharacterInfo value) {
        this.characterInfo = value;
    }

}

package com.ziroom.mytesla.business.room.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XmlBean {
    @XmlElement
    public String anyString;
    @XmlElement
    public int anyNumber;
 
    public XmlBean(String anyString, int anyNumber) {
        this.anyString = anyString;
        this.anyNumber = anyNumber;
    }
 
    // empty constructor needed for deserialization by JAXB
    public XmlBean() {
    }
 
    @Override
    public String toString() {
        return "XmlBean{" +
            "anyString='" + anyString + '\'' +
            ", anyNumber=" + anyNumber +
            '}';
    }
}
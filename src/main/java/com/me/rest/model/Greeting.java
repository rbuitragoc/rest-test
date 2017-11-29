package com.me.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="greeting")
public class Greeting {

    @XmlElement
    public String firstName;
    
    @XmlElement
    public String lastName;
}

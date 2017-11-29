package com.me.rest;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.me.rest.model.Greeting;
@Path("greetings")
public class GreetingsResource {

    
    @GET
    public JsonObject greetings() {
        return Json.createObjectBuilder().add("salutation", "hello world!").build();
    }
    
    @POST
    @Produces("text/xml")
    @Consumes("application/x-www-form-urlencoded")
    public String helloWorldXML(
            @FormParam(value="firstName") String firstName, 
            @FormParam(value="lastName") String lastName) throws JAXBException {
        Greeting greeting = new Greeting();
        greeting.firstName = firstName;
        greeting.lastName = lastName;
        
        StringWriter sw = new StringWriter();
        JAXBContext.newInstance(Greeting.class).createMarshaller().marshal(greeting, sw);
        
        return sw.toString();
    }
    
    @GET
    @Path("/{user}")
    public JsonObject helloUser(@PathParam(value="user") String user) {
        return Json.createObjectBuilder().add("salutation", String.format("hello, %s", user)).build();
    }
}

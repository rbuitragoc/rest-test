package com.me.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("greetings")
public class GreetingsResource {

    
    @GET
    public JsonObject greetings() {
        return Json.createObjectBuilder().add("salutation", "hello world!").build();
    }
    @GET
    @Path("/{user}")
    public JsonObject helloUser(@PathParam(value="user") String user) {
        return Json.createObjectBuilder().add("salutation", String.format("hello, %s", user)).build();
    }
}

package com.me.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greetings")
public class GreetingsResource {

    
    @GET
    public JsonObject greetings() {
        return Json.createObjectBuilder().add("Hello", "World").build();
    }
}

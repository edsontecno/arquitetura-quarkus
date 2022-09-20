package br.com.edsonandrade.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import br.com.edsonandrade.annotations.Authorization;

@Path("/hello")
public class GreetingResource  extends Resource{

    @ConfigProperty(name="teste")
    private String teste;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Authorization("hello")
    public String hello() throws Exception {
    	System.out.println(teste);
        return "Hello from RESTEasy Reactive";
    }
}
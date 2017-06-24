package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("basico")
public class BasicResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF8")
    public String helloWorld(){
        return "Hello World";
    }

}
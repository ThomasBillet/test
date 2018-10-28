package colruyt.trsweb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
@Path("/hi")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response seyHi(){

        return Response.ok("hello").build();
    }
}

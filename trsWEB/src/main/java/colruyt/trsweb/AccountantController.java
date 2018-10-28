package colruyt.trsweb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


Path("/accountant")
public class AccountantController {



    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response seyHi(){

        return Response.ok("hello").build();
    }

}

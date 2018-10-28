package colruyt.trsweb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class EmployeeController {


    // P


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){

        return Response.ok("hello").build();
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(){

        return Response.ok("hello").build();
    }




}

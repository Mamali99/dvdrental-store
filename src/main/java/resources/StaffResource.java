package resources;

import entities.Staff;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.StaffService;

@Path("/staff")
public class StaffResource {

    @Inject
    StaffService staffService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffById(@PathParam("id") int id) {
        Staff staff = staffService.getStaffById(id);
        return Response.ok(staff).build();
    }
}


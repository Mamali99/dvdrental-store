package resources;

import dto.StaffDTO;
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
    private StaffService staffService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffById(@PathParam("id") int id) {
        StaffDTO staff = staffService.getStaffById(id);
        if(staff == null){
            return Response.status(Response.Status.NOT_FOUND).entity("staff not found with staff-id: " + id).build();
        }
        return Response.ok(staff).build();
    }
}


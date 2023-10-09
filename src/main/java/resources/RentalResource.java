package resources;

import entities.Rental;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rentals")
public class RentalResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRental(Rental rental) {
        // Implementierung der Logik
        return Response.created(null).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalById(@PathParam("id") int id) {
        // Implementierung der Logik
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}/returned")
    public Response terminateRental(@PathParam("id") int id) {
        // Implementierung der Logik
        return Response.ok().build();
    }
}

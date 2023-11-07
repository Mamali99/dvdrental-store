package resources;

import entities.Rental;
import dto.RentalDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.RentalService;

@Path("/rentals")
public class RentalResource {
    @Inject
    private RentalService rentalService;

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
        RentalDTO rental = rentalService.getRentalById(id);
        if(rental == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Keine rental für Rental-ID gefunden: " + id ).build();
        }
        return Response.ok(rental).build();
    }

    @PUT
    @Path("/{id}/returned")
    public Response terminateRental(@PathParam("id") int id) {
        // Implementierung der Logik
        return Response.ok().build();
    }
}

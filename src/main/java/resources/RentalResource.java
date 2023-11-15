package resources;

import entities.Rental;
import dto.RentalDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.RentalService;
import utils.RentalValue;

@Path("/rentals")
public class RentalResource {
    @Inject
    private RentalService rentalService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRental(RentalValue rentalValue) {
        // Validierung der Eingabedaten und Überprüfung der Existenz der referenzierten Entitäten
        if (!rentalService.isValidRentalValue(rentalValue)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Ungültige Eingabedaten").build();
        }

        try {
            RentalDTO rentalDTO = rentalService.createRental(rentalValue);
            // Speichern der Vermietung in der Datenbank
            return Response.status(Response.Status.CREATED).entity(rentalDTO).build();
        } catch (Exception e) {
            return Response.serverError().entity("Fehler bei der Erstellung der Vermietung").build();
        }

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

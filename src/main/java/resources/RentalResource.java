package resources;


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
        if (!rentalService.isValidRentalValue(rentalValue)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input data.").build();
        }

        try {
            RentalDTO rentalDTO = rentalService.createRental(rentalValue);

            return Response.status(Response.Status.CREATED).entity(rentalDTO).build();
        } catch (Exception e) {
            return Response.serverError().entity("Error in creating the rental.").build();
        }

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalById(@PathParam("id") int id) {
        RentalDTO rental = rentalService.getRentalById(id);
        if(rental == null){
            return Response.status(Response.Status.NOT_FOUND).entity("No rental found for Rental-ID: " + id ).build();
        }
        return Response.ok(rental).build();
    }

    @PUT
    @Path("/{id}/returned")
    public Response terminateRental(@PathParam("id") int id) {
            return rentalService.terminateRental(id);
    }
}

package resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/inventories")
public class InventoryResource {

    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoriesByFilmId(@PathParam("filmId") int filmId) {
        // Implementierung der Logik
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryById(@PathParam("id") int id) {
        // Implementierung der Logik
        return Response.ok().build();
    }
}

package resources;

import entities.Inventory;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.InventoryService;

@Path("/inventories")
public class InventoryResource {

    @Inject
    InventoryService inventoryService;

    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoriesByFilmId(@PathParam("filmId") int filmId) {

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryById(@PathParam("id") int id) {
        Inventory i = inventoryService.getInventoryById(id);
        return Response.ok(i).build();
    }
}

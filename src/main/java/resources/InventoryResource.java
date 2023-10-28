package resources;

import entities.Inventory;
import entities.InventoryDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.InventoryService;

import java.util.List;

@Path("/inventories")
public class InventoryResource {

    @Inject
    InventoryService inventoryService;

    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoriesByFilmId(@PathParam("filmId") int filmId) {

        List<InventoryDTO> inventoryList = inventoryService.getInventoriesByFilmId(filmId);
        return Response.ok(inventoryList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryById(@PathParam("id") int id) {
        Inventory i = inventoryService.getInventoryById(id);
        return Response.ok(i).build();
    }
}

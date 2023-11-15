package resources;

import dto.InventoryDTO;
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
    private InventoryService inventoryService;

    //Dieser Endpunkt liefert eine Liste von Inventaren, die mit einem bestimmten Film verknüpft sind. Sind Inventare vorhanden, deutet dies darauf hin, dass der Film möglicherweise in Vermietungen verwendet wurde.
    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoriesByFilmId(@PathParam("filmId") int filmId) {

        List<InventoryDTO> inventoryList = inventoryService.getInventoriesByFilmId(filmId);
        if (inventoryList == null || inventoryList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("Keine Inventare für Film-ID gefunden: " + filmId).build();
        }
        return Response.ok(inventoryList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryById(@PathParam("id") int id) {
        InventoryDTO dto = inventoryService.getInventoryById(id);
        if (dto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Inventar mit ID nicht gefunden: " + id).build();
        }
        return Response.ok(dto).build();
    }
}

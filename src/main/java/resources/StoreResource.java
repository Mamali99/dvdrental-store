package resources;

import dto.StoreDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.StoreService;

@Path("/stores")
public class StoreResource {

    @Inject
    private StoreService storeService;

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNumberOfStores() {
        Integer count = storeService.getNumberOfStores();
        return Response.ok(count).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreById(@PathParam("id") int id) {
        StoreDTO store = storeService.getStoreById(id);
        if(store == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Store not found with store-id: " + id).build();
        }
        return Response.ok(store).build();
    }
}

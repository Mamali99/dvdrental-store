package resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/stores")
public class StoreResource {

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNumberOfStores() {
        // Implementierung der Logik
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreById(@PathParam("id") int id) {
        // Implementierung der Logik
        return Response.ok().build();
    }
}

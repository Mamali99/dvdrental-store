package resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.HashMap;
import java.util.Map;

@Path("/")
public class RootResource {

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoot() {
        String baseUri = uriInfo.getBaseUri().toString();

        Map<String, String> paths = new HashMap<>();
        paths.put("inventories", baseUri + "inventories");
        paths.put("rentals", baseUri + "rentals");
        paths.put("staffs", baseUri + "staffs");
        paths.put("stores", baseUri + "stores");


        return Response.ok(paths).build();
    }
}
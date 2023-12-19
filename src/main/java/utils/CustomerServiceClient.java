package utils;

import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Named
public class CustomerServiceClient {
    private static final String CUSTOMER_SERVICE_URL = "http://localhost:8083/customers/";

    private final Client client;

    public CustomerServiceClient() {
        this.client = ClientBuilder.newClient();
    }

    public boolean checkCustomerExists(int customerId) {
        WebTarget target = client.target(CUSTOMER_SERVICE_URL + customerId);

        Response response = target.request(MediaType.APPLICATION_JSON).get();

        return response.getStatus() == Response.Status.OK.getStatusCode();
    }
}

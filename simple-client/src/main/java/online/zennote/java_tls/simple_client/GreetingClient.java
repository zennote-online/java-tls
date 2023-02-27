package online.zennote.java_tls.simple_client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
@RegisterRestClient(configKey = "hello-api")
public interface GreetingClient {

    @GET
    String getHello();

}

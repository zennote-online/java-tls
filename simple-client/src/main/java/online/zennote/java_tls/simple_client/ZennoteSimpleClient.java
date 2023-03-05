package online.zennote.java_tls.simple_client;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class ZennoteSimpleClient {

    private final String url;
    private final HttpClient httpClient;

    @Inject
    public ZennoteSimpleClient(@ConfigProperty(name = "simpleclient.url") final String url) {
        this.url = url;
        this.httpClient = HttpClient.newBuilder().build();
    }

    public String getHello() throws IOException, InterruptedException {
        final HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(this.url)).GET().build();
        final HttpResponse<String> httpResponse =
                this.httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

}

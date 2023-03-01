package online.zennote.java_tls.simple_client;

import io.quarkus.runtime.Startup;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
@Startup
public class SimpleClientService {

    private static final Logger LOGGER = Logger.getLogger(SimpleClientService.class);

    private final GreetingClient greetingClient;
    private final ScheduledExecutorService scheduledExecutorService;

    @Inject
    public SimpleClientService(@RestClient final GreetingClient greetingClient) {
        LOGGER.info("Creating SimpleClientService");
        this.greetingClient = greetingClient;
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
    }

    @PostConstruct
    public void post() {
        LOGGER.info("Running post construct on SimpleClientService");
        this.scheduledExecutorService.scheduleAtFixedRate(
                () -> {
                    LOGGER.info("Running getHello");
                    LOGGER.info(this.greetingClient.getHello());
                    LOGGER.info("getHello executed");
                }, 5, 5, TimeUnit.SECONDS);
    }

}

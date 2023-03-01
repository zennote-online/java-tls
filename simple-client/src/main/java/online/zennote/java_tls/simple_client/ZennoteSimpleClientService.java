package online.zennote.java_tls.simple_client;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
@Startup
public class ZennoteSimpleClientService {

    private static final Logger LOGGER = Logger.getLogger(ZennoteSimpleClientService.class);

    private final ZennoteSimpleClient zennoteSimpleClient;
    private final ScheduledExecutorService scheduledExecutorService;

    @Inject
    public ZennoteSimpleClientService(final ZennoteSimpleClient zennoteSimpleClient) {
        LOGGER.info("Creating SimpleClientService");
        this.zennoteSimpleClient = zennoteSimpleClient;
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
    }

    @PostConstruct
    public void post() {
        LOGGER.info("Running post construct on SimpleClientService");
        this.scheduledExecutorService.scheduleAtFixedRate(
                () -> {
                    LOGGER.info("Running getHello");
                    try {
                        LOGGER.info(this.zennoteSimpleClient.getHello());
                    } catch (Exception ex) {
                        LOGGER.error("Failed to get hello", ex);
                    }
                    LOGGER.info("getHello executed");
                }, 5, 5, TimeUnit.SECONDS);
    }

}

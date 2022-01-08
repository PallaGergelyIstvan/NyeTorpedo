package torpedo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import torpedo.service.Start;

/**
 * Spring Java configuration class for generic application related Spring Beans.
 *
 * @author Palla Gergely
 */
@Configuration
public class ApplicationConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Bean(initMethod = "start")
    public Start torpedo() {
        return new Start();
    }
}
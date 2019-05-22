package inventorysystem.configuration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile("!development")
@Configuration
@EnableDiscoveryClient
public class EurekaClientConfiguration {
}

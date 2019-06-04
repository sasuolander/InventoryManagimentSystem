package inventorysystem;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@EnableEurekaServer
@SpringBootApplication
public class EurekaClientApplication {
    private final Logger logger = LoggerFactory.getLogger(EurekaClientApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
    @Bean
    public CommandLineRunner initSituation() {
        return (arg) -> {
            logger.info("start");
        };
    }
}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping(value = "/test", produces = "application/json")
    @ResponseBody
    public String hello() {
        return JSONObject.quote("Server is running");
    }
}

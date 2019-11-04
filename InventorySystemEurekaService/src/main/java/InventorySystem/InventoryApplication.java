package inventorysystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@EnableEurekaServer
@SpringBootApplication
public class InventoryApplication {
    private final Logger logger = LoggerFactory.getLogger(InventoryApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }
    @Bean
    public CommandLineRunner initSituation() {
        return (arg) -> {
            logger.info("start");
        };
    }
}


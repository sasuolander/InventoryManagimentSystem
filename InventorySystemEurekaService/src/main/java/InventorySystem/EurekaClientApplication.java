package inventorysystem;

import inventorysystem.object.Order;
import inventorysystem.repository.OrderRepository;
import inventorysystem.repository.ProductRepository;
import inventorysystem.repository.PurchasesRepository;
import inventorysystem.repository.SuppliersRepository;
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
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    private final OrderRepository orderRepository;
    //private final ProductRepository productRepository;
    //private final PurchasesRepository purchasesRepository;
    //private final SuppliersRepository suppliersRepository;

    private final Logger logger = LoggerFactory.getLogger(EurekaClientApplication.class);

    public EurekaClientApplication(OrderRepository orderRepository,
                                   ProductRepository productRepository,
                                   PurchasesRepository purchasesRepository,
                                   SuppliersRepository suppliersRepository
    )

    {
        this.orderRepository = orderRepository;
        //this.productRepository = productRepository;
        //this.purchasesRepository = purchasesRepository;
        //this.suppliersRepository = suppliersRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner initSituation() {
        return (arg) -> {
            logger.info("start");
           Order tes= new Order.Builder(1L).setFirstName("tom").build();
           logger.info(tes.getFirstName());
           logger.info(orderRepository.toString());
            orderRepository.saveAndFlush(tes);


           /* ArrayList<Order> listOrder = new ArrayList<>();
            ArrayList<Product> listProduct = new ArrayList<>();
            ArrayList<Purchaces> listPurchase = new ArrayList<>();
            ArrayList<Suppliers> listSupplier = new ArrayList<>();
            Suppliers tim = new Suppliers();
            tim.setSupplier("44");
            Collections.addAll(listOrder,
                    new Order.Builder(1L).setFirstName("tom").build()
            );
            Collections.addAll(listProduct,
                    new Product.Builder(1L).setProductLabel("test").build()
            );
            Collections.addAll(listPurchase,
                    new Purchaces.Builder().setNumberReceived(10).build()
            );
            Collections.addAll(listSupplier,
                    tim
            );

            orderRepository.saveAll(listOrder);

            Order testi = orderRepository.findById(1L);
            try{
                System.out.print("testi object ");
                System.out.print(testi);
            }catch (Exception e){
                System.out.println("errol");
            }*/


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

package inventorysystem;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ServiceInstanceRestController {

    private final DiscoveryClient discoveryClient;

    @Autowired
    ServiceInstanceRestController(DiscoveryClient discoveryClient){
        this.discoveryClient = discoveryClient;
    }

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

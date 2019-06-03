package inventorysystem.controller;

import inventorysystem.ExceptionHandeling.NotFoundException;
import inventorysystem.object.Order;
import inventorysystem.object.OrderPOJO;
import inventorysystem.service.OrderServiceIml;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@Api(value = "Order", tags = {"Order"})
public class OrderControllerIml implements BaseController<Order,OrderPOJO> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderControllerIml.class);

   private final OrderServiceIml orderServiceIml;

    @Autowired
    public OrderControllerIml(OrderServiceIml orderServiceIml){
        this.orderServiceIml = orderServiceIml;
    }

    @GetMapping(path = "order/{id}")
    public Order findById(@PathVariable Long id) throws NotFoundException {
        Optional<Order> order= orderServiceIml.findById(id);
        if(!order.isPresent()){ throw  NotFoundException.createWith("order"); }
    return order.get();
    }

    @GetMapping(path = "orders")
    public Iterable<Order> findAll() throws NotFoundException{
       Iterable<Order> orders= orderServiceIml.findAll();
       if(0<StreamSupport.stream(orders.spliterator(),false).count()){
           return orders;
       }else{
           throw NotFoundException.createWith("orders");
       }
    }

    @PostMapping(path = "order")
    public HttpStatus save(@RequestBody OrderPOJO orderPOJO) {
        Order order= new Order();
        try {
            LOGGER.info("OrderPojo" +orderPOJO.getOrderId().toString());
            order.translatePojoToPersistant(orderPOJO);
            LOGGER.info(order.getFirstName());
            Order SAvedOrder =orderServiceIml.save(order);
            LOGGER.info(SAvedOrder.getOrderId().toString());


            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @DeleteMapping(path = "order/{id}")
    public boolean delete(@PathVariable Long id) {
        orderServiceIml.delete(id);
        return true;
    }
    @PatchMapping(path="order")
    public Order update(@RequestBody OrderPOJO orderPojo) {
        Order order = null;
        orderServiceIml.update(order.translatePojoToPersistant(orderPojo));
        return orderServiceIml.findById(order.getOrderId()).get();
    }
}

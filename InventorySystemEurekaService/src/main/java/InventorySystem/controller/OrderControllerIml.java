package inventorysystem.controller;

import inventorysystem.object.Order;
import inventorysystem.service.OrderServiceIml;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(value = "Order", tags = {"Order"})
public class OrderControllerIml implements BaseController<Order> {


   private final OrderServiceIml orderServiceIml;

    @Autowired
    public OrderControllerIml(OrderServiceIml orderServiceIml){
        this.orderServiceIml = orderServiceIml;
    }

    @GetMapping(path = "order/{id}")
    public Order findById(@PathVariable Long id) {
        return orderServiceIml.findById(id).get();
    }

    @GetMapping(path = "orders")
    public Iterable<Order> findAll() {
        return orderServiceIml.findAll();
    }
    @PostMapping(path = "order")
    public <S extends Order> S save( @RequestBody S order) {
        orderServiceIml.save(order);
        return null;
    }
    @DeleteMapping(path = "order/{id}")
    public boolean delete(@PathVariable Long id) {
        orderServiceIml.delete(id);
        return true;
    }
    @PatchMapping(path="order")
    public Order update(@RequestBody Order order) {
        orderServiceIml.update(order);
        return orderServiceIml.findById(order.getOrderId()).get();
    }
}

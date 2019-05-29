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
    public Optional<Order> findById(@PathVariable Long id) {
        orderServiceIml.findById(id);
        return Optional.empty();
    }
    @PostMapping(path = "order")
    public <S extends Order> S save( @RequestBody S order) {
        orderServiceIml.save(order);
        return null;
    }
    @DeleteMapping(path = "order/{id}")
    public boolean delete(@PathVariable Long id) {
        orderServiceIml.delete(id);
        return false;
    }
    @PatchMapping(path="order")
    public boolean update(@RequestBody Order order) {
        orderServiceIml.update(order);
        return false;
    }
}

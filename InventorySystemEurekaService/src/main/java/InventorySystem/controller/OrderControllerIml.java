package inventorysystem.controller;

import inventorysystem.exceptionhandeling.NotFoundException;
import inventorysystem.object.entity.Order;
import inventorysystem.object.pojo.OrderPOJO;
import inventorysystem.service.OrderServiceIml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@Api(value = "Order", tags = {"Order"})
public class OrderControllerIml implements BaseController<Order, OrderPOJO> {

    private final OrderServiceIml orderServiceIml;

    @Autowired
    public OrderControllerIml(OrderServiceIml orderServiceIml) {
        this.orderServiceIml = orderServiceIml;
    }

    @ApiOperation(value = "Find order by ID")
    @GetMapping(path = "order/{id}")
    public Order findById(@PathVariable String id) throws NotFoundException {
        Optional<Order> order = orderServiceIml.findByOrderId(id);
        if (!order.isPresent()) {
            throw NotFoundException.createWith("order");
        }
        return order.get();
    }

    @ApiOperation(value = "Find all orders")
    @GetMapping(path = "orders")
    public Iterable<Order> findAll() throws NotFoundException {
        Iterable<Order> order = orderServiceIml.findAll();
        if (0 < StreamSupport.stream(order.spliterator(), false).count()) {
            return order;
        } else {
            throw NotFoundException.createWith("orders");
        }
    }

    @ApiOperation(value = "Find all orders by defining page size")
    @GetMapping(path = "orders/p")
    public Iterable<Order> findAllPaginationSorting(@RequestParam int page, @RequestParam int pageSize) throws NotFoundException {
        //Iterable<Order> orders;
        Iterable<Order> order = orderServiceIml.findAllPage(page, pageSize);
        if (0 < StreamSupport.stream(order.spliterator(), false).count()) {
            return order;
        } else {
            throw NotFoundException.createWith("orders");
        }
    }

    @ApiOperation(value = "Create new order")
    @PostMapping(path = "order")
    public HttpStatus save(@RequestBody OrderPOJO orderPOJO) {
        Order order = new Order();
        try {
            order.translatePojoToPersistent(orderPOJO);
            orderServiceIml.save(order);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @ApiOperation(value = "Remove order")
    @DeleteMapping(path = "order/{id}")
    public boolean delete(@PathVariable String id) {
        orderServiceIml.delete(id);
        return true;
    }

    @ApiOperation(value = "Update old order")
    @PatchMapping(path = "order")
    public Order update(@RequestBody OrderPOJO orderPojo) throws NotFoundException {

        Order order = new Order().translatePojoToPersistent(orderPojo);
        if (!orderServiceIml.findByOrderId(order.getOrderId()).isPresent()) {
            throw NotFoundException.createWith("Order");
        }
        orderServiceIml.update(order);

        return orderServiceIml.findByOrderId(order.getOrderId()).get();
    }
}

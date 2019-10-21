package inventorysystem.controller;

import inventorysystem.exceptionhandeling.NotFoundException;
import inventorysystem.object.entity.Order;
import inventorysystem.object.pojo.OrderPOJO;
import inventorysystem.service.OrderServiceIml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @ApiOperation(value = "Find order by ID")
    @GetMapping(path = "order/{id}")
    public Order findById(@PathVariable Long id) throws NotFoundException {
        Optional<Order> order= orderServiceIml.findById(id);
        if(!order.isPresent()){ throw  NotFoundException.createWith("order"); }
    return order.get();
    }

    @ApiOperation(value = "Find all orders")
    @GetMapping(path = "orders")
    public Iterable<Order> findAll() throws NotFoundException{
       Iterable<Order> orders= orderServiceIml.findAll();
       if(0<StreamSupport.stream(orders.spliterator(),false).count()){
           return orders;
       }else{
           throw NotFoundException.createWith("orders");
       }
    }
    @ApiOperation(value = "Find all orders by defining page size")
    @GetMapping(path = "orders/page")
    public Iterable<Order> findAllPaginationSorting(@RequestParam int page,@RequestParam int pageSize ) throws NotFoundException {
        //Iterable<Order> orders;
        return  orderServiceIml.findAllPage(page,pageSize);
    }

    @ApiOperation(value = "Create new order")
    @PostMapping(path = "order")
    public HttpStatus save(@RequestBody OrderPOJO orderPOJO) {
        Order order= new Order();
        try {
            order.translatePojoToPersistent(orderPOJO);
            orderServiceIml.save(order);
            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @ApiOperation(value = "Remove order")
    @DeleteMapping(path = "order/{id}")
    public boolean delete(@PathVariable Long id) {
        orderServiceIml.delete(id);
        return true;
    }
    @ApiOperation(value = "Update old order")
    @PatchMapping(path="order")
    public Order update(@RequestBody OrderPOJO orderPojo) throws NotFoundException {
        Order order = new Order();
        orderServiceIml.update(order.translatePojoToPersistent(orderPojo));
        if (!orderServiceIml.findById(order.getOrderId()).isPresent()){
            throw NotFoundException.createWith("Order");
        }
        return orderServiceIml.findById(order.getOrderId()).get();
    }
}

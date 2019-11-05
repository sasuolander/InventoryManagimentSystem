package inventorysystem.controller;

import inventorysystem.exceptionhandeling.NotFoundException;
import inventorysystem.object.entity.Product;
import inventorysystem.object.pojo.ProductPOJO;
import inventorysystem.service.ProductServiceIml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@Api(value = "Product", tags = {"Product"})
public class ProductControllerIml implements BaseController<Product, ProductPOJO> {

    private final ProductServiceIml productServiceIml;

    @Autowired
    public ProductControllerIml(ProductServiceIml productServiceIml) {
        this.productServiceIml = productServiceIml;
    }

    @ApiOperation(value = "Find product by ID")
    @GetMapping(path = "product/{id}")
    public Product findById(@PathVariable String id) throws NotFoundException {
        Optional<Product> product = productServiceIml.findByProductId(id);
        if (!product.isPresent()) {
            throw NotFoundException.createWith("product");
        }
        return product.get();
    }

    @ApiOperation(value = "Find all products")
    @GetMapping(path = "products")
    public Iterable<Product> findAll() throws NotFoundException {
        Iterable<Product> product = productServiceIml.findAll();
        if (0 < StreamSupport.stream(product.spliterator(), false).count()) {
            return product;
        } else {
            throw NotFoundException.createWith("products");
        }
    }

    @ApiOperation(value = "Find all products by defining page size")
    @GetMapping(path = "products/p")
    public Iterable<Product> findAllPaginationSorting(@RequestParam int page, @RequestParam int pageSize) throws NotFoundException {
        Iterable<Product> product = productServiceIml.findAllPage(page, pageSize);
        if (0 < StreamSupport.stream(product.spliterator(), false).count()) {
            return product;
        } else {
            throw NotFoundException.createWith("products");
        }
    }

    @ApiOperation(value = "Create new Product")
    @PostMapping(path = "product")
    public HttpStatus save(@RequestBody ProductPOJO productPOJO) {
        Product product = new Product();
        try {
            product.translatePojoToPersistent(productPOJO);
            productServiceIml.save(product);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @ApiOperation(value = "Remove product")
    @DeleteMapping(path = "product/{id}")
    public boolean delete(@PathVariable String id) {
        productServiceIml.delete(id);
        return true;
    }

    @ApiOperation(value = "Update old product")
    @PatchMapping(path = "product")
    public Product update(@RequestBody ProductPOJO productPOJO) throws NotFoundException {
        Product product = new Product();
        productServiceIml.update(product.translatePojoToPersistent(productPOJO));
        if (!productServiceIml.findByProductId(product.getProductId()).isPresent()) {
            throw NotFoundException.createWith("product");
        }
        return productServiceIml.findByProductId(product.getProductId()).get();
    }

}
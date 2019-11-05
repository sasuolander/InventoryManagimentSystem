package inventorysystem.controller;

import inventorysystem.exceptionhandeling.NotFoundException;
import inventorysystem.object.entity.Supplier;
import inventorysystem.object.pojo.SupplierPOJO;
import inventorysystem.service.SupplierServiceIml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@Api(value = "Supplier", tags = {"Supplier"})
public class SupplierControllerIml implements BaseController<Supplier, SupplierPOJO> {

    private final SupplierServiceIml supplierServiceIml;

    @Autowired
    public SupplierControllerIml(SupplierServiceIml supplierServiceIml) {
        this.supplierServiceIml = supplierServiceIml;
    }

    @ApiOperation(value = "Find supplier by ID")
    @GetMapping(path = "supplier/{id}")
    public Supplier findById(@PathVariable String id) throws NotFoundException {
        Optional<Supplier> supplier = supplierServiceIml.findBySupplierId(id);
        if (!supplier.isPresent()) {
            throw NotFoundException.createWith("supplier");
        }
        return supplier.get();
    }

    @ApiOperation(value = "Find all suppliers")
    @GetMapping(path = "suppliers")
    public Iterable<Supplier> findAll() throws NotFoundException {
        Iterable<Supplier> supplier = supplierServiceIml.findAll();
        if (0 < StreamSupport.stream(supplier.spliterator(), false).count()) {
            return supplier;
        } else {
            throw NotFoundException.createWith("suppliers");
        }
    }

    @ApiOperation(value = "Find all suppliers by defining page size")
    @GetMapping(path = "suppliers/p")
    public Iterable<Supplier> findAllPaginationSorting(@RequestParam int page, @RequestParam int pageSize) throws NotFoundException {
        Iterable<Supplier> supplier = supplierServiceIml.findAllPage(page, pageSize);
        if (0 < StreamSupport.stream(supplier.spliterator(), false).count()) {
            return supplier;
        } else {
            throw NotFoundException.createWith("suppliers");
        }
    }

    @ApiOperation(value = "Create new supplier")
    @PostMapping(path = "supplier")
    public HttpStatus save(@RequestBody SupplierPOJO supplierPOJO) {
        Supplier supplier = new Supplier();
        try {
            supplier.translatePojoToPersistent(supplierPOJO);
            supplierServiceIml.save(supplier);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @ApiOperation(value = "Remove supplier")
    @DeleteMapping(path = "supplier/{id}")
    public boolean delete(@PathVariable String id) {
        supplierServiceIml.delete(id);
        return true;
    }

    @ApiOperation(value = "Update old supplier")
    @PatchMapping(path = "supplier")
    public Supplier update(@RequestBody SupplierPOJO supplierPOJO) throws NotFoundException {
        Supplier supplier = new Supplier();
        supplierServiceIml.update(supplier.translatePojoToPersistent(supplierPOJO));
        if (!supplierServiceIml.findBySupplierId(supplier.getSupplierId()).isPresent()) {
            throw NotFoundException.createWith("supplier");
        }
        return supplierServiceIml.findBySupplierId(supplier.getSupplierId()).get();
    }
}
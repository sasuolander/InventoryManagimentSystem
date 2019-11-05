package inventorysystem.controller;

import inventorysystem.exceptionhandeling.NotFoundException;
import inventorysystem.object.entity.Purchase;
import inventorysystem.object.pojo.PurchasePOJO;
import inventorysystem.service.PurchaseServiceIml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@Api(value = "Purchase", tags = {"Purchase"})
public class PurchaseControllerIml implements BaseController<Purchase, PurchasePOJO> {

    private final PurchaseServiceIml purchaseServiceIml;

    @Autowired
    public PurchaseControllerIml(PurchaseServiceIml purchaseServiceIml) {
        this.purchaseServiceIml = purchaseServiceIml;
    }

    @ApiOperation(value = "Find purchase by ID")
    @GetMapping(path = "purchase/{id}")
    public Purchase findById(@PathVariable String id) throws NotFoundException {
        Optional<Purchase> purchase = purchaseServiceIml.findByPurchaseId(id);
        if (!purchase.isPresent()) {
            throw NotFoundException.createWith("purchase");
        }
        return purchase.get();
    }

    @ApiOperation(value = "Find all purchases")
    @GetMapping(path = "purchases")
    public Iterable<Purchase> findAll() throws NotFoundException {
        Iterable<Purchase> purchase = purchaseServiceIml.findAll();
        if (0 < StreamSupport.stream(purchase.spliterator(), false).count()) {
            return purchase;
        } else {
            throw NotFoundException.createWith("purchases");
        }
    }

    @ApiOperation(value = "Find all purchases by defining page size")
    @GetMapping(path = "purchases/p")
    public Iterable<Purchase> findAllPaginationSorting(@RequestParam int page, @RequestParam int pageSize) throws NotFoundException {
        Iterable<Purchase> purchase = purchaseServiceIml.findAllPage(page, pageSize);
        if (0 < StreamSupport.stream(purchase.spliterator(), false).count()) {
            return purchase;
        } else {
            throw NotFoundException.createWith("purchases");
        }
    }

    @ApiOperation(value = "Create new purchase")
    @PostMapping(path = "purchase")
    public HttpStatus save(@RequestBody PurchasePOJO purchasePOJO) {
        Purchase purchase = new Purchase();
        try {
            purchase.translatePojoToPersistent(purchasePOJO);
            purchaseServiceIml.save(purchase);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @ApiOperation(value = "Remove purchase")
    @DeleteMapping(path = "purchase/{id}")
    public boolean delete(@PathVariable String id) {
        purchaseServiceIml.delete(id);
        return true;
    }

    @ApiOperation(value = "Update old purchase")
    @PatchMapping(path = "purchase")
    public Purchase update(@RequestBody PurchasePOJO purchasePOJO) throws NotFoundException {
        Purchase purchase = new Purchase();
        purchaseServiceIml.update(purchase.translatePojoToPersistent(purchasePOJO));
        if (!purchaseServiceIml.findByPurchaseId(purchase.getPurchaseId()).isPresent()) {
            throw NotFoundException.createWith("purchase");
        }
        return purchaseServiceIml.findByPurchaseId(purchase.getPurchaseId()).get();
    }
}
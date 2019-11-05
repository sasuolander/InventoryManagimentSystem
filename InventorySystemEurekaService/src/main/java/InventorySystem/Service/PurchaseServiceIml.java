package inventorysystem.service;

import inventorysystem.object.entity.Purchase;
import inventorysystem.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PurchaseServiceIml implements BasicService<Purchase> {

    private final PurchaseRepository repository;

    @Autowired
    public PurchaseServiceIml(PurchaseRepository repository) {
        this.repository = repository;
    }

    public Optional<Purchase> findById(Long id) {
        return repository.findById(id);
    }
    public Optional<Purchase> findByPurchaseId(String id) {
        return repository.findByPurchaseId(id);
    }

    public Iterable<Purchase> findAll() {
        return repository.findAll();
    }

    public Iterable<Purchase> findAllPage(int numberPage, int size) {

        Pageable pageConfig = PageRequest.of(numberPage, size);
        return repository.findAll(pageConfig);
    }

    public Purchase save(Purchase purchase) {
        Purchase savedPurchase = repository.save(purchase);
        return savedPurchase;
    }

    @Transactional
    public boolean delete(String id) {
        repository.deleteByPurchaseId(id);
        return true;
    }

    public boolean update(Purchase purchase) {
        Optional<Purchase> oldPurchase = repository.findByPurchaseId(purchase.getPurchaseId());
        if (!oldPurchase.isPresent()) {
            return false;
        }
        repository.save(purchase);
        return true;
    }
}
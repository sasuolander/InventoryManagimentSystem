package inventorysystem.service;

import inventorysystem.object.entity.Supplier;
import inventorysystem.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SupplierServiceIml implements BasicService<Supplier> {

    private final SupplierRepository repository;

    @Autowired
    public SupplierServiceIml(SupplierRepository repository) {
        this.repository = repository;
    }

    public Optional<Supplier> findById(Long id) {
        return repository.findById(id);
    }
    public Optional<Supplier> findBySupplierId(String id) {
        return repository.findBySupplierId(id);
    }

    public Iterable<Supplier> findAll() {
        return repository.findAll();
    }

    public Iterable<Supplier> findAllPage(int numberPage, int size) {

        Pageable pageConfig = PageRequest.of(numberPage, size);
        return repository.findAll(pageConfig);
    }

    public Supplier save(Supplier supplier) {
        Supplier savedSupplier = repository.save(supplier);
        return savedSupplier;
    }

    @Transactional
    public boolean delete(String id) {
        repository.deleteBySupplierId(id);
        return true;
    }

    public boolean update(Supplier supplier) {
        Optional<Supplier> oldSupplier = repository.findBySupplierId(supplier.getSupplierId());
        if (!oldSupplier.isPresent()) {
            return false;
        }
        repository.save(supplier);
        return true;
    }
}
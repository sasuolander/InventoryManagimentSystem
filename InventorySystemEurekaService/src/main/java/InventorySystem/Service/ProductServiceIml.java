package inventorysystem.service;

import inventorysystem.object.entity.Product;
import inventorysystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductServiceIml implements BasicService<Product> {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceIml(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
    public Optional<Product> findByProductId(String id) {
        return repository.findByProductId(id);
    }

    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    public Iterable<Product> findAllPage(int numberPage, int size) {

        Pageable pageConfig = PageRequest.of(numberPage, size);
        return repository.findAll(pageConfig);
    }

    public Product save(Product product) {
        Product SavedProduct = repository.save(product);
        return SavedProduct;
    }

    @Transactional
    public boolean delete(String id) {
        repository.deleteByProductId(id);
        return true;
    }

    public boolean update(Product product) {
        Optional<Product> oldProduct = repository.findByProductId(product.getProductId());
        if (!oldProduct.isPresent()) {
            return false;
        }
        repository.save(product);
        return true;
    }
}
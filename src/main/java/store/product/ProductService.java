package store.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(ProductIn in) {
        var model = new ProductModel();
        model.setName(in.name());
        model.setPrice(in.price());
        model.setUnit(in.unit());
        var saved = repository.save(model);
        return ProductParser.toProduct(saved);
    }

    public List<Product> findAll() {
        var out = new ArrayList<Product>();
        repository.findAll().forEach(m -> out.add(ProductParser.toProduct(m)));
        return out;
    }

    public Optional<Product> findById(String id) {
        return repository.findById(id).map(ProductParser::toProduct);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}

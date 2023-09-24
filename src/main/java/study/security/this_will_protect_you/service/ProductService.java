package study.security.this_will_protect_you.service;

import org.springframework.stereotype.Service;
import study.security.this_will_protect_you.entity.Product;
import study.security.this_will_protect_you.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}

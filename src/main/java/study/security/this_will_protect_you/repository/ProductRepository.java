package study.security.this_will_protect_you.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.security.this_will_protect_you.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

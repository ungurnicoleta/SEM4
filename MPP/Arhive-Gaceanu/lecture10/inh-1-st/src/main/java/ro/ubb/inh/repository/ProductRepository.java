package ro.ubb.inh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.inh.model.Product;

/**
 * author: radu
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}

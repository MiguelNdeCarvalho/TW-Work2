package org.pingu.shop.jpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
    Product findById(long id);
    List<Product> findByNameContainingIgnoreCase(String name);
}
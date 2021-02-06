package org.pingu.shop.jpa;


import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
    Product findById(long id);
    Product findByNameContainingIgnoreCase(String name);
}
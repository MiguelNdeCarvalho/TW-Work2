package org.pingu.shop.jpa;


import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
	Orders findById(long id);
}
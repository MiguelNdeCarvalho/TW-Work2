package org.pingu.shop.jpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
	Orders findById(long id);
	List<Orders> findByUser(User user);
}
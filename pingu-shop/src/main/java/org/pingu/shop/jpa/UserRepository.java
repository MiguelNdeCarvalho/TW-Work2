package org.pingu.shop.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByFirstName(String firstName);

	User findById(long id);
}
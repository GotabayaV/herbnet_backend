package com.gotabaya.herbnet.repository;

import com.gotabaya.herbnet.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {
	Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);

	boolean existsUserByEmail(String email);
}
package com.fdmgroup.springbootbookstore.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdmgroup.springbootbookstore.model.User;

	@Repository
	public interface UserRepository extends JpaRepository<User, Integer> {
		Optional<User> findByUsername(String username);

		User findByEmail(String userEmail);

}

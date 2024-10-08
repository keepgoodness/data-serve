package com.dataserve.repo;

import com.dataserve.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}

package com.dataserve.repo;

import com.dataserve.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String name);
}

package com.dataserve.service;

import com.dataserve.domain.Role;
import com.dataserve.domain.User;

import java.util.List;

public interface UserService {
	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	User getUser(String username);

	List<User> getUsers();
}

package com.fdmgroup.springbootbookstore.service;

import com.fdmgroup.springbootbookstore.model.Role;

public interface RoleService {

	Role findByRoleName(String string);

	void addRole(Role role);
}


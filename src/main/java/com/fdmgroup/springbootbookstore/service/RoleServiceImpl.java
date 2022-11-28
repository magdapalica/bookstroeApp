package com.fdmgroup.springbootbookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.springbootbookstore.model.Role;
import com.fdmgroup.springbootbookstore.repository.RoleRepository;
import com.fdmgroup.springbootbookstore.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repo;

	@Override
	public Role findByRoleName(String rolename) {
		return repo.findByRolename(rolename);
	}

	@Override
	public void addRole(Role role) {
		repo.save(role);
	}

}
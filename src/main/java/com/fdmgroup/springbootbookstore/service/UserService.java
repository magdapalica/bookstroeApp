package com.fdmgroup.springbootbookstore.service;

import com.fdmgroup.springbootbookstore.model.User;

public interface UserService {

	User getCurrentUser(String username);
	
	User updateUser(User user);
	
}

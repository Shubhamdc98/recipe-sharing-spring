package com.shubham.service;

import com.shubham.exception.UserException;
import com.shubham.model.User;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException;

}

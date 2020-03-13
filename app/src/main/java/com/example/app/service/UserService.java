package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.User;
import com.example.app.mappers.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper repository;

	public List<User> searchUser(String id, String password) {
		List<User> list= repository.findName(id, password);

		return list;
	}

}

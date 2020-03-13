package com.example.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.domain.User;
import com.example.app.mappers.ErrorMapper;
import com.example.app.service.UserService;

@RestController
public class UserCotroller {

	@Autowired
	UserService service;

	@Autowired
	ErrorMapper error;

	@SuppressWarnings("null")
	@RequestMapping(path = "/user", method = RequestMethod.POST)

	public ModelAndView index(ModelAndView modelView,@RequestParam(name = "userId")String userId,
			@RequestParam(name = "password",required = false)String password) {
		HttpSession session = null;

		if(!service.searchUser(userId, password).isEmpty()) {
			List<User> list = new ArrayList<User>();
			list = service.searchUser(userId, password);
			session.setAttribute("list", list);
			modelView.setViewName("redirect:/index");
		}else {
			String msg = "間違っています";
			modelView.addObject("msg",msg);
			modelView.setViewName("/user");
		}
		return modelView;
	}
}

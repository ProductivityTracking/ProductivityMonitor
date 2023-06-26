package com.pennant.prodmtr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.service.Interface.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(Model model) {
		return "login";
	}

	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String verifyUser(@Validated User user, Model model, HttpSession session) {
		System.out.println("Users data");
		String page = userService.verifyUser(user,session);
		return page;
	}

	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public String a(Model model, HttpSession session) {
		User user = new User();
		user.setUserEmployeeId("1");
		user.setUserDisplayName("bhargav");
		user.setUserPassword("hello");

		session.setAttribute("user", user);
		return "a";
	}

	@RequestMapping(value = "getEmail", method = RequestMethod.GET)
	public String getEmail(Model model, HttpSession session) {
		User user = new User();
		user.setUserEmployeeId("1");
		user.setUserDisplayName("bhargav");
		user.setUserPassword("hello");
		session.setAttribute("user", user);
		return "a";
	}

}

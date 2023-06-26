package com.pennant.prodmtr.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pennant.prodmtr.model.Entity.Subtask;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.service.Interface.UserService;


@Controller
public class ProductivityController {
	UserService userService;

	/*
	 * @Autowired Profdao profService;
	 */

	@Autowired
	public ProductivityController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/productivity", method = RequestMethod.GET)
	public String getIndex(Model model) {
		return "productivity";
	}

	@RequestMapping(value = "/prod", method = RequestMethod.GET)
	public String getIndexAlternative(Model model) {
		return "productivity";
	}

	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public String dash(Model model) {
		return "dash";
	}

	@RequestMapping(value = "/pastdue", method = RequestMethod.GET)
	public String pastdue(Model model) {
		return "pastdue";
	}

	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public String resource(Model model) {
		return "AddResource";
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String project(Model model) {
		System.out.println("project called");
		return "project";
	}

	// @RequestMapping(value = "/sprint", method = RequestMethod.GET)
	// public String sprint(Model model) {
	// System.out.println("project called");
	// return "sprint_home";
	// }

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getdashboard(Model model) {
		System.out.println("project called");
		return "dashboard";
	}

	@RequestMapping(value = "/analytics", method = RequestMethod.GET)
	public String getanalytics(Model model) {
		System.out.println("project called");
		return "analytics";
	}

	@RequestMapping(value = "/backlog", method = RequestMethod.GET)
	public String getmodules(Model model) {
		System.out.println("backlog called");
		return "backlog";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getprofile(Model model) {
		System.out.println("profile called");
		// List<User> User = ProfileService.getProfile(id);
		return "profile";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String getedit(Model model, @RequestParam("id") Integer id) {
		System.out.println("edit requested");
		model.addAttribute("id", id);
		return "edit";
	}

	@RequestMapping(value = "/editsuccess", method = RequestMethod.POST)
	public String geteditsuccess(Model model, @RequestParam("id") Integer id,
			@RequestParam("Password") String Password) {
		System.out.println("editsuccess");
		userService.UpdatePassword(id, Password);
		model.addAttribute("id", id);
		return "edit";
	}

	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public String getActivity(Model model, HttpSession session) {
		System.out.println("Called Activity jsp");
		User user = (User) session.getAttribute("user");
		List<Task> activiyTasks = userService.getUserActivities(user.getUserRole());
		List<Subtask> activiySubTasks = userService.getUserSubtaskActivities(user.getUserRole());
		model.addAttribute("activityTasks", activiyTasks);
		model.addAttribute("activitySubTasks", activiySubTasks);
		return "activity";
	}
}
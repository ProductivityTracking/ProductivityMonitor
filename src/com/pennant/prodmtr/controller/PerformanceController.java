package com.pennant.prodmtr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.UserDto;
import com.pennant.prodmtr.model.Entity.Role;
import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.service.Interface.ProjectService;
import com.pennant.prodmtr.service.Interface.ProjectTaskService;
import com.pennant.prodmtr.service.Interface.ResourceService;
import com.pennant.prodmtr.service.Interface.RoleService;
import com.pennant.prodmtr.service.Interface.TaskService;

@Controller
public class PerformanceController {
	private final ResourceService resourceService;
	private final ProjectService projectService;
	private final RoleService roleService;
	private final TaskService taskService;
	private final ProjectTaskService projectTaskService;

	@Autowired
	private User user;

	@Autowired
	private Role role;

	@Autowired
	public PerformanceController(ResourceService resourceService, ProjectService projectService,
			RoleService roleService, TaskService taskService, ProjectTaskService projectTaskService) {
		this.resourceService = resourceService;
		this.projectService = projectService;
		this.roleService = roleService;
		this.taskService = taskService;
		this.projectTaskService = projectTaskService;

	}

	@RequestMapping(value = "/performance", method = RequestMethod.GET)
	public String getAllPerformance(Model model) {
		List<UserDto> resources = resourceService.getAllResources();
		List<ProjectDto> projects = projectService.getAllProjects(); // Retrieve all projects
		List<Role> roles = roleService.getAllRoles(); // Retrieve all roles

		// Calculate performance score, hours worked, and tasks completed for each resource
		for (UserDto resource : resources) {
			int completedTasks = taskService.getCompletedTasksByUserId(resource.getUserId());
			int totalTasks = taskService.getTotalTasksByUserId(resource.getUserId());
			System.out.println("resource name is " + resource.getUserDisplayName());
			int completedProjectTasks = projectTaskService.getCompletedTasksByUserId(resource.getUserId());
			int totalProjectTasks = projectTaskService.getTotalTasksByUserId(resource.getUserId());

			completedTasks = completedTasks + completedProjectTasks;
			totalProjectTasks = totalProjectTasks + totalProjectTasks;
			double performanceScore = taskService.calculatePerformanceScore(completedTasks, totalTasks);

			System.out.println("performance score is " + performanceScore);
			// Retrieve hours worked and tasks completed
			double hoursWorked = taskService.getHoursWorkedByUserId(resource.getUserId());

			resource.setPerformanceScore(performanceScore);
			resource.setHoursWorked(hoursWorked);
			resource.setTasksCompleted(completedTasks);
			System.out.println("total tasks " + totalTasks);
			resource.setTotalTasks(totalProjectTasks);

			model.addAttribute("resources", resources);

		}
		return "Performance";
	}
}
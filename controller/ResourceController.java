package com.pennant.prodmtr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.ResTaskFilter;
import com.pennant.prodmtr.model.Dto.ResourceFilter;
import com.pennant.prodmtr.model.Dto.TaskDto;
import com.pennant.prodmtr.model.Dto.UserDto;
import com.pennant.prodmtr.model.Entity.Role;
import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.model.Input.UserInput;
import com.pennant.prodmtr.model.view.TaskCountview;
import com.pennant.prodmtr.service.Interface.ProjectService;
import com.pennant.prodmtr.service.Interface.ResourceService;
import com.pennant.prodmtr.service.Interface.RoleService;
import com.pennant.prodmtr.service.Interface.TaskService;

@Controller
public class ResourceController {
	private final ResourceService resourceService;
	private final ProjectService projectService;
	private final RoleService roleService;
	private final TaskService taskService;

	@Autowired
	private User user;

	@Autowired
	private Role role;

	@Autowired
	public ResourceController(ResourceService resourceService, ProjectService projectService, RoleService roleService,
			TaskService taskService) {
		this.resourceService = resourceService;
		this.projectService = projectService;
		this.roleService = roleService;
		this.taskService = taskService;
	}

	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public String getAllResources(Model model) {
		List<UserDto> resources = resourceService.getAllResources();
		List<ProjectDto> projects = projectService.getAllProjects(); // Retrieve all projects
		List<Role> roles = roleService.getAllRoles(); // Retrieve all roles

		// Calculate performance score, hours worked, and tasks completed for each resource
		for (UserDto resource : resources) {
			int completedTasks = taskService.getCompletedTasksByUserId(resource.getUserId());
			int totalTasks = taskService.getTotalTasksByUserId(resource.getUserId());
			double performanceScore = taskService.calculatePerformanceScore(completedTasks, totalTasks);

			// Retrieve hours worked and tasks completed
			double hoursWorked = taskService.getHoursWorkedByUserId(resource.getUserId());

			resource.setPerformanceScore(performanceScore);
			resource.setHoursWorked(hoursWorked);
			resource.setTasksCompleted(completedTasks);
		}

		model.addAttribute("resources", resources);
		model.addAttribute("projects", projects);
		model.addAttribute("roles", roles);

		return "ResourceHome";
	}

	@RequestMapping(value = "/resources/filter", method = RequestMethod.GET)
	@ResponseBody
	public String filterResources(@Validated ResourceFilter ResourceFilter, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// Handle validation errors
			// Return appropriate error response
			return "Validation Error";
		}
		System.out.println(ResourceFilter.getProjectFilter());
		System.out.println(ResourceFilter.getRoleFilter());
		List<UserDto> filteredResources = resourceService.filterResources(ResourceFilter);
		Gson gson = new Gson();
		String json = gson.toJson(filteredResources);
		return json;
	}

	@RequestMapping(value = "/resources/details", method = RequestMethod.GET)
	public String getResourceDetails(@RequestParam(name = "displayName") String displayName, Model model) {

		System.out.println(displayName);
		User resource = resourceService.getResourceByDisplayName(displayName);
		model.addAttribute("resource", resource);

		System.out.println(resource.userEmployeeId);
		return "user_details";
	}

	@RequestMapping(value = "/resources/update", method = RequestMethod.GET)
	public String updateResource(@RequestParam("displayName") String displayName, Model model) {
		User resource = resourceService.getResourceByDisplayName(displayName);
		List<Role> roles = roleService.getAllRoles();

		model.addAttribute("resource", resource);
		model.addAttribute("roles", roles);

		return "update_resource";
	}

	@RequestMapping(value = "/resources/updateSuccess", method = RequestMethod.POST)
	public String updateResource(@Validated UserInput userinput) {
		// Retrieve the existing resource from the database using the original display name

		// Save the updated resource
		resourceService.save(userinput);

		// Redirect to the resources page or show a success message
		return "redirect:/resources";
	}

	@RequestMapping(value = "/resources/AddResource", method = RequestMethod.GET)
	public String addResource(Model model) {
		// Add necessary logic
		List<Role> roles = (List<Role>) roleService.getAllRoles();
		model.addAttribute("roles", roles);
		return "AddResource";
	}

	@RequestMapping(value = "/resources/addSuccess", method = RequestMethod.POST)
	public String addResource(@Validated UserInput userinput, Model model) {

		userinput.setUserCreationDate(new Date()); // Set current date as the creation date
		userinput.setUserLastUpdatedDate(new Date());

		// Set last updated date as null
		// user.setUserRole(roleid);

		// System.out.println("role is " + roleid);
		System.out.println("role is " + userinput.getUserId());
		System.out.println("role is " + userinput.getUserRole());
		resourceService.addUser(userinput);
		return "redirect:/resources";
	}

	@RequestMapping(value = "/resources/tasks", method = RequestMethod.GET)
	public String viewTasksForUser(@RequestParam("userId") int userId, Model model) {
		// Assuming you have a method in your service layer to retrieve tasks by user ID
		List<TaskDto> tasks = taskService.getTasksByUserId(userId);
		List<ProjectDto> projects = projectService.getAllProjects();

		// Group tasks by project ID and count the number of tasks per project
		Map<Integer, Integer> projectTaskCount = new HashMap<>();
		for (TaskDto task : tasks) {
			Integer projectId = task.getProjectId();
			int count = projectTaskCount.getOrDefault(projectId, 0);
			projectTaskCount.put(projectId, count + 1);
		}

		List<TaskCountview> taskCountList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : projectTaskCount.entrySet()) {
			int projectId = entry.getKey();
			int taskCount = entry.getValue();
			TaskCountview taskCountDto = new TaskCountview(projectId, taskCount);
			taskCountList.add(taskCountDto);
		}

		model.addAttribute("userId", userId);
		model.addAttribute("tasks", tasks);
		model.addAttribute("projects", projects);
		model.addAttribute("taskCountList", taskCountList);
		System.out.println("data " + taskCountList);

		return "TasksByName"; // Replace with the name of your JSP page to display tasks
	}

	@RequestMapping(value = "resources/tasks/filter", method = RequestMethod.GET)
	@ResponseBody
	public String filterTasks(@Validated ResTaskFilter ResTaskFilter, BindingResult bindingResult) {
		System.out.println("/tasks/filter is called ");
		if (bindingResult.hasErrors()) {
			// Handle validation errors
			// Return appropriate error response
			return "Validation Error";
		}
		List<TaskDto> task = taskService.filterTasks(ResTaskFilter);
		Gson gson = new Gson();
		String json = gson.toJson(task);
		return json;
	}

	@RequestMapping(value = "/user_details", method = RequestMethod.GET)
	public String getResourceDetailsById(@RequestParam(name = "userId") int userId, Model model) {
		System.out.println(userId);
		User resource = resourceService.getResourceById(userId);
		model.addAttribute("resource", resource);
		return "user_details";
	}

}
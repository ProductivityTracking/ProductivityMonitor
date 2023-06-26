package com.pennant.prodmtr.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pennant.prodmtr.model.Dto.FunctionalUnitdto;
import com.pennant.prodmtr.model.Dto.ModuleDTO;
import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.TaskDto;
import com.pennant.prodmtr.model.Entity.FunctionalUnit;
import com.pennant.prodmtr.model.Entity.Sprint;
import com.pennant.prodmtr.model.Entity.SprintResource;
import com.pennant.prodmtr.model.Entity.SprintTasks;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.model.Input.SprintInput;
import com.pennant.prodmtr.model.Input.SprintResourceInput;
import com.pennant.prodmtr.model.Input.SprintTasksInput;
import com.pennant.prodmtr.model.Input.TaskInput;
import com.pennant.prodmtr.model.view.FunctionalTask;
import com.pennant.prodmtr.service.Interface.ModuleService;
import com.pennant.prodmtr.service.Interface.ProjectService;
import com.pennant.prodmtr.service.Interface.SprintService;
import com.pennant.prodmtr.service.Interface.TaskService;

@Controller
public class SprintController {

	SprintService sprintService;
	ProjectService projectService;
	ModuleService moduleService;
	TaskService taskService;
	static int sprintid = 0;

	@Autowired
	public SprintController(SprintService sprintService, ProjectService projectService, ModuleService moduleService,
			TaskService taskService) {
		super();
		this.sprintService = sprintService;
		this.projectService = projectService;
		this.moduleService = moduleService;
		this.taskService = taskService;

	}

	@RequestMapping(value = "/ShowFunctionalUnits", method = RequestMethod.POST)
	public String createTask(@Validated SprintInput sprintInput,
			@ModelAttribute SprintResourceInput SprintResourceInput, Model model) throws ParseException {
		Sprint s = sprintService.storeSprint(sprintInput.toEntity());
		SprintResource sr = SprintResourceInput.toEntity();
		sprintid = s.getSprintId();
		sr.setSprintId(s.getSprintId());
		sprintService.storeSprintResource(sr);
		System.out.println("Create Tasks Requested" + sprintInput);

		List<FunctionalUnit> flist = sprintService.getFunctionalUnitsByModId(sprintInput.getModuleId());
		List<FunctionalUnitdto> funlistDto = new ArrayList<>();

		for (FunctionalUnit functionalUnit : flist) {
			FunctionalUnitdto funUnitDto = FunctionalUnitdto.fromEntity(functionalUnit);
			funlistDto.add(funUnitDto);
		}

		model.addAttribute("funlist", funlistDto);
		model.addAttribute("pro_id", sprintInput.getProjectId());
		return "ShowFunctionalUnits";
	}

	@RequestMapping(value = "/ShowFunUnits", method = RequestMethod.POST)
	public String showFunctionalUnits(@RequestParam("modid") int modid, @RequestParam("prodid") int prodid, Model model)
			throws ParseException {
		List<FunctionalUnit> flist = sprintService.getFunctionalUnitsByModId(modid);
		List<FunctionalUnitdto> funlistDto = new ArrayList<>();

		for (FunctionalUnit functionalUnit : flist) {
			FunctionalUnitdto funUnitDto = FunctionalUnitdto.fromEntity(functionalUnit);
			funlistDto.add(funUnitDto);
		}
		model.addAttribute("funlist", funlistDto);
		model.addAttribute("pro_id", prodid);
		return "ShowFunctionalUnits";
	}

	@RequestMapping(value = "/sprint", method = RequestMethod.GET)
	public String sprint(Model model) {
		System.out.println("project called");
		List<Sprint> allSprints = sprintService.getAllSprints();
		model.addAttribute("allSprints", allSprints);
		System.out.println(allSprints);
		return "sprint_home";
	}

	// @RequestMapping(value = "/sprint_details", method = RequestMethod.GET)
	// public String getSprintDetails(Model model, @RequestParam int sprintId) {
	// // System.out.println("Sprint Details JSP Requested");
	// Sprint sprint = sd.getSprintDetails(sprintId);
	// // Retrieve the selected sprint details from the database and add them to the model
	// model.addAttribute("sprint", sprint);
	//
	// List<SprintTasks> tasksByIdSprints = sd.getAllTasksBySprintId(sprintId);
	// model.addAttribute("tasksByIdSprints", tasksByIdSprints);
	// return "sprint_details";
	// }

	@RequestMapping(value = "/sprint_details", method = RequestMethod.GET)
	public String getSprintDetails(Model model, @RequestParam int sprintId) {
		Sprint sprint = sprintService.getSprintDetails(sprintId);
		model.addAttribute("sprint", sprint);
		Sprint s = new Sprint();
		s.setSprintId(sprintId);
		List<SprintTasks> tasksByIdSprints = sprintService.getAllTasksBySprintId(s);
		model.addAttribute("tasksByIdSprints", tasksByIdSprints);
		return "sprint_details";
	}

	@RequestMapping(value = "/add_sprint", method = RequestMethod.GET)
	public String addSprint(Model model) {
		List<ProjectDto> pl = projectService.getAllProjects();
		model.addAttribute("projects", pl);
		List<User> lu = sprintService.getAllUsers();
		model.addAttribute("users", lu);

		return "add_sprint";
	}

	@RequestMapping(value = "/FunctionalUnit", method = RequestMethod.GET)
	public String addSprint() {
		// System.out.println("functional unit jsp");

		// Add any necessary data to the model for rendering the add sprint page

		return "FunctionalUnit";
	}

	@RequestMapping(value = "/SubTaskdetails", method = RequestMethod.GET)
	public String SubtaskDetails() {
		// System.out.println("Subtask Details requested");
		return "SubtaskDetails";
	}

	@RequestMapping(value = "/CreateSubTask", method = RequestMethod.GET)
	public String CreateSubtask() {

		return "CreateSubtask";
	}

	// TODO
	@RequestMapping(value = "/backlogs", method = RequestMethod.GET)
	public String pastdue(Model model) {
		ArrayList<Sprint> SprintList = (ArrayList<Sprint>) sprintService.getBacklogs();

		model.addAttribute("sprintList", SprintList);
		return "backlog";
	}

	@RequestMapping(value = "/BacklogTasks", method = RequestMethod.GET)
	public String getBacklogTasks(Model model, @RequestParam("sprnModlId") int sprnModlId,
			@RequestParam("sprnId") int sprnId) {

		Sprint sprint = sprintService.getSprintDetails(sprnId);
		List<Task> taskList = sprintService.getTasks(sprnModlId);
		model.addAttribute("sprint", sprint);
		model.addAttribute("taskList", taskList);
		return "BacklogTasks";
	}

	@ResponseBody
	@RequestMapping(value = "/getModuleById", method = RequestMethod.POST, produces = "application/json")
	public String getModuleById(@RequestParam("projectId") int projectId) {
		System.out.println("Inside");
		List<ModuleDTO> moduleList = sprintService.getSprintModulesByProjectId(projectId);
		System.out.println("moduleList" + moduleList.get(0));
		Gson gson = new Gson();
		String json = gson.toJson(moduleList);
		return json;
	}

	@RequestMapping(value = "/Task", method = RequestMethod.POST)
	public String createTask(@ModelAttribute FunctionalTask ft, Model model) {
		System.out.println("Create Task");
		model.addAttribute("funtask", ft);
		System.out.println("tasksare" + ft);
		List<User> lu = sprintService.getAllUsers();
		model.addAttribute("users", lu);
		List<TaskDto> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "Task";
	}

	@RequestMapping(value = "/TaskAdded", method = RequestMethod.POST)
	public String TaskAdded(@ModelAttribute TaskInput taskInput, @ModelAttribute SprintTasksInput sprintTasksInput,

			Model model) {
		System.out.println("task" + taskInput);
		Task t = sprintService.storeTask(taskInput.toEntity());
		System.out.println("question" + sprintTasksInput);
		sprintTasksInput.setSprintId(sprintid);
		sprintTasksInput.setTaskId(t.getTaskId());

		System.out.println("fellow" + t.getTaskSupervisor().getUserId());
		sprintTasksInput.setUserId(t.getTaskSupervisor().getUserId());
		SprintTasks st;
		st = sprintTasksInput.toEntity();
		sprintService.storeSprintTasks(st);
		System.out.println(st + "checkcc");

		return "TaskAdded";
	}
}

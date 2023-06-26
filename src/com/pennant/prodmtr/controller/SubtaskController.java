package com.pennant.prodmtr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pennant.prodmtr.model.Input.SubtaskInput;
import com.pennant.prodmtr.service.Interface.SubtaskService;
import com.pennant.prodmtr.service.Interface.TaskService;

@Controller
public class SubtaskController {

	@Autowired
	public SubtaskService subtaskService;
	private TaskService taskService;

	@RequestMapping(value = "/saveSubtask", method = RequestMethod.GET)
	public String saveSubtask(@Validated SubtaskInput subtaskInput, Model model) {
		try {
			System.out.println(subtaskInput.getSubtaskDescription());
			System.out.println(subtaskInput.getCreationDate());
			System.out.println(subtaskInput.getTaskId());
			System.out.println(subtaskInput.getSubtaskId());
			System.out.println(subtaskInput.getNumberOfHours());
			subtaskService.setNewSubTask(subtaskInput);
			return "Taskslist";
		} catch (DataIntegrityViolationException ex) {
			// Handle the constraint violation exception
			ex.printStackTrace(); // or log the error
			model.addAttribute("error", "Constraint violation occurred. Please try again.");
			System.out.println(subtaskInput.getSubtaskDescription());
			System.out.println(subtaskInput.getCreationDate());
			System.out.println(subtaskInput.getTaskId());
			System.out.println(subtaskInput.getSubtaskId());
			System.out.println(subtaskInput.getNumberOfHours());

			return "Taskslist"; // Show an error page to the user
		}
	}

	@RequestMapping(value = "/createSubtask", method = RequestMethod.GET)
	public String getSubtaskForm(@RequestParam("taskId") int taskId, Model model) {
		SubtaskInput subtaskInput = new SubtaskInput();
		subtaskInput.setTaskId(taskId); // Set the task_id in the SubtaskInput object
		model.addAttribute("subtaskInput", subtaskInput);
		model.addAttribute("taskId", taskId);
		return "createsubtask";
	}
	
	/*
	 * @RequestMapping(value = "/setSubTaskStatus", method = RequestMethod.GET)
	 * public String setSubTaskStatus(@RequestParam("compostiteId") String
	 * compostiteId, Model model) { Subtask subtask =
	 * subtaskService.getSubTaskByCompositeId(compostiteId); //
	 * subtaskService.setSubtask return "createsubtask"; }
	 */
}

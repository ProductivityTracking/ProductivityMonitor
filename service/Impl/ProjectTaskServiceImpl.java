package com.pennant.prodmtr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pennant.prodmtr.Dao.Interface.ProjectTaskdao;
import com.pennant.prodmtr.model.Dto.PTFilterCriteria;
import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.ProjectTaskDTO;
import com.pennant.prodmtr.model.Entity.ProjectTask;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.service.Interface.ProjectTaskService;
import com.pennant.prodmtr.service.Interface.TaskService;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

	@Autowired
	private TaskService taskService;

	@Autowired
	private ProjectTaskdao projectTaskdao;

	@Autowired
	private ProjectTaskService projectTaskService;

	@Override
	public ProjectTask createProjectTask(ProjectTask projectTask) {
		// Additional business logic, if needed
		return projectTaskdao.save(projectTask);
	}

	// public List<ProjectTask> getAllProjectTasks() {
	// return projectTaskdao.getProjectTaskDTOList();
	// }
	@Override
	public List<ProjectTaskDTO> getProjectTaskDTOList() {
		// TODO Auto-generated method stub
		return projectTaskdao.getProjectTaskDTOList();
	}

	@Override
	public ProjectTaskDTO getProjectTaskById(int taskId) {
		// TODO Auto-generated method stub
		return projectTaskdao.getProjectTaskById(taskId);
	}

	@Override
	public List<ProjectTaskDTO> filterTasks(PTFilterCriteria filterCriteria) {

		return projectTaskdao.filterTasks(filterCriteria);
	}

	@Override
	public void setTasksToProjDto(int projectId, ProjectDto projectDto) {

		List<Task> tasks = taskService.getTasksByProjectId(projectId);
		List<Task> compTasks = taskService.getCompTasksByProjectId(projectId);

		List<ProjectTask> projectTasks = projectTaskService.getTasksByProjectId(projectId);
		List<ProjectTask> compProjectTasks = projectTaskService.getCompTasksByProjectId(projectId);

		projectDto.setTotalTasks(tasks.size());
		projectDto.setCompletedTasks(compTasks.size());

		projectDto.setTotalIndvTasks(projectTasks.size());
		projectDto.setCompletedIndvTasks(compProjectTasks.size());
	}

	@Override
	public List<ProjectTask> getTasksByProjectId(Integer projId) {
		// TODO Auto-generated method stub
		return projectTaskdao.getTasksByProjectId(projId);
	}

	public List<ProjectTask> getCompTasksByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return projectTaskdao.getCompTasksByProjectId(projectId);
	}

	@Override
	public int getCompletedTasksByUserId(int userId) {
		return projectTaskdao.getCompletedTasksByUserId(userId);
	}

	@Override
	public int getTotalTasksByUserId(int userId) {
		int tasks = projectTaskdao.getTotalTasksByUserId(userId);
		return tasks;
	}

	@Override
	public double getHoursWorkedByUserId(int userId) {
		// Implement the logic to retrieve the hours worked by the user
		// You can use the appropriate data access method or service call here
		// and return the number of hours worked
		return projectTaskdao.getHoursWorkedByUserId(userId);
	}

	public double calculatePerformanceScore(int completedTasks, int totalTasks) {
		if (totalTasks == 0) {
			return 0.0; // Avoid division by zero
		}
		return (double) completedTasks / totalTasks * 100.0;
	}

	// Other service methods for updating, deleting project tasks
}
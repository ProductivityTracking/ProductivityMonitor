package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.ResTaskFilter;
import com.pennant.prodmtr.model.Dto.TFilterCriteria;
import com.pennant.prodmtr.model.Dto.TaskDto;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.view.TaskStatusRequest;
import com.pennant.prodmtr.model.view.TaskUpdateFormModel;

public interface TaskService {

	List<TaskDto> filterTasks(ResTaskFilter resTaskFilter);

	List<TaskDto> getTasksByUserId(int userId);

	List<TaskDto> PtfilterTasks(TFilterCriteria filterCriteria);

	List<TaskDto> getAllTasks();

	Task getTaskById(int taskId);

	void saveTask(Task task);

	Boolean updateStatus(int  taskId);

	// Other task-related methods...
	List<Task> getTasksByProjectId(Integer projId);

	List<Task> getCompTasksByProjectId(Integer projId);

	double getHoursWorkedByUserId(int userId);

	public double calculatePerformanceScore(int compTasks, int totalTasks);

	int getTotalTasksByUserId(int userId);

	int getCompletedTasksByUserId(int userId);

	void setTaskStatus(TaskStatusRequest request);

	void updateTaskStatus(TaskUpdateFormModel taskUpdateFormModel);



}
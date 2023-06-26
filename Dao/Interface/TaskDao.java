package com.pennant.prodmtr.Dao.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.ResTaskFilter;
import com.pennant.prodmtr.model.Dto.TaskDto;
import com.pennant.prodmtr.model.Entity.Project;
import com.pennant.prodmtr.model.Entity.Task;

public interface TaskDao {
	List<TaskDto> viewTasksForUser(int userId);

	Project findProjectById(Short projectId);

	List<TaskDto> getTasksByUserId(int userId);

	List<TaskDto> getAllTasks();

	List<TaskDto> filterTasks(ResTaskFilter resTaskFilter);

	Task getTaskById(int taskId);

	void saveTask(Task task);

	boolean updateStatus(int taskId2);

	List<Task> getTasksByProjectId(int projId);

	List<Task> getCompTasksByProjectId(int projId);

	int getCompletedTasksByUserId(int userId);

	int getTotalTasksByUserId(int userId);

	double getHoursWorkedByUserId(int userId);

	void setTaskStatus(int taskId, String taskRemarks, String taskStatus);

	void updateEntity(int taskId, String remarks, String status);

	// Other methods for task-related operations
}

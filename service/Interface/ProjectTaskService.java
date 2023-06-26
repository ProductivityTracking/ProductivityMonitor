package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.PTFilterCriteria;
import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.ProjectTaskDTO;
import com.pennant.prodmtr.model.Entity.ProjectTask;

public interface ProjectTaskService {
	ProjectTask createProjectTask(ProjectTask projectTask);

	List<ProjectTaskDTO> getProjectTaskDTOList();

	ProjectTaskDTO getProjectTaskById(int taskId);

	List<ProjectTaskDTO> filterTasks(PTFilterCriteria filterCriteria);

	public List<ProjectTask> getTasksByProjectId(Integer projId);

	public List<ProjectTask> getCompTasksByProjectId(int projectId);

	double getHoursWorkedByUserId(int userId);

	int getTotalTasksByUserId(int userId);

	int getCompletedTasksByUserId(int userId);

	void setTasksToProjDto(int projectId, ProjectDto projectDto);

}

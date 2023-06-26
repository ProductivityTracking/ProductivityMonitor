package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.ProjectFilter;
import com.pennant.prodmtr.model.Input.ProjectInput;

public interface ProjectService {
	List<ProjectDto> getAllProjects();

	List<ProjectDto> filterProjects(ProjectFilter projectFilter);

	ProjectDto getProjectById(Integer projId);

	void setNewProject(ProjectInput projectInput);
}

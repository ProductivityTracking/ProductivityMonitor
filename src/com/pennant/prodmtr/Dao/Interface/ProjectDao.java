package com.pennant.prodmtr.Dao.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.ProjectFilter;
import com.pennant.prodmtr.model.Entity.Project;

public interface ProjectDao {
	List<ProjectDto> getAllProjects();

	Project findById(short id);

	List<ProjectDto> getFilterProjects(ProjectFilter projectFilter);

	ProjectDto getProjectById(Integer projId);

	void setNewProject(Project project);
}

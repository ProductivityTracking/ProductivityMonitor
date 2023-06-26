package com.pennant.prodmtr.service.Impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pennant.prodmtr.Dao.Interface.ProjectDao;
import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.ProjectFilter;
import com.pennant.prodmtr.model.Entity.Project;
import com.pennant.prodmtr.model.Input.ProjectInput;
import com.pennant.prodmtr.service.Interface.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private final ProjectDao projectDao;

	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public List<ProjectDto> getAllProjects() {
		return projectDao.getAllProjects();
	}

	public List<ProjectDto> filterProjects(ProjectFilter projectFilter) {
		// TODO Auto-generated method stub
		return projectDao.getFilterProjects(projectFilter);
	}

	public ProjectDto getProjectById(Integer projId) {
		return projectDao.getProjectById(projId);
	}

	public void setNewProject(ProjectInput projectInput) {
		Date date = new Date(System.currentTimeMillis());
		// Date sqlDate = new Date(System.currentTimeMillis());
		projectInput.setProjectStartDate(date);
		projectInput.setProjectStatus("O");
		Project project = projectInput.toEntity();
		projectDao.setNewProject(project);
	}

	// Add methods for creating, updating, and deleting projects if needed
}
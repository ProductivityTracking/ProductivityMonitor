package com.pennant.prodmtr.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pennant.prodmtr.Dao.Interface.ResourceDao;
import com.pennant.prodmtr.model.Dto.ResourceFilter;
import com.pennant.prodmtr.model.Dto.UserDto;
import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.model.Input.UserInput;
import com.pennant.prodmtr.service.Interface.ResourceService;

@Component
@Transactional
public class ResourceServiceImpl implements ResourceService {

	private final ResourceDao resourceDAO;

	@Autowired
	public ResourceServiceImpl(ResourceDao resourceDAO) {
		this.resourceDAO = resourceDAO;
	}

	public List<UserDto> getAllResources() {
		return resourceDAO.getAllResources();
	}

	public List<UserDto> filterResources(ResourceFilter ResourceFilter) {
		Short roleFilter = ResourceFilter.getRoleFilter();
		Short projectFilter = ResourceFilter.getProjectFilter();
		System.out.println("in service ");
		System.out.println("roleFilter is " + roleFilter);
		System.out.println("projectFilter is " + projectFilter);
		List<UserDto> UserDto = resourceDAO.filterResources(roleFilter, projectFilter);
		return UserDto;
	}

	public User getResourceByDisplayName(String displayName) {
		return resourceDAO.getResourceByDisplayName(displayName);
	}

	public void addUser(UserInput userinput) {
		User user = userinput.toEntity();
		resourceDAO.addUser(user);
	}

	public void save(UserInput existingResource) {

		existingResource.setUserCreationDate(existingResource.getUserCreationDate());
		existingResource.setUserLastUpdatedDate(new Date());

		User user = existingResource.toEntity();
		resourceDAO.saveUser(user);

	}

	public List<User> getAllProjManagers() {
		return resourceDAO.getAllProjManagers();
	}

	public List<User> getUsersByProjectId(int projectId) {
		List<User> user = resourceDAO.getUsersByProjectId(projectId);
		return user;
	}
	@Override
	public User getResourceById(int userId) {
		return resourceDAO.getResourceById(userId);
	}
}
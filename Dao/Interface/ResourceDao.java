package com.pennant.prodmtr.Dao.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.UserDto;
import com.pennant.prodmtr.model.Entity.Project;
import com.pennant.prodmtr.model.Entity.Role;
import com.pennant.prodmtr.model.Entity.User;

public interface ResourceDao {
	List<UserDto> getAllResources();

	List<UserDto> filterResources(Short roleFilter, Short projectFilter);

	Role findById(Short id);

	Project findProjectById(Short projectId);

	User getResourceByDisplayName(String displayName);

	void addUser(User user);

	void saveUser(User existingResource);

	List<User> getAllProjManagers();

	List<User> getUsersByProjectId(int projectId);

	User getResourceById(int userId);

	// Other methods for fetching, updating, and deleting resources
}

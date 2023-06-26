package com.pennant.prodmtr.Dao.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Entity.Role;

public interface RoleDao {
	List<Role> getAllRoles();

	Role findById(short id);

	// Other methods for role-related operations
}

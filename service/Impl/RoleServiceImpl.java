package com.pennant.prodmtr.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pennant.prodmtr.Dao.Interface.RoleDao;
import com.pennant.prodmtr.model.Entity.Role;
import com.pennant.prodmtr.service.Interface.RoleService;

@Component
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDAO;

	public void setRoleDAO(RoleDao roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Transactional
	public List<Role> getAllRoles() {
		return roleDAO.getAllRoles();
	}
}
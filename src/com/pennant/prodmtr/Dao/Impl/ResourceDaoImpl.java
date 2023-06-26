package com.pennant.prodmtr.Dao.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.pennant.prodmtr.Dao.Interface.ResourceDao;
import com.pennant.prodmtr.model.Dto.UserDto;
import com.pennant.prodmtr.model.Entity.Project;
import com.pennant.prodmtr.model.Entity.Role;
import com.pennant.prodmtr.model.Entity.User;

@Component
public class ResourceDaoImpl implements ResourceDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<UserDto> getAllResources() {
		String jpql = "SELECT r FROM User r";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		List<User> users = query.getResultList();

		List<UserDto> userDtos = users.stream().map(UserDto::fromEntity).collect(Collectors.toList());

		return userDtos;
	}

	public List<UserDto> filterResources(Short roleFilter, Short projectFilter) {
		String jpql = "SELECT DISTINCT u FROM User u WHERE 1=1  AND ( u.userRole.id = :roleFilter AND  u.id IN (SELECT t.taskSupervisor.id FROM Task t WHERE t.project.id = :projectFilter))";
		String projqry = "SELECT DISTINCT u FROM User u WHERE 1=1  AND  u.userRole.id = :roleFilter";
		String roleqry = "SELECT DISTINCT u FROM User u WHERE 1=1  AND u.id IN (SELECT t.taskSupervisor.id FROM Task t WHERE t.project.id = :projectFilter)";
		String allqry = "SELECT DISTINCT u FROM User u";

		if (roleFilter == null) {
			jpql = roleqry;
			if (projectFilter == null) {
				jpql = allqry;
			}

		} else if (projectFilter == null) {
			jpql = projqry;
		}

		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

		System.out.println("in2");
		if (roleFilter != null) {
			System.out.println("in2");
			Role role = findById(roleFilter);

			query.setParameter("roleFilter", role.getRoleId());
		}

		System.out.println("in3");
		if (projectFilter != null) {
			Project project = findProjectById(projectFilter);
			query.setParameter("projectFilter", project.getProjectId());
		}

		System.out.println("in4");
		List<User> users = query.getResultList();

		List<UserDto> userDtos = users.stream().map(UserDto::fromEntity).collect(Collectors.toList());

		return userDtos;
	}

	public Role findById(Short id) {
		return entityManager.find(Role.class, id);
	}

	public Project findProjectById(Short projectId) {
		System.out.println("in findprojbyid");
		return entityManager.find(Project.class, projectId);
	}

	public User getResourceByDisplayName(String displayName) {
		String jpql = "SELECT r FROM User r WHERE r.userDisplayName = :displayName";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("displayName", displayName);

		System.out.println(displayName);
		List<User> resultList = query.getResultList();
		if (!resultList.isEmpty()) {
			return resultList.get(0);
		}

		System.out.println("fan   ");
		return null;
	}

	private User findByName(String displayName) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class, displayName);
	}

	public void addUser(User user) {
		entityManager.persist(user);
	}

	public void saveUser(User existingResource) {
		entityManager.merge(existingResource);
	}

	public List<User> getAllProjManagers() {
		String jpql = "SELECT r FROM User r where userRole.roleId = 1 or userRole.roleId = 2";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	public List<User> getUsersByProjectId(int projectId) {
		short pid = (short) projectId;
		String jpql = "SELECT DISTINCT u FROM Task t JOIN t.taskSupervisor u WHERE t.project.projectId = :projectId";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("projectId", pid);
		return query.getResultList();
	}
	
	public User getResourceById(int userId) {
		String jpql = "SELECT r FROM User r WHERE r.userId = :userId";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("userId", userId);

		List<User> resultList = query.getResultList();
		if (!resultList.isEmpty()) {
			return resultList.get(0);
		}
		return null;
	}

}
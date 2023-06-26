package com.pennant.prodmtr.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.pennant.prodmtr.Dao.Interface.UserDao;
import com.pennant.prodmtr.model.Entity.Role;
import com.pennant.prodmtr.model.Entity.Subtask;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.service.Interface.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userdao) {
		this.userDao = userdao;
	}

	public void UpdatePassword(Integer id, String password) {
		userDao.UpdatePassword(id, password);
	}

	@Override
	public List<Task> getUserActivities(Role userRole) {
		String taskStatus = "REFC";
		if (userRole.getRoleId() == 1 || userRole.getRoleId() == 2) {
			taskStatus = "REVW";
		}
		System.out.println(" type taskStatus " + taskStatus);
		List<Task> tasks = userDao.getUserActivities(taskStatus);
		System.out.println("tasks "+tasks);
		return tasks;
	}

	@Override
	public List<Subtask> getUserSubtaskActivities(Role userRole) {
		String taskStatus = "REFC";
		System.out.println("role "+userRole.getRoleId());
		if (userRole.getRoleId() == 1 || userRole.getRoleId() == 2) {
			taskStatus = "REVW";
		}
		System.out.println(" type subtaskStatus " + taskStatus);
		List<Subtask> subtasks = userDao.getUserSubtaskActivities(taskStatus);
		System.out.println("subtasks "+subtasks);
		return subtasks;
	}

	@Override
	public String verifyUser(User user, HttpSession session) {
		User myUser = null;
		
		try {
			myUser = userDao.verifyUser(user.getUserDisplayName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "login";
		}
		if (myUser == null) {
	        return "login"; // User not found, return "login" to indicate login failure
	    } else if (myUser.getUserPassword().equals(user.getUserPassword())) {
			session.setAttribute("user", myUser);
	        return "productivity"; // Password matches, return "success" to indicate successful verification
	    } else {
	        return "login"; // Password does not match, return "invalid" to indicate verification failure
	    }
	}


}
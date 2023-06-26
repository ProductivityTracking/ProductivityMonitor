package com.pennant.prodmtr.service.Interface;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.pennant.prodmtr.model.Entity.Role;
import com.pennant.prodmtr.model.Entity.Subtask;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.Entity.User;


public interface UserService {
	public void UpdatePassword(Integer id, String password);

	public List<Task> getUserActivities(Role userRole);
	
	public List<Subtask> getUserSubtaskActivities(Role userRole);

	public String verifyUser(User user, HttpSession session);
	
}

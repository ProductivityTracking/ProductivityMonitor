package com.pennant.prodmtr.Dao.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.ModuleDTO;
import com.pennant.prodmtr.model.Entity.FunctionalUnit;
import com.pennant.prodmtr.model.Entity.Sprint;
import com.pennant.prodmtr.model.Entity.SprintResource;
import com.pennant.prodmtr.model.Entity.SprintTasks;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.Entity.User;

public interface SprintDao {
	List<Sprint> getBaskLogs();

	Sprint getSprintDetails(int sprintId);

	List<Task> getTasks(int modlId);

	List<Sprint> getAllSprints();

	List<SprintTasks> getAllTasksBySprintId(Sprint sprintId);

	Sprint storeSprint(Sprint sprint);

	List<ModuleDTO> getSprintModulesByProjectId(int projectId);

	List<FunctionalUnit> getFunctionalUnitsByModId(int modl_id);

	public Task storeTask(Task task);

	public List<User> getAllUsers();

	// Add other methods as needed
	public void storeSprintResource(SprintResource src);

	public void storeSprintTasks(SprintTasks sprintTask);
}
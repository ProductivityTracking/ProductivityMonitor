package com.pennant.prodmtr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pennant.prodmtr.Dao.Interface.SprintDao;
import com.pennant.prodmtr.model.Dto.ModuleDTO;
import com.pennant.prodmtr.model.Entity.FunctionalUnit;
import com.pennant.prodmtr.model.Entity.Sprint;
import com.pennant.prodmtr.model.Entity.SprintResource;
import com.pennant.prodmtr.model.Entity.SprintTasks;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.Entity.User;
import com.pennant.prodmtr.service.Interface.SprintService;

@Component
@Transactional
	@Service
	public class SprintServiceImpl implements SprintService {
		private final SprintDao sprintDao;
		@Autowired
		public SprintServiceImpl(SprintDao sprintDao) {
			this.sprintDao = sprintDao;
		}

		@Override
		public List<Sprint> getBacklogs() {
			return sprintDao.getBaskLogs();
		}

		@Override
		public Sprint getSprintDetails(int sprintId) {
			return sprintDao.getSprintDetails(sprintId);
		}

		@Override
		public List<Task> getTasks(int modlId) {
			return sprintDao.getTasks(modlId);
		}

		@Override
		public List<Sprint> getAllSprints() {
			return sprintDao.getAllSprints();
		}

		@Override
		public List<SprintTasks> getAllTasksBySprintId(Sprint sprintId) {
			return sprintDao.getAllTasksBySprintId(sprintId);
		}

		@Override
		public Sprint storeSprint(Sprint sprint) {
			return sprintDao.storeSprint(sprint);
		}

		@Override
		public List<ModuleDTO> getSprintModulesByProjectId(int projectId) {
			// List<ModuleDTO> modules = sprintDAO.getSprintModulesByProjectId(projectId);

			return sprintDao.getSprintModulesByProjectId(projectId);
		}

		@Override
		public List<FunctionalUnit> getFunctionalUnitsByModId(int modlId) {
			return sprintDao.getFunctionalUnitsByModId(modlId);
		}

	
		

		public void storeSprintResource(SprintResource src) {
			sprintDao.storeSprintResource(src);
		}

		public void storeSprintTasks(SprintTasks sprintTask) {
			// TODO Auto-generated method stub
			System.out.println(sprintTask);
			sprintDao.storeSprintTasks(sprintTask);

		}

		@Override
		public Task storeTask(Task task) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<User> getAllUsers() {
			// TODO Auto-generated method stub
			return null;
		}
}

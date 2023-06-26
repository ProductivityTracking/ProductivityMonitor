package com.pennant.prodmtr.model.Input;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pennant.prodmtr.model.Entity.Module;
import com.pennant.prodmtr.model.Entity.Project;
import com.pennant.prodmtr.model.Entity.Sprint;
import com.pennant.prodmtr.model.Entity.User;


public class SprintInput {
	private int sprintId;
	private int moduleId;
	private int masterId;
	private String startDate;
	private String endDate;
	private int projectId;
	private String sprintName;
	private String sprintStatus;
	public int getSprintId() {
		return sprintId;
	}
	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getSprintName() {
		return sprintName;
	}
	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
	public String getSprintStatus() {
		return sprintStatus;
	}
	public void setSprintStatus(String sprintStatus) {
		this.sprintStatus = sprintStatus;
	}
	public SprintInput(int sprintId, int moduleId, int masterId, String startDate, String endDate, int projectId,
			String sprintName, String sprintStatus) {
		super();
		this.sprintId = sprintId;
		this.moduleId = moduleId;
		this.masterId = masterId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectId = projectId;
		this.sprintName = sprintName;
		this.sprintStatus = sprintStatus;
	}
	public SprintInput() {
		super();
	}
	@Override
	public String toString() {
		return "SprintInput [sprintId=" + sprintId + ", moduleId=" + moduleId + ", masterId=" + masterId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", projectId=" + projectId + ", sprintName="
				+ sprintName + ", sprintStatus=" + sprintStatus + "]";
	}

	public Sprint toEntity() throws ParseException {
		Sprint sprint = new Sprint();
		sprint.setSprintId(this.sprintId);
		Module m = new Module();
		m.setModuleId((short)this.moduleId);
		sprint.setModuleId(m);
		User u = new User();
		u.setUserId(this.masterId);
		sprint.setMasterId(u);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedStartDate = (Date) dateFormat.parse(this.getStartDate());
		Timestamp startDate = new Timestamp(parsedStartDate.getTime());
		sprint.setStartDate(startDate);

		Date parsedEndDate = (Date) dateFormat.parse(this.getEndDate());
		Timestamp endDate = new Timestamp(parsedEndDate.getTime());
		sprint.setEndDate(endDate);
		Project p = new Project();
		p.setProjectId((short)projectId);
		sprint.setProjectId(p);
		sprint.setSprintName(this.sprintName);
		sprint.setSprintStatus(this.sprintStatus);

		return sprint;
	}

	
}

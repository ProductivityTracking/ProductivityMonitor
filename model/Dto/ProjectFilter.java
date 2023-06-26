package com.pennant.prodmtr.model.Dto;

public class ProjectFilter {
	private short projectId;
	private String status;

	public short getProjectId() {
		return projectId;
	}

	public void setProjectId(short projectId) {
		this.projectId = projectId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

package com.pennant.prodmtr.model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pm_ProjectModules")

public class Module {
	@Id
	@Column(name = "modl_id")
	private short moduleId;

	@Column(name = "modl_name", length = 100)
	private String moduleName;

	@Column(name = "modl_desc", length = 255)
	private String moduleDescription;

	@ManyToOne
	@JoinColumn(name = "modl_proj_id")
	private Project moduleProject;

	// Constructors
	public Module() {
	}

	public Module(String moduleName, String moduleDescription, Project moduleProject) {
		this.moduleName = moduleName;
		this.moduleDescription = moduleDescription;
		this.moduleProject = moduleProject;
	}

	// Getters and Setters
	public short getModuleId() {
		return moduleId;
	}

	public void setModuleId(short moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public Project getModuleProject() {
		return moduleProject;
	}

	public void setModuleProject(Project moduleProject) {
		this.moduleProject = moduleProject;
	}
}

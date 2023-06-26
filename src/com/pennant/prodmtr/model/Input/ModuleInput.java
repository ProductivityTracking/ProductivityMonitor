package com.pennant.prodmtr.model.Input;

import com.pennant.prodmtr.model.Entity.Module;
import com.pennant.prodmtr.model.Entity.Project;

public class ModuleInput {
	private int moduleid;
	private String module_name;
	private String module_desc;
	private int module_proj_id;
	
	
	public int getModule_proj_id() {
		return module_proj_id;
	}
	public void setModule_proj_id(int module_proj_id) {
		this.module_proj_id = module_proj_id;
	}
	public int getModuleid() {
		return moduleid;
	}
	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	public String getModule_desc() {
		return module_desc;
	}
	public void setModule_desc(String module_desc) {
		this.module_desc = module_desc;
	}
	
public Module toEntity() {
	Module module = new Module();
	module.setModuleId((short)this.moduleid);
	module.setModuleName(this.module_name);
	module.setModuleDescription(this.module_desc);
	Project project = new Project();
	project.setProjectId((short)this.module_proj_id);
	module.setModuleProject(project);
	return module;
}
}

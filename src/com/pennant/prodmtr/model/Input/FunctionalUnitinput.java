

package com.pennant.prodmtr.model.Input;

import com.pennant.prodmtr.model.Entity.FunctionalUnit;
import com.pennant.prodmtr.model.Entity.FunctionalUnitId;
import com.pennant.prodmtr.model.Entity.Module;
import com.pennant.prodmtr.model.Entity.Project;

public class FunctionalUnitinput {
    private int modlId;
    private int funtId;
    private String funitDesc;
    private String funStatus;
    private int projectId;

    public FunctionalUnitinput() {
        // Default constructor
    }

    public int getModlId() {
        return modlId;
    }

    public void setModlId(int modlId) {
        this.modlId = modlId;
    }

    public int getFuntId() {
        return funtId;
    }

    public void setFuntId(int funtId) {
        this.funtId = funtId;
    }

    public String getFunitDesc() {
        return funitDesc;
    }

    public void setFunitDesc(String funitDesc) {
        this.funitDesc = funitDesc;
    }

    public String getFunStatus() {
        return funStatus;
    }

    public void setprojectId(int proj_id) {
        this.projectId = proj_id;
    }

    public int getprojectId() {
        return projectId;
    }

    public void setFunStatus(String funStatus) {
        this.funStatus = funStatus;
    }

    public FunctionalUnit toEntity() {
        FunctionalUnit functionalUnit = new FunctionalUnit();
        FunctionalUnitId id = new FunctionalUnitId();
        Module module = new Module();
        Project project = new Project();

        id.setFunitid(this.funtId);
        module.setModuleId((short)this.modlId);
       id.setModule(module);
        project.setProjectId((short)this.projectId);

        functionalUnit.setId(id);
        functionalUnit.setDescription(this.funitDesc);
        functionalUnit.setProjectId(project);
        functionalUnit.setFunStatus(this.funStatus);
       

        return functionalUnit;
    }

	@Override
	public String toString() {
		return "FunctionalUnitinput [modlId=" + modlId + ", funtId=" + funtId + ", funitDesc=" + funitDesc
				+ ", funStatus=" + funStatus + ", projectId=" + projectId + "]";
	}
}
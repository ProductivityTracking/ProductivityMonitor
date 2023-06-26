package com.pennant.prodmtr.model.view;

public class FunctionalTask {
	private String modlId;
	private String funcId;
	private String desc;
	private String projId;

	public String getModlId() {
		return modlId;
	}

	public void setModlId(String modlId) {
		this.modlId = modlId;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getProjId() {
		return projId;
	}

	@Override
	public String toString() {
		return "FunctionalTask [modlId=" + modlId + ", funcId=" + funcId + ", desc=" + desc + ", projId=" + projId
				+ "]";
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}
}

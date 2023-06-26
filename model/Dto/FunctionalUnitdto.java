package com.pennant.prodmtr.model.Dto;

import com.pennant.prodmtr.model.Entity.FunctionalUnit;

public class FunctionalUnitdto {
	private int modl_id;
	private int funt_id;
	private String funit_desc;

	public FunctionalUnitdto() {
		// TODO Auto-generated constructor stub
	}

	public int getModl_id() {
		return modl_id;
	}

	public void setModl_id(int modl_id) {
		this.modl_id = modl_id;
	}

	public int getFunt_id() {
		return funt_id;
	}

	public void setFunt_id(int funt_id) {
		this.funt_id = funt_id;
	}

	public String getFunit_desc() {
		return funit_desc;
	}

	public void setFunit_desc(String funit_desc) {
		this.funit_desc = funit_desc;
	}

	public static FunctionalUnitdto fromEntity(FunctionalUnit funit) {
		FunctionalUnitdto funiotdto = new FunctionalUnitdto();
		funiotdto.setModl_id(funit.getId().getFunitid());
		funiotdto.setFunt_id(funit.getId().getFunitid());
		funiotdto.setFunit_desc(funit.getDescription());
		return funiotdto;

	}

}

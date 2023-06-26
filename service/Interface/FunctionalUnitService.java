package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.FunctionalUnitdto;
import com.pennant.prodmtr.model.Input.FunctionalUnitinput;

public interface FunctionalUnitService {
	List<FunctionalUnitdto> getFunctionalunitByModId(Integer modId);

	void createFunit(FunctionalUnitinput funitinput);

	// Other methods for functional unit-related operations
}

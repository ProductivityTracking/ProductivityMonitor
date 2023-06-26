package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.ModuleDTO;
import com.pennant.prodmtr.model.Input.ModuleInput;

public interface ModuleService {
	List<ModuleDTO> getModuleByProjId(Integer projId);

	void createModule(ModuleInput moduleinput);
}
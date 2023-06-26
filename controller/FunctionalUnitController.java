package com.pennant.prodmtr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pennant.prodmtr.model.Dto.FunctionalUnitdto;
import com.pennant.prodmtr.model.Input.FunctionalUnitinput;
import com.pennant.prodmtr.service.Interface.FunctionalUnitService;

@Controller
public class FunctionalUnitController {
	FunctionalUnitService Funitservice;

	@Autowired
	public FunctionalUnitController(FunctionalUnitService Funitservice) {
		this.Funitservice = Funitservice;
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/funitsbymodlId", method = RequestMethod.GET)
	public String getModuleDetailsByProjId(@RequestParam("modId") Integer modId, Model model) {
		System.out.println("Functional unit jsp called");
		System.out.println("funitid " + modId);
		List<FunctionalUnitdto> funits = Funitservice.getFunctionalunitByModId(modId);
		System.out.println("funity data" + funits);
		model.addAttribute("funitdto", funits);
		return "funitsbymodlId";
	}

	@RequestMapping(value = "/createfunit", method = RequestMethod.GET)
	public String createnewFunit() {

		return "createfunit";
	}

	@RequestMapping(value = "/createFunitsuccess", method = RequestMethod.POST)
	public String Createmodulesuccess(@Validated FunctionalUnitinput Funitinput, Model model) {
		System.out.println("createModule jsp called");
		System.out.println(Funitinput);
		Funitservice.createFunit(Funitinput);
		Integer modId = Funitinput.getModlId(); // Assuming you have a method to retrieve the module ID from the input
													// object
		return "redirect:/funitsbymodlId?modId=" + modId;
	}

}
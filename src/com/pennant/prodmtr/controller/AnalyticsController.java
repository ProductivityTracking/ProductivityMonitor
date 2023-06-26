package com.pennant.prodmtr.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pennant.prodmtr.model.Dto.AnalyticsDto;
import com.pennant.prodmtr.model.view.Past30CompletionSummary;
import com.pennant.prodmtr.service.Interface.AnalyticService;

@Controller
public class AnalyticsController {
	@Autowired
	AnalyticService analyticService;

	@RequestMapping(value = "/getUserAnalytics", method = RequestMethod.POST)
	public @ResponseBody String getProjAnalysisById(@RequestParam("user_id") Integer user_id) throws SQLException {
		AnalyticsDto analyticsDto = analyticService.getSummariesByUserId(user_id);
		Gson gson = new Gson();
		String json = gson.toJson(analyticsDto);

		System.out.println(user_id + "\n" + json);
		return json;
	}

	@RequestMapping(value = "/getDashboardAnalytics", method = RequestMethod.POST)
	public @ResponseBody String getDashboardAnalytics(Model model) throws SQLException {
		List<Past30CompletionSummary> past30CompletionSummary = analyticService.getPast30CompletionSummary();
		Gson gson = new Gson();
		String json = gson.toJson(past30CompletionSummary);

		System.out.println("data" + json);
		return json;
	}

}

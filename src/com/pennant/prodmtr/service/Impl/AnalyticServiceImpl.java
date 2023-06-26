package com.pennant.prodmtr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pennant.prodmtr.Dao.Interface.AnalyticsDao;
import com.pennant.prodmtr.model.Dto.AnalyticsDto;
import com.pennant.prodmtr.model.view.ModuleSummary;
import com.pennant.prodmtr.model.view.Past30CompletionSummary;
import com.pennant.prodmtr.model.view.ProjectSummary;
import com.pennant.prodmtr.model.view.SubtaskSummary;
import com.pennant.prodmtr.model.view.TaskSummary;
import com.pennant.prodmtr.service.Interface.AnalyticService;

public class AnalyticServiceImpl implements AnalyticService {

	@Autowired
	private AnalyticsDao analyticsDao;

	// Constructor
	public AnalyticsDto getSummariesByUserId(int userId) {
		AnalyticsDto summaryOutput = new AnalyticsDto();

		List<ProjectSummary> projectSummaries = analyticsDao.getProjectSummariesByUserId(userId);
		List<ModuleSummary> moduleSummaries = analyticsDao.getModuleSummariesByUserId(userId);
		List<TaskSummary> taskSummaries = analyticsDao.getTaskSummariesByUserId(userId);
		List<SubtaskSummary> subtaskSummaries = analyticsDao.getSubtaskSummariesByUserId(userId);
		List<Past30CompletionSummary> past30CompletionSummaries = analyticsDao.getPast30CompletionSummaries();
		summaryOutput.setProjectSummaries(projectSummaries);
		summaryOutput.setModuleSummaries(moduleSummaries);
		summaryOutput.setTaskSummaries(taskSummaries);
		summaryOutput.setSubtaskSummaries(subtaskSummaries);

		return summaryOutput;
	}

	public List<Past30CompletionSummary> getPast30CompletionSummary() {
		return analyticsDao.getPast30CompletionSummaries();
	}
}

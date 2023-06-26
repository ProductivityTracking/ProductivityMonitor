package com.pennant.prodmtr.Dao.Interface;

import java.util.List;

import com.pennant.prodmtr.model.view.ModuleSummary;
import com.pennant.prodmtr.model.view.Past30CompletionSummary;
import com.pennant.prodmtr.model.view.ProjectSummary;
import com.pennant.prodmtr.model.view.SubtaskSummary;
import com.pennant.prodmtr.model.view.TaskSummary;

public interface AnalyticsDao {
	List<ProjectSummary> getProjectSummariesByUserId(int userId);

	List<ModuleSummary> getModuleSummariesByUserId(int userId);

	List<TaskSummary> getTaskSummariesByUserId(int userId);

	List<SubtaskSummary> getSubtaskSummariesByUserId(int userId);

	List<Past30CompletionSummary> getPast30CompletionSummaries();

}

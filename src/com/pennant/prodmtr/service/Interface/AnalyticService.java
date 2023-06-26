package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.AnalyticsDto;
import com.pennant.prodmtr.model.view.Past30CompletionSummary;

public interface AnalyticService {
	public AnalyticsDto getSummariesByUserId(int userId);

	public List<Past30CompletionSummary> getPast30CompletionSummary();

}
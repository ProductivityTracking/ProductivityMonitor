package com.pennant.prodmtr.Dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pennant.prodmtr.Dao.Interface.AnalyticsDao;
import com.pennant.prodmtr.model.view.ModuleSummary;
import com.pennant.prodmtr.model.view.Past30CompletionSummary;
import com.pennant.prodmtr.model.view.ProjectSummary;
import com.pennant.prodmtr.model.view.SubtaskSummary;
import com.pennant.prodmtr.model.view.TaskSummary;

@Component
public class AnalyticsDaoImpl implements AnalyticsDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public AnalyticsDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<ProjectSummary> getProjectSummariesByUserId(int userId) {
		String sql = "SELECT p.proj_id, p.proj_name, ABS(SUM(EXTRACT(EPOCH FROM (t.task_cmp_datetime - t.task_cdatetime))) / 3600) AS total_working_hours "
				+ "FROM T4_Projects p " + "JOIN T4_ProjectTasks pt ON p.proj_id = pt.proj_id "
				+ "JOIN T4_Tasks t ON pt.task_id = t.task_id " + "WHERE pt.task_user_id = ? "
				+ "GROUP BY p.proj_id, p.proj_name";

		List<ProjectSummary> projectSummaries = jdbcTemplate.query(sql, new Object[] { userId }, (rs, rowNum) -> {
			ProjectSummary summary = new ProjectSummary();
			summary.setProjId(rs.getInt("proj_id"));
			summary.setProjName(rs.getString("proj_name"));
			summary.setTotalWorkingHours(rs.getDouble("total_working_hours"));
			return summary;
		});

		return projectSummaries;
	}

	public List<ModuleSummary> getModuleSummariesByUserId(int userId) {
		String sql = "SELECT m.modl_id, m.modl_name, ABS(SUM(EXTRACT(EPOCH FROM (t.task_cmp_datetime - t.task_cdatetime))) / 3600) AS total_working_hours "
				+ "FROM T4_ProjectModules m " + "JOIN T4_ProjectTasks pt ON m.modl_id = pt.task_modl_id "
				+ "JOIN T4_Tasks t ON pt.task_id = t.task_id " + "WHERE pt.task_user_id = ? "
				+ "GROUP BY m.modl_id, m.modl_name";

		List<ModuleSummary> moduleSummaries = jdbcTemplate.query(sql, new Object[] { userId }, (rs, rowNum) -> {
			ModuleSummary summary = new ModuleSummary();
			summary.setModlId(rs.getInt("modl_id"));
			summary.setModlName(rs.getString("modl_name"));
			summary.setTotalWorkingHours(Math.abs(rs.getDouble("total_working_hours"))); // Use Math.abs() to convert to
																							// positive
			return summary;
		});

		return moduleSummaries;
	}

	public List<TaskSummary> getTaskSummariesByUserId(int userId) {
		String sql = "SELECT t.task_id, t.task_name, ABS(SUM(EXTRACT(EPOCH FROM (t.task_cmp_datetime - t.task_cdatetime))) / 3600) AS total_working_hours "
				+ "FROM T4_Tasks t " + "JOIN T4_ProjectTasks pt ON t.task_id = pt.task_id "
				+ "WHERE pt.task_user_id = ? " + "GROUP BY t.task_id, t.task_name";

		List<TaskSummary> taskSummaries = jdbcTemplate.query(sql, new Object[] { userId }, (rs, rowNum) -> {
			TaskSummary summary = new TaskSummary();
			summary.setTaskId(rs.getInt("task_id"));
			summary.setTaskName(rs.getString("task_name"));
			summary.setTotalWorkingHours(Math.abs(rs.getDouble("total_working_hours"))); // Use Math.abs() to convert to
																							// positive
			return summary;
		});
		return taskSummaries;
	}

	public List<SubtaskSummary> getSubtaskSummariesByUserId(int userId) {
		String sql = "SELECT st.sbts_id, ABS(SUM(EXTRACT(EPOCH FROM (t.task_cmp_datetime - t.task_cdatetime))) / 3600) AS total_working_hours "
				+ "FROM T4_SubTasks st " + "JOIN T4_Tasks t ON st.task_id = t.task_id "
				+ "JOIN T4_ProjectTasks pt ON t.task_id = pt.task_id " + "WHERE pt.task_user_id = ? "
				+ "GROUP BY st.sbts_id";

		List<SubtaskSummary> subtaskSummaries = jdbcTemplate.query(sql, new Object[] { userId }, (rs, rowNum) -> {
			SubtaskSummary summary = new SubtaskSummary();
			summary.setSubtaskId(rs.getInt("sbts_id"));
			summary.setTotalWorkingHours(Math.abs(rs.getDouble("total_working_hours"))); // Use Math.abs() to convert to
																							// positive
			return summary;
		});

		return subtaskSummaries;
	}

	public List<Past30CompletionSummary> getPast30CompletionSummaries() {
		String sql = "SELECT generated_dates.completed_date::date, " + "COUNT(DISTINCT t.task_id) AS tasks_completed, "
				+ "COUNT(DISTINCT st.sbts_id) AS subtasks_completed "
				+ "FROM (SELECT (CURRENT_DATE - SEQUENCE.DAY * INTERVAL '1 day') AS completed_date "
				+ "      FROM generate_series(0, 29) AS SEQUENCE(DAY)) generated_dates "
				+ "LEFT JOIN T4_Tasks t ON DATE_TRUNC('day', t.task_cmp_datetime) = generated_dates.completed_date "
				+ "LEFT JOIN T4_SubTasks st ON st.task_id = t.task_id AND DATE_TRUNC('day', t.task_cmp_datetime) = generated_dates.completed_date "
				+ "GROUP BY generated_dates.completed_date " + "ORDER BY generated_dates.completed_date DESC";

		List<Past30CompletionSummary> past30CompletionSummary = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Past30CompletionSummary summary = new Past30CompletionSummary();
			summary.setCompletedDate(rs.getDate("completed_date").toString());
			summary.setTasksCompleted(rs.getInt("tasks_completed"));
			summary.setSubtasksCompleted(rs.getInt("subtasks_completed"));
			return summary;
		});

		return past30CompletionSummary;
	}

}

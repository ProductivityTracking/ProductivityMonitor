package com.pennant.prodmtr.Dao.Interface;

import com.pennant.prodmtr.model.Entity.Subtask;

public interface SubtaskDao {
	Subtask save(Subtask subtask);

	void saveSubtask(Subtask subtask);

	void setNewSubTask(Subtask subtask);

	// Other methods for subtask-related operations
}

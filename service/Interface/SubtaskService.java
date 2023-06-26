package com.pennant.prodmtr.service.Interface;

import com.pennant.prodmtr.model.Entity.Subtask;
import com.pennant.prodmtr.model.Input.SubtaskInput;

public interface SubtaskService {

	public void saveSubtask(Subtask subtask);

	public void setNewSubTask(SubtaskInput subtaskInput);
}

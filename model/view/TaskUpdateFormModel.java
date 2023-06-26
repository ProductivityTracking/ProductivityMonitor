package com.pennant.prodmtr.model.view;

public class TaskUpdateFormModel {
	  private int taskId;
	    private String remarks;
	    private String status;

	    // Getters and setters



	    public String getRemarks() {
	        return remarks;
	    }

	    public void setRemarks(String remarks) {
	        this.remarks = remarks;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public int getTaskId() {
			return taskId;
		}

		public void setTaskId(int taskId) {
			this.taskId = taskId;
		}

		public void setStatus(String status) {
	        this.status = status;
	    }
	}
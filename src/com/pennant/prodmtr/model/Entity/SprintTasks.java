package com.pennant.prodmtr.model.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pm_SprintTasks")
public class SprintTasks {
	@EmbeddedId
	private SprintTasksId id;

	// @ManyToOne
	// @JoinColumn(name = "sprn_id", insertable = false, updatable = false)
	// private Sprint sprint;
	//
	// @OneToOne
	// @JoinColumn(name = "task_id", insertable = false, updatable = false)
	// private Task task;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public SprintTasks(SprintTasksId id, User user) {
		this.id = id;

		this.user = user;
	}

	public SprintTasksId getId() {
		return id;
	}

	public void setId(SprintTasksId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SprintTasks [id=" + id + ", user=" + user.getUserDisplayName() + "]";
	}

	public SprintTasks() {
		super();
	}

}
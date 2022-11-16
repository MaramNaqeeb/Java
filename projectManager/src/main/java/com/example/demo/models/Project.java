package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "The title must not be blank!")
	private String title;
	@NotEmpty(message = "The description must not be blank!")
	private String description;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date due_date;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leadId")
	private User lead;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_projects", joinColumns = @JoinColumn(name = "projectId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<User> users;
	public Project() {

	}



	public Project(@NotEmpty(message = "The title must not be blank!") String title,
			@NotEmpty(message = "The description must not be blank!") String description, @Future Date due_date,
			User lead) {
		
		this.title = title;
		this.description = description;
		this.due_date = due_date;
		this.lead = lead;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDue_date() {
		return due_date;
	}



	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public User getLead() {
		return lead;
	}



	public void setLead(User lead) {
		this.lead = lead;
	}



	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}



	
	}


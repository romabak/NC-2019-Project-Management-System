package com.netcracker.name.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDBModel {

    private Date dueDate;
    private Date createdDate;
    private Date updateDate;
    private ProjectViewModel project;
    private int estimation;
    private StatusViewModel status;
    private UserDBModel assignee;
    private PriorityViewModel priority;
    private String description;
    private String name;
    private String ticketCode;
    private UserDBModel reporter;

    public TaskDBModel() {
    }

    public UserDBModel getReporter() {
        return reporter;
    }

    public void setReporter(UserDBModel reporter) {
        this.reporter = reporter;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public ProjectViewModel getProject() {
        return project;
    }

    public void setProject(ProjectViewModel project) {
        this.project = project;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public StatusViewModel getStatus() {
        return status;
    }

    public void setStatus(StatusViewModel status) {
        this.status = status;
    }

    public UserDBModel getAssignee() {
        return assignee;
    }

    public void setAssignee(UserDBModel assignee) {
        this.assignee = assignee;
    }

    public PriorityViewModel getPriority() {
        return priority;
    }

    public void setPriority(PriorityViewModel priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

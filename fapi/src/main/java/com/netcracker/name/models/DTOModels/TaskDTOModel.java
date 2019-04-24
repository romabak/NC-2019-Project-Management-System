package com.netcracker.name.models.DTOModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.name.models.*;

import java.sql.Date;

public class TaskDTOModel {

    private Date dueDate;
    private Date createdDate;
    private Date updateDate;
    private String project;
    private int estimation;
    private String status;
    private String assignee;
    private String priority;
    private String description;
    private String name;
    private String ticketCode;
    private String reporter;

    public TaskDTOModel(){
    }

    public TaskDTOModel(TaskDBModel task){
        this(
                task.getDueDate(),
                task.getCreatedDate(),
                task.getUpdateDate(),
                task.getProject().getCode(),
                task.getEstimation(),
                task.getStatus().getStatus(),
                task.getAssignee().getFirstName() + " " + task.getAssignee().getSecondName(),
                task.getPriority().getPriority(),
                task.getDescription(),
                task.getName(),
                null,
                null
        );
    }

    public TaskDTOModel(Date dueDate, Date createdDate, Date updateDate, String project, int estimation, String status, String assignee, String priority, String description, String name, String ticketCode, String reporter) {
        this.dueDate = dueDate;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
        this.project = project;
        this.estimation = estimation;
        this.status = status;
        this.assignee = assignee;
        this.priority = priority;
        this.description = description;
        this.name = name;
        this.ticketCode = ticketCode;
        this.reporter = reporter;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
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

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
}

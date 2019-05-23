package com.netcracker.edu.models.DTOModels;

import com.netcracker.edu.models.*;

import java.sql.Date;

public class TaskDTOModel {

    private int id;
    private Date dueDate;
    private Date createdDate;
    private Date updateDate;
    private Date resolvedDate;
    private Date closedDate;
    private String project;
    private int estimation;
    private String status;
    private UserDTOModel assignee;
    private String priority;
    private String description;
    private String name;
    private String ticketCode;
    private UserDTOModel reporter;

    public TaskDTOModel(){
    }

    public TaskDTOModel(TaskDBModel task){
        this(
                task.getId(),
                task.getDueDate(),
                task.getCreatedDate(),
                task.getUpdateDate(),
                task.getResolvedDate(),
                task.getClosedDate(),
                task.getProject().getCode(),
                task.getEstimation(),
                task.getStatus().getStatus(),
                new UserDTOModel(task.getAssignee()),
                task.getPriority().getPriority(),
                task.getDescription(),
                task.getName(),
                task.getTicketCode(),
                new UserDTOModel(task.getReporter())
        );
    }

    public TaskDTOModel(int id, 
        Date dueDate, 
        Date createdDate, 
        Date updateDate,
        Date resolvedDate,
        Date closedDate, 
        String project, 
        int estimation, 
        String status, 
        UserDTOModel assignee, 
        String priority, 
        String description, 
        String name, 
        String ticketCode, 
        UserDTOModel reporter) {
        this.id = id;
        this.dueDate = dueDate;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
        this.resolvedDate = resolvedDate;
        this.closedDate = closedDate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date updateDate) {
        this.resolvedDate = resolvedDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
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

    public UserDTOModel getAssignee() {
        return assignee;
    }

    public void setAssignee(UserDTOModel assignee) {
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

    public UserDTOModel getReporter() {
        return reporter;
    }

    public void setReporter(UserDTOModel reporter) {
        this.reporter = reporter;
    }

    @Override
    public String toString() {
        return "TaskDTOModel{" +
                "id=" + id +
                ", dueDate=" + dueDate +
                ", createdDate=" + createdDate +
                ", updateDate=" + updateDate +
                ", project='" + project + '\'' +
                ", estimation=" + estimation +
                ", status='" + status + '\'' +
                ", assignee=" + assignee.toString() +
                ", priority='" + priority.toString() + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", ticketCode='" + ticketCode + '\'' +
                ", reporter='" + reporter + '\'' +
                '}';
    }
}

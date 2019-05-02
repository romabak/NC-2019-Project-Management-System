package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "netcracker")
public class TaskEntity {

    private int id;
    private Date createdDate;
    private String description;
    private Date dueDate;
    private int estimation;
    private String name;
    private String ticketCode;
    private Date updateDate;
    private Integer reporter;
    private PriorityEntity priority;
    private StatusEntity status;
    private UserEntity assignee;
    private ProjectEntity project;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name = "created_date")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    
    @Column(name = "estimation")
    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    
    @Column(name = "edu")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name = "ticket_code")
    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    
    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    
    @Column(name = "reporter")
    public Integer getReporter() {
        return reporter;
    }

    public void setReporter(Integer reporter) {
        this.reporter = reporter;
    }

    @PrePersist
    public void prePresist(){
        // java.util.Date now = new java.util.Date();
        // this.createdDate = this.updateDate = new java.sql.Date(now.getTime());
        StatusEntity status = new StatusEntity(1, "open");
        this.status = status;
        this.reporter = null;
    }

    @PreUpdate
    public void preUpdate(){
        this.updateDate = new java.sql.Date(new java.util.Date().getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return id == that.id &&
                estimation == that.estimation &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(name, that.name) &&
                Objects.equals(ticketCode, that.ticketCode) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(reporter, that.reporter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, description, dueDate, estimation, name, ticketCode, updateDate, reporter);
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id", nullable = false)
    public PriorityEntity getPriority(){
	    return priority;
    }

    public void setPriority(PriorityEntity priority){
	    this.priority = priority;
    }

    @ManyToOne
    @JoinColumn(name = "assignee", referencedColumnName = "id", nullable = false)
    public UserEntity getAssignee() {
        return assignee;
    }

    public void setAssignee(UserEntity assignee) {
        this.assignee = assignee;
    }

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }
}

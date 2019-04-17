package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "netcracker", catalog = "")
public class TaskEntity {
    private int id;
    private Date createdDate;
    private String description;
    private Date dueDate;
    private int estimation;
    private String name;
    private Date ticketCode;
    private Date updateDate;
    private Collection<CommentEntity> commentsById;
    private StatusEntity statusByStatusId;
    private UserEntity userByAssignee;
    private UserEntity userByReporter;
    private PriorityEntity priorityByPriorityId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created_date")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "estimation")
    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ticket_code")
    public Date getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(Date ticketCode) {
        this.ticketCode = ticketCode;
    }

    @Basic
    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, description, dueDate, estimation, name, ticketCode, updateDate);
    }

    @OneToMany(mappedBy = "taskByTaskId")
    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public StatusEntity getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "assignee", referencedColumnName = "id")
    public UserEntity getUserByAssignee() {
        return userByAssignee;
    }

    public void setUserByAssignee(UserEntity userByAssignee) {
        this.userByAssignee = userByAssignee;
    }

    @ManyToOne
    @JoinColumn(name = "reporter", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByReporter() {
        return userByReporter;
    }

    public void setUserByReporter(UserEntity userByReporter) {
        this.userByReporter = userByReporter;
    }

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id", nullable = false)
    public PriorityEntity getPriorityByPriorityId() {
        return priorityByPriorityId;
    }

    public void setPriorityByPriorityId(PriorityEntity priorityByPriorityId) {
        this.priorityByPriorityId = priorityByPriorityId;
    }
}

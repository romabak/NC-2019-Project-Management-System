package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "netcracker", catalog = "")
public class UserEntity {
    private int id;
    private String email;
    private String firstName;
    private String secondName;
    private String password;
    private Collection<CommentEntity> commentsById;
    private Collection<TaskEntity> tasksById;
    private Collection<TaskEntity> tasksById_0;
    private ProjectEntity projectByProjectId;
    private int roleId;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name")
    public String getSecond_name() {
        return secondName;
    }

    public void setSecond_name(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, secondName, password);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "userByAssignee")
    public Collection<TaskEntity> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<TaskEntity> tasksById) {
        this.tasksById = tasksById;
    }

    @OneToMany(mappedBy = "userByReporter")
    public Collection<TaskEntity> getTasksById_0() {
        return tasksById_0;
    }

    public void setTasksById_0(Collection<TaskEntity> tasksById_0) {
        this.tasksById_0 = tasksById_0;
    }

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    public ProjectEntity getProjectByProjectId() {
        return projectByProjectId;
    }

    public void setProjectByProjectId(ProjectEntity projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public int getRole_id() {
        return roleId;
    }

    public void setRole_id(int roleId) {
        this.roleId = roleId;
    }
}

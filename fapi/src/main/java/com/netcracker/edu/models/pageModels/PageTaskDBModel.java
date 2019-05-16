package com.netcracker.edu.models.pageModels;

import com.netcracker.edu.models.TaskDBModel;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageTaskDBModel {

    private List<TaskDBModel> content;
    private int totalPages;
    private int numberOfElements;
    private int size;
    private int totalElements;


    public PageTaskDBModel() {
    }

    public List<TaskDBModel> getContent() {
        return content;
    }

    public void setContent(List<TaskDBModel> content) {
        this.content = content;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {

        return "PageTaskDBModel{" +
                "content= " + content +
                // "content=" + content.stream().map(TaskDBModel::toString).collect(Collectors.toList()) +
                ", totalPages=" + totalPages +
                ", numberOfElements=" + numberOfElements +
                ", size=" + size +
                ", totalElements=" + totalElements +
                '}';
    }
}

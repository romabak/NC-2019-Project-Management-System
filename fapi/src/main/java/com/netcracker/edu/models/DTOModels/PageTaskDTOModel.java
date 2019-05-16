package com.netcracker.edu.models.DTOModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.netcracker.edu.models.pageModels.PageUserDBModel;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageTaskDTOModel {

    private List<TaskDTOModel> content;
    private int totalPages;
    private int numberOfElements;
    private int size;
    private int totalElements;

    public PageTaskDTOModel(PageUserDBModel pageDb) {
    }

    public PageTaskDTOModel(List<TaskDTOModel> content, int totalPages, int numberOfElements, int size, int totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.numberOfElements = numberOfElements;
        this.size = size;
        this.totalElements = totalElements;
    }

    public List<TaskDTOModel> getContent() {
        return content;
    }

    public void setContent(List<TaskDTOModel> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
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

    @Override
    public String toString() {
        return "PageTaskDTOModel{" +
                "content=" + content.stream().map(TaskDTOModel::toString).collect(Collectors.toList()) +
                ", totalPages=" + totalPages +
                ", numberOfElements=" + numberOfElements +
                ", size=" + size +
                ", totalElements=" + totalElements +
                '}';
    }
}

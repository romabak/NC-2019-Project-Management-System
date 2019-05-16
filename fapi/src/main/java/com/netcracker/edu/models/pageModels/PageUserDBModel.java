package com.netcracker.edu.models.pageModels;

import com.netcracker.edu.models.UserDBModel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageUserDBModel {

    private List<UserDBModel> content;
    private int totalPages;
    private int numberOfElements;
    private int size;
    private int totalElements;


    public PageUserDBModel() {
    }

    public List<UserDBModel> getContent() {
        return content;
    }

    public void setContent(List<UserDBModel> content) {
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
}
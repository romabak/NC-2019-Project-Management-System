package com.netcracker.edu.models;

import java.util.List;

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
}

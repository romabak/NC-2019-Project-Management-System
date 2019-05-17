package com.netcracker.edu.models.DTOModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.models.pageModels.PageUserDBModel;

import java.util.List;
import java.util.stream.Collectors;

public class PageUserDTOModel {

        private List<UserDTOModel> content;
        private int totalPages;
        private int numberOfElements;
        private int size;
        private int totalElements;


        public PageUserDTOModel() {

        }

        public PageUserDTOModel(List<UserDTOModel> content, int totalPages, int numberOfElements, int size, int totalElements){
            this.content = content;
            this.totalPages = totalPages;
            this.numberOfElements = numberOfElements;
            this.size = size;
            this.totalElements = totalElements;
        }

        public PageUserDTOModel(PageUserDBModel page){
            this(
                    page.getContent().stream().map(user-> new UserDTOModel(user)).collect(Collectors.toList()),
                    page.getTotalPages(),
                    page.getNumberOfElements(),
                    page.getSize(),
                    page.getTotalElements()
                    );
        }

        public List<UserDTOModel> getContent() {
            return content;
        }

        public void setContent(List<UserDTOModel> content) {
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

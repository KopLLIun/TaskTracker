package com.intexsoft.nikita.entity;

public class TaskStatus {

    private Long id;

    private String status;

    public TaskStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return status;
    }

    public void setCondition(String condition) {
        this.status = condition;
    }
}

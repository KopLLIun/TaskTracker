package com.intexsoft.nikita.entity;


import lombok.Data;

@Data
public class TaskTypeCustomFields {

    private Long id;

    private String customField;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }
}

package com.intexsoft.nikita.entity;

import lombok.Data;

@Data
public class TaskTypeCustomFieldsValues {

    private Long id;

    private String customValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomValue() {
        return customValue;
    }

    public void setCustomValue(String customValue) {
        this.customValue = customValue;
    }
}

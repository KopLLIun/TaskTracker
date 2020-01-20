package com.intexsoft.nikita.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table
public class Role {

    private Long id;

    private String roleName;

    public Role() {
    }
}

package com.intexsoft.nikita.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "task_type_custom_fields_values")
public class TaskTypeCustomFieldsValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "custom_value")
    private String customValue;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "type_custom_fields_id")
    private TaskTypeCustomFields typeCustomFields;

    public TaskTypeCustomFieldsValues() {
    }

    @Override
    public String toString() {
        return "TaskTypeCustomFieldsValues{" +
                "id=" + id +
                ", customValue='" + customValue + '\'' +
                '}';
    }
}

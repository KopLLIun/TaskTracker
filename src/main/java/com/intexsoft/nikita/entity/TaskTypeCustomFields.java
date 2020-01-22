package com.intexsoft.nikita.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Entity
@Table(name = "task_type_custom_fields")
public class TaskTypeCustomFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "custom_field")
    private String customField;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "task_type_id")
    private TaskType type;

    @OneToMany(mappedBy = "typeCustomFields", fetch = FetchType.EAGER)
    private List<TaskTypeCustomFieldsValues> typeCustomFieldsValues;

    public TaskTypeCustomFields() {
    }

    @Override
    public String toString() {
        return "TaskTypeCustomFields{" +
                "id=" + id +
                ", customField='" + customField + '\'' + '\n' +
                ", typeCustomFieldsValues=" + typeCustomFieldsValues +
                '}';
    }
}

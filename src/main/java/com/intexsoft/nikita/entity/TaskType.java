package com.intexsoft.nikita.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Entity
@Table(name = "task_type")
public class TaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Set<Task> tasks;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Set<TaskTypeCustomFields> typeCustomFields;

    public TaskType() {
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "id=" + id +
                ", name='" + name + '\'' + '\n' +
                ", typeCustomFields=" + typeCustomFields +
                '}';
    }
}

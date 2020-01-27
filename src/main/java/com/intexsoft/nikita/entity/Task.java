package com.intexsoft.nikita.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    private Long id;

    private String description;

    @JsonProperty("start_date")
    @Column(name = "start_date")
    private Date startDate;

    @JsonProperty("finish_date")
    @Column(name = "finish_date")
    private Date finishDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private TaskType type;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TaskJournal> journals;

    @ManyToOne(optional = false)
    @JoinColumn(name = "executor_id")
    private User executor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id")
    private Request request;

    public Task(){}

/*    public Task(Long id, String description, Long executorId) {
        this.id = id;
        this.description = description;
        this.executorId = executorId;
    }

    public Task(Long id, String description, Long requestId, Long assigneeId, Long executorId) {
        this.id = id;
        this.description = description;
        this.requestId = requestId;
        this.assigneeId = assigneeId;
        this.executorId = executorId;
    }*/

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate + '\n' +
                ", executorId=" + executor.getId() + '\n' +
                ", assigneeId=" + assignee.getId() + '\n' +
                ", comments=" + comments + '\n' +
                ", journals=" + journals + '\n' +
                ", request=" + request + '\n' +
                ", type=" + type +
                '}';
    }
}

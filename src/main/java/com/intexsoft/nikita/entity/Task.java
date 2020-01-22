package com.intexsoft.nikita.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
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

/*    @JsonProperty("type_id")
    @Column(name = "type_id")
    private Long typeId;

    @JsonProperty("request_id")
    @Column(name = "request_id")
    private Long requestId;*/

/*    @JsonProperty("assignee_id")
    @Column(name = "assignee_id")
    private Long assigneeId;

    @JsonProperty("executor_id")
    @Column(name = "executor_id")
    private Long executorId;*/

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private TaskType type;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private Set<TaskJournal> journals;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "assignee_id")
    private User assigneeId;


    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "executor_id")
    private User executorId;


    @OneToOne(optional = false, cascade = CascadeType.ALL)
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
                ", executorId=" + executorId + '\n' +
                ", assigneeId=" + assigneeId + '\n' +
                ", comments=" + comments + '\n' +
                ", journals=" + journals + '\n' +
                ", request=" + request + '\n' +
                ", type=" + type +
                '}';
    }
}

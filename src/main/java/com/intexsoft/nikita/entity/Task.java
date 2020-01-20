package com.intexsoft.nikita.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@ToString
@Data
@Table
public class Task {

    @Id

    private Long id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("finish_date")
    private Date finishDate;

    @JsonProperty("request_id")
    private Long requestId;

    @JsonProperty("assignee_id")
    private Long assigneeId;

    @JsonProperty("executor_id")
    private Long executorId;

    public Task() {
    }

    public Task(Long id, String description, Long executorId) {
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
    }
}

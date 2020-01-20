package com.intexsoft.nikita.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskJournal {

    private Long id;

    private String entryJournal;

    private Date startDate;

    private Date finishDate;

    public TaskJournal() {
    }
}

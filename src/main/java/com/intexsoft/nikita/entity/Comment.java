package com.intexsoft.nikita.entity;


import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table
public class Comment {

    private Long id;

    private String text;

    private Date date;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

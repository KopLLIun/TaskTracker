package com.intexsoft.nikita.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    private String description;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @OneToOne(mappedBy = "request", fetch = FetchType.EAGER)
    private Task task;

    public Request() {}

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", clientName='" + clientName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}

package com.intexsoft.nikita.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@AllArgsConstructor
@Entity
@Table(name = "user")
@Builder(toBuilder = true)
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    private String name;

    private String surname;

    private String login;

    private char[] password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "executor")
    private Set<Task> executorTask;

    @OneToMany(mappedBy = "assignee")
    private Set<Task> assigneeTask;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password=" + Arrays.toString(password) + '\n' +
//                ", roles=" + roles +
                '}';
    }
}

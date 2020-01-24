package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.User;

public interface IUserRepository {

    void addUser(User user);
    User getUserById(Long id);
}

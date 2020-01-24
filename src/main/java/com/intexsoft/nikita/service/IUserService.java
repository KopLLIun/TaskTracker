package com.intexsoft.nikita.service;

import com.intexsoft.nikita.entity.User;

public interface IUserService {

    void addUser(User user);
    User getUserById(Long id);
}

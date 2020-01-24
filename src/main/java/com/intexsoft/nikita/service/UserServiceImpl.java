package com.intexsoft.nikita.service;

import com.intexsoft.nikita.entity.User;
import com.intexsoft.nikita.repository.IUserRepository;
import com.intexsoft.nikita.repository.UserRepositoryImpl;

public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}

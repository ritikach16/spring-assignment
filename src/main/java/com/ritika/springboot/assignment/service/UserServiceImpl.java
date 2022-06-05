package com.ritika.springboot.assignment.service;

import com.ritika.springboot.assignment.dao.UserRepository;
import com.ritika.springboot.assignment.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}

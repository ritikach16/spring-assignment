package com.ritika.springboot.assignment.service;

import com.ritika.springboot.assignment.dao.UserRepository;
import com.ritika.springboot.assignment.entity.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestUserService {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
     void save(){
        User user = new User("ritika","test123");
        userService.save(user);
        when(userRepository.save(user)).thenReturn(user);
        User returnUser = new User("ritika","test123");
        assertEquals(user, returnUser);
    }
}

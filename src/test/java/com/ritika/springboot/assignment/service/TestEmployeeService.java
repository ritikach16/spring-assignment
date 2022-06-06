package com.ritika.springboot.assignment.service;


import com.ritika.springboot.assignment.dao.EmployeeRepository;
import com.ritika.springboot.assignment.entity.Employee;
import com.ritika.springboot.assignment.entity.Item;
import com.ritika.springboot.assignment.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
 class TestEmployeeService {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;


    @Test
    void findById(){
        Employee employee = new Employee(1,"ritika", "chauhan", "zemoso@gmail.com", new User("riti", "LSAzWB9dymFbCUtAPbgXwOwYHMDeMRs8qZDG0kvB94aDVnZmcAhO2"));

        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        assertEquals(employee, employeeService.findById(1));
    }

    @Test
    void save(){
        Employee employee = new Employee(1,"ritika", "chauhan", "zemoso@gmail.com", new User("riti", "LSAzWB9dymFbCUtAPbgXwOwYHMDeMRs8qZDG0kvB94aDVnZmcAhO2"));
        employeeService.save(employee);
        when(employeeRepository.findById(6)).thenReturn(Optional.of(employee));
        assertEquals(employee, employeeService.findById(6));
    }

    @Test
    void deleteById(){
        employeeService.deleteById(1);
        verify(employeeRepository, times(1)).deleteById(1);
    }
}

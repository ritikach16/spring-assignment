package com.ritika.springboot.assignment.controller;

import com.ritika.springboot.assignment.entity.Employee;
import com.ritika.springboot.assignment.entity.User;
import com.ritika.springboot.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmployee,
                               BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            System.out.println(theEmployee);
            model.addAttribute("employee", theEmployee);
            return "redirect:/employees/showFormForAdd";
        }
        // save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        Employee theEmployee = employeeService.findById(theId);

      theModel.addAttribute("employee", theEmployee);

       return "employees/employee-form";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }


}

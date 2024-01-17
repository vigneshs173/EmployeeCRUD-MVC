package com.employees.controller;

import com.employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.employees.Service.EmpService;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EmpController {

    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/add")
    public String insert(@ModelAttribute Employee employee, Model model) {
        empService.validation(employee, model);
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> employeeList = empService.getAllEmployee();
        model.addAttribute("employees", employeeList);
        return "list";
    }

    @GetMapping("delete/{empid}")
    public String delete(@PathVariable("empid") Integer empid) {
        empService.deleteEmployee(empid);
        return "redirect:/list";
    }

    @GetMapping("update/{empid}")
    public String update(@PathVariable Integer empid, Model model) {
        model.addAttribute("employee",empService.getEmployee(empid));
        return "update";
    }

    @PostMapping("update/updateEmp")
    public String updateEmp(@ModelAttribute Employee employee) {

        empService.updateNow(employee);
        return "redirect:/list";
    }




    //Testing page --> Here handling NULL values with help of @Valid
    @GetMapping("/test")
    public String test(Model model)
    {
        model.addAttribute("employee",new Employee());
        return "test";
    }

    @PostMapping("/test")
    public String test2(@ModelAttribute("employee") @Valid Employee employee, Errors result, Model model) {
        if (result.hasErrors()) {
            return "test";
        }

        //Execute when not null
        empService.addEmployee(employee);
        return "redirect:/list";
    }
}

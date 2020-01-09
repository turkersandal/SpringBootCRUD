package com.example.SimpleCrud.Controller;


import com.example.SimpleCrud.Model.Employee;
import com.example.SimpleCrud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String get(Model model){
    model.addAttribute("list",service.listAll());
        return "index";
    }

    @GetMapping("/new")
    public String newEmployee(Model model){

        Employee emp = new Employee();
        model.addAttribute("emp",emp);
        return "new-employee";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("emp") Employee emp){
        service.save(emp);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView update(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit-employee");
        Employee emp = service.get(id);
        mav.addObject("emp",emp);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        service.delete(id);
        return "redirect:/";
    }


}

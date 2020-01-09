package com.example.SimpleCrud.Service;


import com.example.SimpleCrud.Model.Employee;
import com.example.SimpleCrud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAll(){

        return employeeRepository.findAll();
    }

    public void save(Employee emp){

        employeeRepository.save(emp);

    }

    public Employee get(long id){

        return employeeRepository.findById(id).get();
    }

    public void delete(long id){

        employeeRepository.deleteById(id);
    }


}

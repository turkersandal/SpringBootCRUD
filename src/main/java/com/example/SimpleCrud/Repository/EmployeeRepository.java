package com.example.SimpleCrud.Repository;

import com.example.SimpleCrud.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

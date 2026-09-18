package com.vk.service;

import com.vk.entity.Employee;
import com.vk.exception.EmployeeNotFoundException;
import com.vk.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo empRepo;

    @Autowired
    public EmployeeService(EmployeeRepo empRepo){

        this.empRepo=empRepo;
    }

    public Employee saveEmp(Employee emp){

        return empRepo.save(emp);
    }

    public List<Employee> getAllEmp(){

        return empRepo.findAll();
    }

    public Employee getEmpById(Integer id) {

        return empRepo.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + id
                        )
                );
    }

    public Employee updateEmpById(Integer id, Employee emp) {

        Employee existEmp = empRepo.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Cannot update. Employee not found with id: " + id
                        )
                );

        existEmp.setName(emp.getName());
        existEmp.setSalary(emp.getSalary());
        existEmp.setDepartment(emp.getDepartment());

        return empRepo.save(existEmp);
    }

    public void deleteEmp(Integer id) {

        if (!empRepo.existsById(id)) {
            throw new EmployeeNotFoundException(
                    "Cannot delete. Employee not found with id: " + id
            );
        }

        empRepo.deleteById(id);
    }

}

package com.vk.controller;

import com.vk.entity.Employee;
import com.vk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp/api")
public class EployeeController {

    private final EmployeeService empService;

    @Autowired
    public EployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(empService.saveEmp(employee));
    }

    @GetMapping("/findAllEmp")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(empService.getAllEmp());
    }

    @GetMapping("/getEmpBy/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee employee = empService.getEmpById(id);
        return employee != null
                ? ResponseEntity.ok(employee)
                : ResponseEntity.notFound().build();
    }

    @PatchMapping("/updateEmpBy/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Integer id,
            @RequestBody Employee employee) {
        Employee updatedEmployee = empService.updateEmpById(id, employee);
        return updatedEmployee != null
                ? ResponseEntity.ok(updatedEmployee)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteEmpBy/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        if (empService.getEmpById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        empService.deleteEmp(id);
        return ResponseEntity.noContent().build();
    }
}

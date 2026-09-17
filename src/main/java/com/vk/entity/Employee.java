package com.vk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "EmployeeDetailes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @SequenceGenerator(name="gen1",sequenceName="emp_tb1",initialValue=100,allocationSize=1)
    @GeneratedValue(generator="gen1" ,strategy= GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private Long salary;

    private String department;
}

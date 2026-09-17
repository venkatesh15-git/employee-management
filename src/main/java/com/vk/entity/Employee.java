package com.vk.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotBlank(message = "Name is required.")
    private String name;

    @NotNull
    @Positive(message = "salary can't be Negative")
    private Long salary;

    @NotBlank(message="Dept is required")
    private String department;
}

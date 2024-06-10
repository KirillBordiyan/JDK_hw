package org.example.hw4Collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String number;
    private String fullName;
    private Integer experience;

    public Employee(Integer id, EmployeeDTO dto) {
        this.id = id;
        this.number = dto.getNumber();
        this.fullName = dto.getFullName();
        this.experience = dto.getExperience();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", number=" + number +
                ", fullName=" + fullName +
                ", experience=" + experience;
    }
}

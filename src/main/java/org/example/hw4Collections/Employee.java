package org.example.hw4Collections;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String number;
    private String fullName;
    private Integer experience;

    public Employee(Integer id, EmployeeDto dto) {
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

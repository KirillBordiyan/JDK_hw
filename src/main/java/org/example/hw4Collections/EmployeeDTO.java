package org.example.hw4Collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private String number;
    private String fullName;
    private Integer experience;

    @Override
    public String toString() {
        return "number=" + number +
                ", fullName=" + fullName +
                ", experience=" + experience;
    }
}

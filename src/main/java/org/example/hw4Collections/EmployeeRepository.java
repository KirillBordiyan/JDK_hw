package org.example.hw4Collections;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class EmployeeRepository {

    private final Map<Integer, EmployeeDTO> EDict = new HashMap<>();

    //не сказано, что его обязательно вернуть
    public Employee findById(Integer id) {
        try {
            if (!EDict.containsKey(id)) {
                throw new NullPointerException("No matchers by ID: ");
            }
            return new Employee(id, EDict.get(id));
        } catch (NullPointerException e) {
            System.out.printf(e.getMessage() + id + "\n");
        }
        return null;
    }

    public Map<Integer, EmployeeDTO> findByFullName(String fullName) {
        Map<Integer, EmployeeDTO> result = new HashMap<>();
        EDict.entrySet().stream()
                .filter(empl -> empl.getValue().getFullName().contains(fullName))
                .forEach(el -> result.put(el.getKey(), el.getValue()));
        return result;
    }

    public Map<Integer, EmployeeDTO> findByExperience(Integer exp) {
        Map<Integer, EmployeeDTO> result = new HashMap<>();
        EDict.entrySet().stream()
                .filter(empl -> empl.getValue().getExperience().equals(exp))
                .forEach(el -> {
                    result.put(el.getKey(), el.getValue());
                });
        return result;
    }

    public void addEmployee(Employee employee) {
        try {
            if (EDict.containsKey(employee.getId())) {
                throw new IllegalArgumentException("Some key already exist");
            }

            EDict.put(employee.getId(), EmployeeDTO.builder()
                    .number(employee.getNumber())
                    .fullName(employee.getFullName())
                    .experience(employee.getExperience())
                    .build());
            System.out.println(employee.getId() + ": " + employee.getFullName() + " added successfully");

        } catch (IllegalArgumentException e) {
            System.out.printf("%s: %d\n", e.getMessage(), employee.getId());
        }
    }

}

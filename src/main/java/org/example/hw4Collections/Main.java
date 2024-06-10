package org.example.hw4Collections;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository rep = getEmployeeRepository();


        //проверка метода поиска по стажу
        System.out.println();
        rep.findByExperience(2).forEach((key, value) -> System.out.println(key + ": " + value));
        //либо так еще можно проверить поиск:
//        Map<Integer,EmployeeDTO> find = rep.findByExperience(1);
//        for(Map.Entry<Integer, EmployeeDTO> empl: find.entrySet()){
//            System.out.println(empl);
//        }


        //проверка поиска по фио
        System.out.println();
        rep.findByFullName("empl")
                .forEach((key, value) -> System.out.println(
                        key + ": " + value.getFullName() +" -> " + value.getNumber()));

        //поиск по id
        System.out.println();
        Employee empl = rep.findById(10);
        System.out.println(empl);
    }

    private static EmployeeRepository getEmployeeRepository() {
        Employee empl1 = new Employee(1, "+1244234", "full name empl1", 4);
        Employee empl2 = new Employee(2, "+2342342", "full name empl2", 1);
        Employee empl3 = new Employee(3, "+7235324", "full name empl3", 2);
        Employee empl4 = new Employee(4, "+9107383", "full name empl4", 2);
        Employee empl5 = new Employee(5, "+3978325", "Анатолий Анатольевич", 5);
        Employee empl6 = new Employee(6, "+2039857", "full name empl6", 5);
        Employee empl7 = new Employee(6, "+2932579", "full name empl7", 3);

        EmployeeRepository rep = new EmployeeRepository();

        rep.addEmployee(empl1);
        rep.addEmployee(empl2);
        rep.addEmployee(empl3);
        rep.addEmployee(empl4);
        rep.addEmployee(empl5);
        rep.addEmployee(empl6);
//        проверка на существование только 1 такого id
        rep.addEmployee(empl7);
        return rep;
    }
}

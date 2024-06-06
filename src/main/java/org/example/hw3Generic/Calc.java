package org.example.hw3Generic;

/*
Написать класс Калькулятор (необобщенный),
который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
Методы должны возвращать результат своей работы.
 */

public class Calc {
    public static <T extends Number> Number sum(T a, T b) {
        return a.floatValue() + b.floatValue();
    }

    public static <T extends Number> Number multiply(T a, T b){
        return a.floatValue() * b.floatValue();
    }

    public static <T extends Number> Number divide(T a, T b){
        if(b.floatValue() == 0) throw new ArithmeticException("Divide by 0");
        return a.floatValue() / b.floatValue();
    }

    public static <T extends Number> Number subtract(T a, T b){
        return a.floatValue() - b.floatValue();
    }
}

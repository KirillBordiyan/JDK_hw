package org.example.hw3Generic;

/*Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class Pair<T, R> {
    T firstArg;
    R secondArg;

    public T getFirstArg() {
        return firstArg;
    }

    public R getSecondArg() {
        return secondArg;
    }

    @Override
    public String toString() {
        return  "(" + firstArg +
                ", " + secondArg +
                ")";
    }
}

package org.example.hw3Generic;

public class CompareArrays {
    /*Напишите обобщенный метод compareArrays(),
который принимает два массива и возвращает true, если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину
и содержать элементы одного типа по парно по индексам.
 */

    public <T> boolean compareArrays(T[] source, T[] destination) {
        if (source.length != destination.length) {
            return false;
        }
        for (int i = 0; i < source.length; i++) {
            if (
                    !source[i].getClass().equals(destination.getClass()) ||
                            !source[i].equals(destination[i])
            ) return false;
        }
        return true;
    }

}

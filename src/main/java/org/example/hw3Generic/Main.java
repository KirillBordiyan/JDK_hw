package org.example.hw3Generic;

public class Main {
    public static void main(String[] args) {

        //2
        CompareArrays ca = new CompareArrays();

        String[] arr = new String[3];
        arr[0] = "a";
        arr[1] = "b";
        arr[2] = "c";

        String[] arr3 = new String[3];
        arr3[0] = "a";
        arr3[1] = "b";
        arr3[2] = "c";


//        Integer[] arr2 = new Integer[4];
//        arr2[0] = 1;
//        arr2[1] = 2;
//        arr2[2] = 3;

        System.out.println("compare result " + ca.compareArrays(arr, arr3));


        //3
        Pair<Integer, String> pair = new Pair<>();
        pair.firstArg = 10;
        pair.secondArg = "some";
        System.out.println("pair.toString() = " + pair);
    }
}


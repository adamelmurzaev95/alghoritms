package com.company.recursion;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(isPower(92));
        //System.out.println(factorial(4));
        System.out.println(sum(922));
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            array.add((int) (Math.random() * 30000));
        }
        System.out.println(array);
        System.out.println(max(array));
    }

    private static String isPower(int i) {
        if (i == 2) return "Yes";
        if (i % 2 != 0) return "No";
        return isPower(i / 2);
    }

    public static int sum(int number){
        if (number <= 0) return 0;
        int i = number % 10;
        number /= 10;
        return i + sum(number);
    }

    private static int max(List<Integer> arrayList){
        if (arrayList.size() == 2) return arrayList.get(0) > arrayList.get(1) ? arrayList.get(0) : arrayList.get(1);
        int result = max(arrayList.subList(1, arrayList.size()));
        return arrayList.get(0) > result ? arrayList.get(0) : result;
    }

    public static void method(int i, int j) {
        if (i < j) {
            System.out.println(i);
            method(++i, j);
        }
        else if (i > j){
            System.out.println(j);
            method(i, ++j);
        }
        else {
            System.out.println(i);
        }
    }

    public static int factorial(int number){
        if (number == 1) return 1;
        return number * factorial(number - 1);
    }
}

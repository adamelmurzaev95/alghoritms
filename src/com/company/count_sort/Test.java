package com.company.count_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void countSort(int[] array){
        final int MAX_VALUE = 75;

        int[] count = new int[MAX_VALUE];

        for (int i = 0; i < array.length; i++){
            count[array[i]]++;
        }

        int arrayIndex = 0;
        for (int i = 0; i < MAX_VALUE; i++){
            for (int j = 0; j < count[i]; j++){
                array[arrayIndex] = i;
                arrayIndex++;
            }
        }
    }
}

package com.company.binarySearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main{
    static int count = 0;
    public static void main(String[] args) {
        int[] array = new int[1000];
        int j = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++, j = j + 3){
            array[i] = j;
            arrayList.add(j);
        }
        System.out.println(binarySearch(array, 906));
        System.out.println(recursionBinarySearch(array, 906, 0, array.length));
    }

    private static int binarySearch(int[] array, int item){
        int low = 0;
        int high = array.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int guess = array[mid];
            if (guess == item) return mid;
            if (guess < item) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private static int recursionBinarySearch(int[] array, int item, int low, int high){
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        int guess = array[mid];
        if (guess == item) return mid;
        if (guess < item) low = mid + 1;
        else high = mid - 1;
        return recursionBinarySearch(array, item, low, high);
    }
}

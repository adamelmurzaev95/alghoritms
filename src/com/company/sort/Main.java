package com.company.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(2);
        /*System.out.println(choiceSort(arrayList));*/
        System.out.println(length(arrayList));
        int[] array = new int[30000];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * 30000);
        }
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int sum(List<Integer> array){
        if (array.size() == 1) return array.get(0);
        return array.get(0) + sum(array.subList(1, array.size()));
    }

    private static int length(List<Integer> array){
        if (array.size() == 1) return 1;
        return 1 + length(array.subList(1, array.size()));
    }

    public static int[] bubbleSort(int[] array){
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++){
                if (array[i] > array[i + 1]){
                    isSorted = false;
                    int swap = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = swap;
                }
            }
        }
        return array;
    }

    public static int[] addToMiddle(int[] array, int number){
        int[] newArray = new int[array.length + 1];
        int mid = newArray.length / 2;
        newArray[mid] = number;
        for (int i = 0; i < newArray.length; i++){
            if (i < mid)
                newArray[i] = array[i];
            else if (i > mid) newArray[i] = array[i - 1];
        }
        return newArray;
    }

    public static ArrayList<Integer> choiceSort(ArrayList<Integer> array){
        ArrayList<Integer> newArray = new ArrayList<>();
        int size = array.size();
        for (int i = 0; i < size; i++){
            int smallest = findSmallest(array);
            newArray.add(array.remove(smallest));
        }
        return newArray;
    }

    public static int findSmallest(ArrayList<Integer> array){
        int smallest = array.get(0);
        int smallestIndex = 0;
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) < smallest){
                smallest = array.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}

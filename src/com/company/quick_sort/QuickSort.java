package com.company.quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[] { 2, 1, 6, 4, 7, 3 })));
    }

    public static void quickSort(int[] array, int from, int to){
        if (from < to) {
            int divideIndex = partition(array, from, to);

            quickSort(array, from, divideIndex - 1);

            quickSort(array, divideIndex, to);
        }
    }

    private static int partition(int[] array, int from, int to){
        int leftIndex = from;
        int rightIndex = to;
        int pivot = array[(from + to) / 2];
        while (leftIndex <= rightIndex){
            while (array[leftIndex] < pivot){
                leftIndex++;
            }

            while (array[rightIndex] > pivot){
                rightIndex--;
            }

            if (leftIndex <= rightIndex){
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int leftIndex, int rightIndex) {
        int swap = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = swap;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }

    private static void bubbleSort(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    sorted = false;
                }
            }
        }
    }

    private static int[] mergeSort(int[] array){
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];
        int size = 1;
        while (size < array.length){
            for (int i = 0; i < array.length; i += size * 2){
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;
            size *= 2;
        }
        return currentSrc;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);
        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++){
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])){
                dest[i] = src1[index1];
                index1++;
            }
            else{
                dest[i] = src2[index2];
                index2++;
            }
        }
    }


    private static void test1() {
        int testLen = 100000000;

        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];

        System.out.println("\n-----Случайный массив------");

        for (int i = 0; i < testLen; i++) {
            arr2[i] = arr1[i] = (int)Math.round(Math.random() * 10000);
        }

        System.out.println("Сортировка слиянием:");
        measureTime(() -> mergeSort(arr2));

        System.out.println("Быстрая сортировка:");
        measureTime(() -> quickSort(arr1, 0, testLen - 1));

    }

    private static void test2() {
        int testLen = 100000000;

        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];

        System.out.println("\n-----Отсортированный массив------");

        for (int i = 0; i < testLen; i++) {
            arr2[i] = arr1[i] = i;
        }

        System.out.println("Быстрая сортировка:");
        measureTime(() -> quickSort(arr1, 0, testLen - 1));

        System.out.println("Сортировка пузырьком:");
        measureTime(() -> mergeSort(arr2));

    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }
}
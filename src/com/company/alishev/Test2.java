package com.company.alishev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<>();
        /*list.add(9);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(8);
        System.out.println(theBiggestNumber(list));
        list.clear();*/
        /*int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++){
            arr[i] = (int)(Math.random() * 1000);
        }
        //System.out.println(greedyAlgorithm(list, 400));
        System.out.println("Start");*/
        int[] stations = new int[] {0, 200, 375, 550, 750, 950};
        System.out.println(myMinStops(stations, 400));
        System.out.println(naileMinStops(stations, 400));
    }

    public static String theBiggestNumber(int[] arr){
        return String.join("", Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));
    }

    public static int naileMinStops(int[] stations, int length){
        int currentStop = 0;
        int result = 0;
        while (currentStop < stations.length - 1){
            int nextStop = currentStop;
            while (nextStop < stations.length - 1 &&
                stations[nextStop + 1] - stations[currentStop] <= length)
                nextStop++;
            if (currentStop == nextStop) return -1;
            if (nextStop < stations.length - 1) result++;
            currentStop = nextStop;
        }
        return result;
    }

    //returns -1 if it's impossible
    public static int myMinStops(int[] stations, int length){
        int result = 0;
        int petrol = length;
        for (int i = 1; i < stations.length - 1; i++){
            petrol -= stations[i] - stations[i - 1];
            int currentStop = stations[i];
            int nextStop = stations[i + 1];
            if ((nextStop - currentStop) > (length)) return -1;
            if (petrol < nextStop - currentStop){
                result++;
                petrol = length;
            }
        }
        return result;
    }
}

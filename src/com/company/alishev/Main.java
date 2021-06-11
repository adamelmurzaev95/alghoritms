package com.company.alishev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int n = 100;
        long[] arr = new long[n + 1];
        Arrays.fill(arr, -1);
        System.out.println(fibNaive(n, arr));
        System.out.println(fibEffective(n));
    }

    private static long fibNaive(int n, long[] arr){
        if (arr[n] != -1) return arr[n];
        if (n <= 1) return n;
        long result = fibNaive(n - 1, arr) + fibNaive(n - 2, arr);
        arr[n] = result;
        return result;
    }

    private static long fib(){
        long[] arr = new long[100];
        long sum = 0;
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
            if (arr[i] > 4000000) break;
            if (arr[i] % 2 != 0) continue;
            sum += arr[i];
        }
        return sum;
    }

    private static int fac(int number){
        if (number == 1) return number;
        return number * fac(number - 1);
    }

    private static long fibEffective(int n){
        long[] array = new long[n + 1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    private static long simpleDenominator(long number){
        long denominator = 0;
        while (number != 1){
            for (long i = 2; i <= number; i++){
                if (number % i == 0 && isSimple(i)){
                    number = number / i;
                    denominator = i;
                    break;
                }
            }
        }
        return denominator;
    }

    private static boolean isSimple(long number){
        for (long i = 2; i < number; i++){
            if (number % i == 0) return false;
        }
        return true;
    }
}

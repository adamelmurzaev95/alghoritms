package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }

    public static String longestPalindrome(String s) {
        StringBuilder result = new StringBuilder(s.substring(0, 1));
        int max = result.length();
        int length = 2;
        while (length < s.length()){
            int start = 0;
            int end = 1;
            for (; end < s.length(); end++){
                if (end > length){
                    start++;
                    if (s.substring(start, end).equals(reverse(s))){
                        if (end - start + 1 > max){
                            max = end - start + 1;
                            result = new StringBuilder(s.substring(end - start + 1));
                        }
                    }
                }
            }
            length++;
        }
        return result.toString();
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static int countGoodSubstrings(String s){
        int i = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()){
            sb.append(s.charAt(i));
            if (i >= 2){
                if (isDistinct(sb)){
                    count++;
                }
                sb.deleteCharAt(0);
            }
            i++;
        }
        return count;
    }

    public static boolean isDistinct(StringBuilder sb){
        for (int i = 0; i < sb.length() - 1; i++){
            if (sb.indexOf(sb.substring(i, i + 1)) != sb.lastIndexOf(sb.substring(i, i + 1))){
                return false;
            }
        }
        return true;
    }
}

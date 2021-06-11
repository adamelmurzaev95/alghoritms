package com.company.java8;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println(calculateRepeats(List.of(1, 2, 3, 4, 2, 3, 4, 100)));
        System.out.println(longestCommonPrefix(new String[] {"c","acc","ccc"}));
    }

    public static String longestCommonPrefix(String[] strs) {
            String s = strs[0];
            for (int i = 0; i < strs.length; i++) {
                while (!strs[i].startsWith(s)) {
                    s = s.substring(0, s.length() - 1);
                }
                Pattern pattern = Pattern.compile("da");
                Matcher matcher = pattern.matcher("");
            }
            return s;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int iterationCount = nums1.length + nums2.length;
        int index1 = 0;
        int index2 = 0;
        int[] nums3 = new int[iterationCount];
        for (int i = 0; i < iterationCount; i++){
            if (index1 < nums1.length &&
                    (index2 >= nums2.length || nums1[index1] < nums2[index2]))
                nums3[i] = nums1[index1++];
            else nums3[i] = nums2[index2++];
        }
        return (double) nums3[iterationCount / 2];
    }

    public static Map<Integer, Integer> calculateRepeats(List<Integer> input){
        Map<Integer, Integer> map = input.stream()
                .collect(Collectors.toMap(i -> i, j -> Collections.frequency(input, j), (i, j) -> {
                    return i;
                }));
        return map;
    }
}

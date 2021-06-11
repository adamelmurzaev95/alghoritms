package com.company.leetcode;

import java.util.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(lengthOfLongestSubstringTwo("pwwker"));
        System.out.println(max(List.of(10, 12, 5)));
        System.out.println(findMaxSumSubarray(new int[] {4, 2, 6, 2, 10}, 3));
    }

    public static int[] leetcode(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) return new int[]{map.get(result), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int reverse(int x) {
        boolean isZeroInStart = true;
        int number = 0;
        while (x != 0) {
            int rest = x % 10;
            if (rest != 0) isZeroInStart = false;
            if (!isZeroInStart) {
                if (Math.abs(number) > Integer.MAX_VALUE / 10) {
                    number = 0;
                } else number = (number * 10) + rest;
            }
            x /= 10;
        }
        return number;
    }

    public static int max(List<Integer> array){
        if (array.size() == 2) return Math.max(array.get(0), array.get(1));
        return Math.max(array.get(0), max(array.subList(1, array.size())));
    }

        public static int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int fast = 0;
            int slow = 0;
            int count = 0;
            while (fast < s.length()) {
                if (!map.containsKey(s.charAt(fast))) {
                    map.put(s.charAt(fast), fast++);
                    count = Math.max(count, map.size());
                } else {
                    slow = map.get(s.charAt(fast));
                    while (slow > -1){
                        map.remove(s.charAt(slow));
                        slow--;
                    }
                }
            }
            return count;
        }

        private static int sum(List<Integer> array){
            if (array.size() == 1) return array.get(0);
            return array.get(0) + sum(array.subList(1, array.size()));
        }

    public static int lengthOfLongestSubstringTwo(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < s.length()){
            if (map.containsKey(s.charAt(i))){
                if (i - j >= count) count = i - j;
                if (map.get(s.charAt(i)) >= j) {
                    j = map.get(s.charAt(i)) + 1;
                }
            }
            map.put(s.charAt(i), i++);
        }
        return Math.max(count, i - j);
    }


    public static int naiveLengthOfLongestSubstring(String s){
        int count = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < s.length()){
            char ch = s.charAt(i);
            if (set.contains(ch)){
                count = Math.max(count, set.size());
                set.remove(s.charAt(j++));
            }
            else set.add(s.charAt(i++));
        }
        return Math.max(count, set.size());
    }

    private static int findMaxSumSubarray(int[] array){
        int maxValue = array[0];
        int sum = array[0];
        for (int i = 0; i < array.length; i++) {
            sum = sum < 0 ? array[i] : sum + array[i];
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }

    private static int findMaxSumSubarray(int[] array, int length){
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
            if (i >= length - 1){
                maxValue = Math.max(sum, maxValue);
                sum -= array[i - (length -1)];
            }
        }
        return maxValue;
    }

    private static int findSmallestSubarray(int[] array, int targetSum){
        int minSize = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;
        for (int i = 0; i < array.length;){
            while (sum < targetSum && i < array.length){
                sum += array[i++];
            }
            while (sum >= targetSum){
                sum -= array[j++];
                minSize = Math.min(i - (j - 1), minSize);
            }
        }
        return minSize;
    }

    public static String time(int seconds){
        int minutes = 0;
        int hours = 0;
        if (seconds >= 60){
            minutes = seconds / 60;
            seconds -= (minutes * 60);
        }
        if (minutes >= 60){
            hours = minutes / 60;
            minutes -= (hours * 60);
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
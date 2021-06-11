package com.company.leetcode;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12));
        System.out.println(integerToRoman(3));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int number = x;
        int result = 0;
        while (number > 0){
            result = (result * 10) + number % 10;
            number /= 10;
        }
        return result == x;
    }

    public static String integerToRoman(int num){
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        StringBuilder sb = new StringBuilder();
        while (num > 0){
            if (map.containsKey(num))
                return sb.append(map.get(num)).toString();
            Map.Entry<Integer, String> entry = map.lowerEntry(num);
            num -= entry.getKey();
            sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int start, int end) {
        if (end - start <= 0) return null;
        int[] max = max(nums, start, end);
        TreeNode root = new TreeNode(max[0]);
        root.left = construct(nums, start, max[1]);
        root.right = construct(nums, max[1] + 1, end);
        return root;
    }

    public int[] max(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = start;
        for (; start < end; start++) {
            if (max < nums[start]) {
                max = nums[start];
                maxIndex = start;
            }
        }
        return new int[]{max, maxIndex};
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

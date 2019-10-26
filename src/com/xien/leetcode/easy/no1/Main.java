package com.xien.leetcode.easy.no1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        return solution2(nums, target);
    }

    private int[] solution1(int[] nums, int target) {
        int[][] newArray = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            newArray[i][0] = nums[i];
            newArray[i][1] = i;
        }

        Arrays.sort(newArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return Integer.compare(ints[0], t1[0]);
            }
        });

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = newArray[left][0] + newArray[right][0];
            if (sum == target) {
                return new int[]{newArray[left][1], newArray[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    private int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> numAndIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = numAndIndex.get(nums[i]);
            if (index != null) {
                return new int[] {index, i};
            }
            numAndIndex.put(target- nums[i], i);
        }
        return null;
    }
}

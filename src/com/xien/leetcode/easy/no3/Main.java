package com.xien.leetcode.easy.no3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;

        Map<Character, Integer> existsCharIndices = new HashMap<>();
        int i = 0;
        while (i < chars.length) {
            i = lengthOfLongestSubstring(existsCharIndices, chars, i);

            maxLength = Math.max(maxLength, existsCharIndices.size());
            existsCharIndices.clear();
        }
        return maxLength;
    }

    private int lengthOfLongestSubstring(Map<Character, Integer> existsCharIndices, char[] chars, int start) {
        int j = start;
        for (; j < chars.length; j++) {
            Integer duplicatedCharIndex = existsCharIndices.putIfAbsent(chars[j], j);
            if (duplicatedCharIndex != null) {
                return duplicatedCharIndex + 1;
            }
        }
        return chars.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("aab"));
    }
}
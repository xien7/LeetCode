package com.xien.leetcode.easy.no2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tail = null;

        boolean hasCarry = false;
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null || n2 != null) {
            int sum = 0;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            if (hasCarry) {
                sum++;
            }

            if (sum >= 10) {
                sum %= 10;
                hasCarry = true;
            }
            else {
                hasCarry = false;
            }

            tail = appendNode(tail, sum);
            if (result == null) {
                result = tail;
            }
        }

        if (hasCarry) {
            tail = appendNode(tail, 1);
            if (result == null) {
                result = tail;
            }
        }

        return result;
    }

    private ListNode appendNode(ListNode list, int val) {
        ListNode n = new ListNode(val);
        if (list != null) {
            list.next = n;
        }
        return n;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
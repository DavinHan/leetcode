package com.leetcode.middle;

import com.leetcode.common.ListNode;

/**
 * find the sum of two list.
 */
public class SumOfTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode node = root;
        int carry = 0;
        boolean l1HasNext = true;
        boolean l2HasNext = true;
        while(l1HasNext || l2HasNext) {
            int tmp = l1.val + l2.val + carry;
            if(tmp >= 10) {
                node.val = tmp % 10;
                carry = 1;
            } else {
                node.val = tmp;
                carry = 0;
            }
            if(l1.next != null) {
                l1 = l1.next;
                l1HasNext = true;
            } else {
                l1.next = new ListNode(0);
                l1 = l1.next;
                l1HasNext = false;
            }
            if(l2.next != null) {
                l2 = l2.next;
                l2HasNext = true;
            } else {
                l2.next = new ListNode(0);
                l2 = l2.next;
                l2HasNext = false;
            }
            if(l1HasNext || l2HasNext) {
                node.next = new ListNode();
                node = node.next;
            } else {
                if(carry == 1) {
                    node.next = new ListNode(1);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SumOfTwo t = new SumOfTwo();
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode node = t.addTwoNumbers(l1, l2);
        System.out.println(node.toString());
    }
}

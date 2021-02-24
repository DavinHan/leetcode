package com.leetcode.easy;

import com.leetcode.common.ListNode;

/**
 * merge two ordered linked list into one
 */
public class MergesTwoOrderedLinkedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode p = root;
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                p.next = new ListNode(l2.val);
                p = p.next;
                l2 = l2.next;
            } else {
                p.next = new ListNode(l1.val);
                p = p.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            p.next = new ListNode(l1.val);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = new ListNode(l2.val);
            p = p.next;
            l2 = l2.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(l1, l2));
    }
}

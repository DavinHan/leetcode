package com.leetcode.middle;

import com.leetcode.common.ListNode;

/**
 * exchange the elements in the linked lists in pairs.
 */
public class ExchangeTheElementsInListInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode tt = root, t = root, p = head;
        while (t != null && p != null) {
            t = t.next;
            p = p.next;
            if(t != null && p != null) {
                t.next = p.next;
                tt.next = p;
                p.next = t;
            } else {
                break;
            }
            tt = t;
            p = t.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        System.out.println(swapPairs(l1));
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        System.out.println(swapPairs(l2));
        ListNode l3 = new ListNode(1);
        System.out.println(swapPairs(l3));
        System.out.println(swapPairs(null));
    }
}

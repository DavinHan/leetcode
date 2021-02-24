package com.leetcode.middle;

import com.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * remove the Nth node from the end of the list
 */
public class RemoveNthFromListEnd {

    public static ListNode removeNthFromEndByNewList(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        int len = 0;
        if(head == null || n == 0) {
            return head;
        } else if (head.next == null) {
            head = null;
        } else {
            ListNode p = head;
            while (p != null) {
                len++;
                list.add(p);
                p = p.next;
            }
            if(len - n == 0) {
                head = list.get(1);
            } else if (n == 1) {
                p = list.get(len - 2);
                p.next = null;
            } else {
                p = list.get(len - n - 1);
                p.next = list.get(len - n + 1);
            }
        }
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0, head);
        ListNode p = root, q = root;
        int count = 0;
        if(head == null || n == 0) {
            return head;
        }
        while (p.next != null) {
            p = p.next;
            if(count < n) {
                count++;
            } else {
                q = q.next;
            }
        }
        q.next = q.next.next;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode r2 = new ListNode(1);
        r2.next = new ListNode(2);
        System.out.println(removeNthFromEnd(r2, 2));
        ListNode r4 = new ListNode(1);
        r4.next = new ListNode(2);
        System.out.println(removeNthFromEnd(r4, 1));
        ListNode r3 = new ListNode(1);
        System.out.println(removeNthFromEnd(r3, 1));
        ListNode r1 = new ListNode(1);
        r1.next = new ListNode(2);
        r1.next.next = new ListNode(3);
        r1.next.next.next = new ListNode(4);
        r1.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(r1, 5));
    }
}

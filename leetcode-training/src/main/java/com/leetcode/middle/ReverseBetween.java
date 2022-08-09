package com.leetcode.middle;

import com.leetcode.common.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
 * 表节点，返回 反转后的链表 。 [left, right]
 *
 * @author yanhanf
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int sub = right - left;
        if(sub <= 0) {
            return head;
        }
        ListNode r = new ListNode();
        r.next = head;
        ListNode sr = new ListNode();
        ListNode start = null, end = null;
        ListNode p = r;
        for(int i = 0;p != null;i++, p = p.next) {
            if(i == left - 1) {
                start = p;
            }
            if(i == left) {
                sr.next = new ListNode(p.val);
            } else if(i > left && i <= right) {
                ListNode tmp = new ListNode(p.val);
                tmp.next = sr.next;
                sr.next = tmp;
                if(i == right) {
                    end = p;
                }
            }
        }
        if(start != null) {
            start.next = sr.next;
            for(p = r;p.next != null;p = p.next) {}
            p.next = end.next;

        }
        return r.next;
    }

    public static void main(String[] args) {
        ReverseBetween r = new ReverseBetween();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        System.out.println("target is [1,4,3,2,5], and test is " + r.reverseBetween(root, 2, 4));

        root = new ListNode(5);
        System.out.println("target is [5], and test is " + r.reverseBetween(root, 1, 1));

        root = new ListNode(3);
        root.next = new ListNode(5);
        System.out.println("target is [5,3], and test is " + r.reverseBetween(root, 1, 2));
    }
}

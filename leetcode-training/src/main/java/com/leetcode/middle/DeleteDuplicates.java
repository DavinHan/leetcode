package com.leetcode.middle;

import com.leetcode.common.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表
 *
 *
 * @author yanhanf
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode r = new ListNode(Integer.MIN_VALUE);
        r.next = head;
        ListNode p = r.next;
        ListNode pp = r;
        int duplicateVal = r.val;
        while(p.next != null) {
            if(p.next.val == pp.next.val) {
                duplicateVal = p.next.val;
                p.next = p.next.next;
            } else {
                if(duplicateVal == pp.next.val) {
                    pp.next = p.next;
                } else {
                    pp = pp.next;
                }
                p = p.next;
            }
        }
        if(duplicateVal == pp.next.val) {
            pp.next = p.next;
        }
        return r.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates d = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        System.out.println(d.deleteDuplicates(head));

        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        System.out.println(d.deleteDuplicates(head));

        head = new ListNode(1);
        head.next = new ListNode(1);
        System.out.println(d.deleteDuplicates(head));
    }
}

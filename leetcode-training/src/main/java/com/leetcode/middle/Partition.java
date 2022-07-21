package com.leetcode.middle;

import com.leetcode.common.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * @author yanhanf
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode root = new ListNode();
        root.next = head;
        ListNode lpx = root;
        // 查找x
        while(lpx.next != null) {
            if(lpx.next.val == x) {
                break;
            }
            lpx = lpx.next;
        }
        ListNode root2 = new ListNode();
        root2.next = lpx.next;
        ListNode p = root;
        ListNode l = root;
        ListNode ll = root2;
        while(p.next != null) {
            if(p.next.val < x) {
                l.next = p.next;
                l = l.next;
            } else {
                ll.next = p.next;
                ll = ll.next;
            }
            p = p.next;
        }
        l = root;
        while (l.next != null) {
            if(l.next.val >= x) {
                l.next = l.next.next;
            } else {
                l = l.next;
            }
        }
        ll = root2;
        while(ll.next != null) {
            if(ll.next.val < x) {
                ll.next = ll.next.next;
            } else {
                ll = ll.next;
            }
        }
        l = root;
        while(l.next != null) {
            l = l.next;
        }
        l.next = root2.next;
        return root.next;
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println("target is [1,0,4,3,5,2], and test is "
                + p.partition(new ListNode(new int[]{1,4,3,0,5,2}), 2));
        System.out.println("target is [1,2,2,4,3,5], and test is "
                + p.partition(new ListNode(new int[]{1,4,3,2,5,2}), 3));
        System.out.println("target is [1,2], and test is "
                + p.partition(new ListNode(new int[]{2,1}), 2));

    }
}

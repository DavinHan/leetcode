package com.leetcode.middle;

import com.leetcode.common.ListNode;

/**
 * @author yanhanf
 * @ClassName RotateListRight
 * @Description 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 * @Date 2021/10/12
 */
public class RotateListRight {

    public static ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        if (k > len) {
            k = k % len;
        }
        if(k == len || k == 0) {
            return head;
        }
        cur = head;
        ListNode curr = cur;
        for(int i = 0;i < len - k;i++) {
            curr = cur;
            cur = cur.next;
        }
        curr.next = null;
        ListNode t = cur;
        while(t.next != null) {
            t = t.next;
        }
        t.next = head;
        return cur;
    }

    public static void main(String[] args) {
        //1,2,3,4,5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println("target is [4,5,1,2,3], result is " + rotateRight(head1, 10));
        // 0,1,2
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        System.out.println("target is [2,0,1], result is " + rotateRight(head2, 4));
    }
}

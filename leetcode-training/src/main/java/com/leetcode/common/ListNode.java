package com.leetcode.common;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode(int[] arr) {
        ListNode root = this;
        if(arr.length > 0) {
          ListNode p = root;
          for(int i = 0;i < arr.length;i++) {
              p.val = arr[i];
              if(i < arr.length - 1) {
                  p.next = new ListNode();
                  p = p.next;
              }
          }
        }
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : ", " + this.next.toString());
    }
}

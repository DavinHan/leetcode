package com.test;

public class DeleteNode {
	
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int v){
			val = v;
		}
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(4);
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		deleteNode(head, node1);
		deleteNode(head, node2);
		deleteNode(head, node3);
	}
	
    public static void deleteNode(ListNode head, ListNode node) {
    	if(head.val == node.val) {
    		head = head.next;
    	}else {
    		ListNode tmp = head.next;
        	ListNode tail = head;
        	while(tmp != null) {
        		if(tmp.val == node.val) {
        			tail.next = tmp.next;
        			break;
        		}else {
        			tail = tmp;
        			tmp = tmp.next;
        		}
        	}
    	}
    	System.out.println(head);
    }

}

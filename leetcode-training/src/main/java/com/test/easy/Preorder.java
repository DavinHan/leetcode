package com.test.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
	
	static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	public static void main(String[] args) {
		List<Node> c1 = new ArrayList<>();
		List<Node> c2 = new ArrayList<>();
		c2.add(new Node(5,null));
		c2.add(new Node(6,null));
		c1.add(new Node(3,c2));
		c1.add(new Node(2,null));
		c1.add(new Node(4,null));
		Node root = new Node(1,c1);
		List<Integer> res = preorder(root);
		String tmp = "";
		for(Integer i : res) {
			tmp = tmp + i + ",";
		}
		System.out.println(tmp);
	}
	
	/**
	 * @description 递归实现
	 */
    public static List<Integer> preorder(Node root) {
    	List<Integer> res = new ArrayList<>();
    	if(root == null) {
    		return res;
    	}
    	res.add(root.val);
    	if(root.children != null) {
        	for(Node child : root.children) {
        		res.addAll(preorder(child));
        	}
    	}
    	return res;
    }
    
    /**
     * @description 非递归实现
     */
    public static List<Integer> preorder1(Node root){
    	List<Integer> res = new ArrayList<>();
    	Stack<Node> s = new Stack<>();
		Stack<Node> ns = new Stack<>();
    	if(root != null) {
    		s.push(root);
    	}
    	while(!s.isEmpty()) {
    		Node n = s.pop();
    		res.add(n.val);
    		if(n.children != null) {
	    		for(Node child : n.children) {
	    			ns.push(child);
	    		}
    		}
    		while(!ns.isEmpty()) {
    			s.push(ns.pop());
    		}
    	}
    	return res;
    }
}

package com.test.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.test.easy.Preorder.Node;

public class Postorder {
	
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
		List<Integer> res = postorder1(root);
		String tmp = "";
		for(Integer i : res) {
			tmp = tmp + i + ",";
		}
		System.out.println(tmp);
	}
	
	/**
	 * @description 递归实现
	 */
	public static List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}else {
			if(root.children != null) {
				for(Node child : root.children) {
					res.addAll(postorder(child));
				}
			}
			res.add(root.val);
		}
		return res;
	}
	
	/**
	 * @description 非递归实现
	 */
	public static List<Integer> postorder1(Node root) {
		List<Integer> res = new ArrayList<>();
		if(root != null) {
			Stack<Node> s = new Stack<>();
			Stack<Node> ns = new Stack<>();
			s.push(root);
			while(!s.isEmpty()) {
				Node tmp = s.pop();
				if(tmp.children != null){
					for(Node child : tmp.children) {
						ns.push(child);
					}
					s.push(new Node(tmp.val, null));
					while(!ns.isEmpty()) {
						s.push(ns.pop());
					}
				}else {
					res.add(tmp.val);
				}
			}
		}
		return res;
	}
}

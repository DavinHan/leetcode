package com.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class UniqueMorseRepresentations {
	public static void main(String[] args) {
		String[] words = new String[] {"gin", "zen", "gig", "msg"};
		//System.out.println((char)97);
		System.out.println(uniqueMorseRepresentations(words));
	}
	
	public static int uniqueMorseRepresentations(String[] words) {
		String[] w = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....",
				"..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
				"-","..-","...-",".--","-..-","-.--","--.."};
		StringBuilder s = new StringBuilder();
		Queue<String> q = new PriorityQueue<>();
		for(int i = 0;i < words.length;i++) {
			for(int j = 0;j < words[i].length();j++) {
				s.append(w[(int)(words[i].charAt(j)) - 97]);
			}
			if(!q.contains(s.toString())) {
				q.add(s.toString());
			}
			s.delete(0, s.length());
		}
		return q.size();
	}
}

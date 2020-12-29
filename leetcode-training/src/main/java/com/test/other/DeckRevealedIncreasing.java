package com.test.other;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DeckRevealedIncreasing {
	
	public static void main(String[] args) {
		int[] a = new int[] {17,13,11,2,3,5,7};
		for(int i : deckRevealedIncreasing(a)) {
			System.out.println(i);
		}
	}
	
	public static int[] deckRevealedIncreasing(int[] deck) {
		Deque<Integer> q = new LinkedList<>();
		Arrays.sort(deck);
		for(int i = deck.length - 1;i >= 0;i--) {
			for(int j = 0;j < q.size() - 1;j++) {
				int temp = q.pollFirst();
				q.offerLast(temp);
			}
			q.offerFirst(deck[i]);
		}
		int[] res = new int[deck.length];
		int l = 0;
		while(!q.isEmpty()) {
			res[l++] = q.pollFirst();
		}
		return res;
	}
}

package com.leetcode.middle;

import java.util.*;

/**
 * 组合题的回溯法实现
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * @author yanhanf
 */
public class CombineBacktracking {

    /**
     * 根据n去构造树
     * @param n 构造图的大小
     * @param k 回溯查询路径的大小
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < 1) {
            return result;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(n, k, 1, result, deque);
        return result;
    }

    private void dfs(int n, int k, int start, List<List<Integer>> result, Deque<Integer> deque) {
        if(deque.size() == k) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start;i <= n;i++) {
            deque.addLast(i);
            dfs(n, k, i + 1, result, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        CombineBacktracking c = new CombineBacktracking();
        System.out.println("target is [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]] , result is " + c.combine(4, 2));
        System.out.println("target is [[1]] , result is " + c.combine(1, 1));
        System.out.println("target is [[1],[2]] , result is " + c.combine(2, 1));
        System.out.println("target is [[1],[2]] , result is " + c.combine(20, 16));
    }
}

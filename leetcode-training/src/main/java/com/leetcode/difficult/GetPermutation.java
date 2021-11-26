package com.leetcode.difficult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanhanf
 * @ClassName GetPermutation
 * @Description 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *  按大小顺序列出所有排列情况，并一一标记，给定 n 和 k，返回第 k 个排列。
 * @Date 2021/10/26
 */
public class GetPermutation {

    /**
     * 共有 n 棵树，每棵树的每层节点个数依次为 n-1, n-2, n-3, ..., 1，每棵树的枝数为 (n-1)!，总枝数为n!
     */
    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("target is 213, test is " + getPermutation(3, 3));
        System.out.println("target is 2314, test is " + getPermutation(4, 9));
        System.out.println("target is 123, test is " + getPermutation(3, 1));
    }
}

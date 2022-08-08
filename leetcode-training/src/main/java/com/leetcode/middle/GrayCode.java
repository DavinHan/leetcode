package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
 *
 * 每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 *
 * @author yanhanf
 */
public class GrayCode {

    /**
     * 直接遍历查询当前节点
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        for(int i = 1;i <= n;i++) {
            for(int j = ret.size() - 1;j >= 0;j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }

        return ret;
    }

    /**
     * 遍历
     */
    public List<Integer> grayCode2(int n) {
        if(n < 1) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        n = 1 << n;
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            tmp.add(i);
        }
        result.add(0);
        grayCode(result,0, tmp, n);
        return result;
    }

    private void grayCode(List<Integer> result, int start, List<Integer> tmp, int max) {
        if(max < 1 || result.size() == tmp.size()) {
            return;
        }
        for (int i = 0; i < tmp.size(); i++) {
            if(!result.contains(i) && isNear(start, i)) {
                result.add(i);
                grayCode(result, i, tmp, max);
                if(result.size() == tmp.size() && isNear(result.get(0), result.get(result.size() - 1))) {
                    break;
                } else {
                    result.remove(result.size() - 1);
                }
            }
        }
    }

    private boolean isNear(int a, int b) {
        int num = a ^ b;
        while(num % 2 == 0 && num != 0) {
            num = num >> 1;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        GrayCode c = new GrayCode();
        // 0,1
        System.out.println("target is [0,1], and test is" + c.grayCode(1));
        // 00,01,11,10
        System.out.println("target is [0,1,3,2], and test is" + c.grayCode(2));
        // 000,001,011,010,110,111,101,100
        // 0, 1, 3, 2, 5, 7, 6, 4
        // 000,001,011,010,101,111,110,100
        System.out.println("target is [0,1,3,2,6,7,5,4], and test is" + c.grayCode(3));
        System.out.println("target is [], and test is" + c.grayCode(10));
    }
}

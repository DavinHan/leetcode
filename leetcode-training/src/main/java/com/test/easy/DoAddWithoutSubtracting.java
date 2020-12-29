package com.test.easy;

/**
 *
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class DoAddWithoutSubtracting {

    public int add(int a, int b) {
        while (b != 0) {
            int tempSum = a ^ b;
            int carrySum = (a & b) << 1;
            a = tempSum;
            b = carrySum;
        }
        return a;
    }

    public static void main(String[] args) {
        DoAddWithoutSubtracting d = new DoAddWithoutSubtracting();
        System.out.println(d.add(3, 4));
    }
}

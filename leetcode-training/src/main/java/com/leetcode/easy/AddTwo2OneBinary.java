package com.leetcode.easy;

import java.util.Arrays;

public class AddTwo2OneBinary {

    public static String addBinary1(String a, String b) {
        StringBuilder result = new StringBuilder();
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int i = aa.length - 1, j = bb.length - 1;
        boolean add = false;
        while(i >= 0 && j >= 0) {
            if(aa[i] == '0' && bb[j] == '0') {
                if(add) {
                    result.append("1");
                    add = false;
                } else {
                    result.append("0");
                }
            } else if (aa[i] == '0' || bb[j] == '0') {
                if(add) {
                    result.append("0");
                    add = true;
                } else {
                    result.append("1");
                    add = false;
                }
            }else {
                if(add) {
                    result.append("1");
                } else {
                    result.append("0");
                }
                add = true;
            }
            i--;
            j--;
        }
        while(i >= 0) {
            if(add) {
                if(aa[i] == '1') {
                    result.append("0");
                } else {
                    result.append("1");
                    add = false;
                }
            } else {
                result.append(aa[i]);
            }
            i--;
        }
        while (j >= 0) {
            if(add) {
                if(bb[j] == '1') {
                    result.append("0");
                } else {
                    result.append("1");
                    add = false;
                }
            } else {
                result.append(bb[j]);
            }
            j--;
        }
        if(add) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        char[] resArr = new char[Math.max(a.length(), b.length()) + 1];
        Arrays.fill(resArr, '0');
        char[] maxArr = (a.length() > b.length() ? a : b).toCharArray();
        char[] minArr = (a.length() <= b.length() ? a : b).toCharArray();
        for (int i = 0;i < minArr.length;i++) {
            resArr[resArr.length - i - 1] = minArr[minArr.length - i - 1];
        }
        int carry = 0;
        for (int i = 0;i < maxArr.length;i++) {
            int x = resArr[resArr.length - i - 1] == '0' ? 0 : 1;
            int y = maxArr[maxArr.length - i - 1] == '0' ? 0 : 1;
            resArr[resArr.length - i - 1] = (char) ( x ^ y ^ carry + 48);
            // 若 resArr[i] = 0，则表示x和y同为1或同为0
            carry = (x + y + carry) >> 1;
        }
        resArr[0] = carry == 1 ? '1' : ' ';
        return new String(resArr).trim();
    }

    public static void main(String[] args) {
        System.out.println(addBinary1("11", "1"));
        System.out.println(addBinary1("1010", "1011"));
        System.out.println(addBinary2("11", "1"));
        System.out.println(addBinary2("1010", "1011"));

    }
}

package com.leetcode.easy;

public class AddTwo2OneBinary {

    public static String addBinary(String a, String b) {
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

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}

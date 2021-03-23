package com.leetcode.middle;

public class StringMultiply {

    public static String multiplyDirectly(String num1, String num2) {
        String result = "0";
        if("".equals(num1) || "".equals(num2) || "0".equals(num1) || "0".equals(num2)) {
            return result;
        }
        int multiple = 0, lastMultiple = 0;
        int len1 = num1.length(), len2 = num2.length();
        for(int i = len1 - 1;i >= 0;i--) {
            int a = Integer.parseInt(String.valueOf(num1.charAt(i)));
            StringBuilder sb = new StringBuilder();
            lastMultiple = 0;
            for(int j = 0;j < len1 - i - 1;j++) {
                sb.append(0);
            }
            for(int j = len2 - 1;j >= 0 || lastMultiple != 0;j--) {
                int n2 = j < 0 ? 0 : Integer.parseInt(String.valueOf(num2.charAt(j)));
                int tmp = a * n2 + lastMultiple;
                multiple = tmp / 10;
                tmp = tmp % 10;
                sb.append(tmp);
                lastMultiple = multiple;
            }
            result = addBy(result, sb.reverse().toString()).reverse().toString();
        }
        return result;
    }

    public static StringBuilder addBy(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int i = aLen - 1, j = bLen - 1;
        int add = 0, lastAdd = 0;
        while(i >= 0 || j >= 0 || add != 0) {
            int n1 = i < 0 ? 0 : Integer.parseInt(String.valueOf(a.charAt(i)));
            int n2 = j < 0 ? 0 : Integer.parseInt(String.valueOf(b.charAt(j)));
            int tmp = n1 + n2 + lastAdd;
            add = tmp / 10;
            tmp = tmp % 10;
            result.append(tmp);
            i -= 1;
            j -= 1;
            lastAdd = add;
        }
        return result;
    }

    public static String multiplyByAdd(String num1, String num2) {
        if("".equals(num1) || "".equals(num2) || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int[] nums = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1;i >= 0;i--) {
            int n1 = num1.charAt(i) - '0';
            for(int j = num2.length() - 1;j >= 0;j--) {
                int n2 = num2.charAt(j) - '0';
                int tmp = nums[i + j + 1] + n1 * n2;
                nums[i + j + 1] = tmp / 10;
                nums[i + j] += tmp % 10;
            }
        }

        for(int i = 0;i < nums.length;i++) {
            if(i == 0 && nums[i] == 0) {
                continue;
            } else {
                result.append(nums[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("target is 56088, and test is " + multiplyDirectly("123", "456"));
        System.out.println("target is 891, and test is " + multiplyDirectly("9", "99"));
        System.out.println("target is 6, and test is " + multiplyDirectly("3", "2"));
        System.out.println("target is 56088, and test is " + multiplyByAdd("123", "456"));
        System.out.println("target is 891, and test is " + multiplyByAdd("9", "99"));
        System.out.println("target is 6, and test is " + multiplyByAdd("3", "2"));
    }
}

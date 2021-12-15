package com.leetcode.difficult;

/**
 * Judge String whether is a number.
 * @Description Judge String whether is a number.
 * @author yanhanf
 * @ClassName IsANumber
 * @Date 2021/11/26
 */
public class IsANumber {

    /**
     * E/e后面需要跟着一个数字
     * +/-后面需要跟着一个数字
     * . 前面或后面需要有一个数字
     */
    public static boolean isNumber(String s) {
        if(s == null || s.length() == 0) {
            // 判空
            return false;
        }
        char[] inChars = s.toCharArray();
        boolean hasPointer = false;
        for (int i = 0; i < inChars.length; i++) {
            if(!isNumber(inChars[i])) {
                switch (inChars[i]) {
                    case 'E':
                    case 'e':
                        if(i - 1 >= 0 && i + 2 <= inChars.length) {
                            if(isNumber(inChars[i - 1])) {
                                if(!isNumber(inChars[i + 1])) {
                                    if(isPN(inChars[i + 1]) && i + 3 <= inChars.length && isNumber(inChars[i + 2])) {
                                        continue;
                                    } else {
                                        return false;
                                    }
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                        break;
                    case '+':
                    case '-':
                        if(i == 0) {
                            if (i + 1 >= inChars.length) {
                                return false;
                            } else {
                                if (!isNumber(inChars[i + 1])) {
                                    if('.' == inChars[i + 1] && i + 3 <= inChars.length && isNumber(inChars[i + 2])) {
                                        continue;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                        } else {
                            return false;
                        }
                        break;
                    case '.':
                        if(!hasPointer) {
                            hasPointer = true;
                        } else {
                            return false;
                        }
                        boolean isNum = false;
                        if(i - 1 >= 0) {
                            isNum = isNumber(inChars[i - 1]);
                        }
                        if(i + 2 <= inChars.length && !isNum) {
                            if(!(isNum = isNumber(inChars[i + 1]))) {
                                if((inChars[i + 1] == 'E' || inChars[i + 1] == 'e') && i + 3 <= inChars.length && isNumber(inChars[i + 2])) {
                                    continue;
                                } else {
                                    return false;
                                }
                            }
                        }
                        if(!isNum) {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }

    private static boolean isPN(char c) {
        return c == '+' || c == '-';
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        System.out.println("target is true, and test is " + isNumber("0"));
        System.out.println("target is false, and test is " + isNumber("e"));
        System.out.println("target is false, and test is " + isNumber("."));
        System.out.println("target is true, and test is " + isNumber(".1"));
        System.out.println("target is false, and test is " + isNumber("e9"));
        System.out.println("target is true, and test is " + isNumber("1e9"));
        System.out.println("target is true, and test is " + isNumber("1e+9"));
        System.out.println("target is true, and test is " + isNumber("46.e3"));
    }
}

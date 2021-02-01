package com.test.middle;

/**
 * Translate a string in zigzag and get a new one.
 */
public class TranslateStringInZigzag {

    public static String convertStringInZipzag(String s, int numRows) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int distance = numRows * 2 - 2;
        int distance1 = 0;
        int distance2 = distance - distance1;
        boolean isDis = true;
        for(int i = 0;i < numRows;i++) {
            if(i < numRows - 1) {
                distance1 = numRows * 2 - 2 * (i + 1);
                distance2 = distance - distance1;
                if(i == 0) {
                    distance2 = distance1;
                }
            } else {
                distance1 = numRows * 2 - 2;
                distance2 = distance1;
            }
            if(distance == 0) {
                distance1 = 1;
                distance2 = 1;
            }
            isDis = true;
            for (int j = i; j < len; ) {
                sb.append(s.charAt(j));
                if(isDis) {
                    j += distance1;
                    isDis = false;
                } else {
                    j += distance2;
                    isDis = true;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR".equals(convertStringInZipzag("PAYPALISHIRING", 3)));
        // PINALSIGYAHRPI
        // PINALSIGYAHRPI
        System.out.println("PINALSIGYAHRPI".equals(convertStringInZipzag("PAYPALISHIRING", 4)));
        System.out.println(convertStringInZipzag("ABC", 1));
    }
}

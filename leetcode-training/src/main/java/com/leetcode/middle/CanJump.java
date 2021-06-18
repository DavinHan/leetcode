package com.leetcode.middle;

import javax.naming.ldap.Rdn;
import java.util.ArrayList;
import java.util.List;

public class CanJump {

    /**
     * Time Limit Exceeded
     */
    public static boolean canJump1(int[] nums) {
        if(nums == null) {
            return true;
        } else {
            return canJump1(nums, 0, nums.length - 1);
        }
    }

    public static boolean canJump1(int[] nums,int curPos, int finalPos) {
        if(curPos >= finalPos) {
            return true;
        } else {
            for (int i = nums[curPos];i >= 1;i--) {
                if(canJump1(nums, curPos + i, finalPos)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * array add
     */
    public static boolean canJump2(int[] nums) {
        if(nums == null || nums.length < 2) {
            return true;
        } else {
            int len = nums.length;
            int[] a = new int[len];
            for (int i = 0;i < len;i++) {
                for (int j = nums[i], k = i; j >= 1 && k < len; j--, k++) {
                    a[k] += j;
                }
            }
            for (int i = 0;i < len;i++) {
                if (a[i] <= 0 && i != len - 1) {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
//        System.out.println("target is true, and test is " + canJump1(new int[]{2,0,0}));
//        System.out.println("target is true, and test is " + canJump1(new int[]{2,3,1,1,4}));
//        System.out.println("target is false, and test is " + canJump1(new int[]{3,2,1,0,4}));
        System.out.println("target is true, and test is " + canJump2(new int[]{2,0,0}));
        System.out.println("target is true, and test is " + canJump2(new int[]{2,3,1,1,4}));
        System.out.println("target is false, and test is " + canJump2(new int[]{3,2,1,0,4}));
    }
}

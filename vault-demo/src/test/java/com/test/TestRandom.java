package com.test;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 概率问题：<br/>
 * 1. 1:1:1，实际中，并不会完全和期待值相等，而是趋近期待效果，即，运气不好时，别人的30%其实是你的100%<br/>
 * 2. Random并不是完全随机数，而是伪随机数，并不能100%期望他给出的结果是正态均匀分布的<br/>
 */
public class TestRandom {

    @Test
    public void test0() {
        int[] a = new int[3];
        a[0] = a[1] = a[2] = 0;
        for (int i = 0;i < 99999999;i++) {
            int i1 = new Random().nextInt(3);
            switch (i1 % 3) {
                case 0:
                    a[0]++;
                    break;
                case 1:
                    a[1]++;
                    break;
                case 2:
                    a[2]++;
                    break;
            }
        }
        // 33331414:33334085:33334500
        System.out.println(a[0] + ":" + a[1] + ":" + a[2]);
    }
}

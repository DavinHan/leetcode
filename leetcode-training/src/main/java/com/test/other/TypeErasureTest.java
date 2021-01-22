package com.test.other;

import java.util.List;

public class TypeErasureTest {

//    public int getSum(List<Integer> nums) {
//         return nums.size();
//    }

    public String getSum(List<String> names) {
        return names.get(0);
    }
}

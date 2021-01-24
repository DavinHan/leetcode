package com.swordOffer.binarySearch;

/**
 * Find the Smallest element in the flipped array.
 * Consider three scenarios:
 * 1. normal: [3,4,5,1,2]
 * 2. extreme: [1,2,3,4,5]  ==> flipped 0 elements in the array
 * 3. special: [1,0,1,1,1] or [1,1,1,0,1] ==> too many equals elements in the array
 */
public class TheMinValueInTheFlippedArray {

    public static int findMinInTheFlippedArray(int[] arr) {
        if(arr == null || arr.length < 1) {
            return -1;
        }
        int len = arr.length;
        int ind1 = 0, ind2 = len - 1;
        // consider scenario 2
        int mid = ind1;
        while(arr[mid] > arr[ind1] || arr[mid] >= arr[ind2]) {
            if(arr[mid] == arr[ind2]) {
                // consider scenario 3
                int min = arr[mid];
                for(int i = mid;i <= ind2;i++) {
                    if(min > arr[i]) {
                        min = arr[i];
                    }
                }
                return min;
            } else {
                mid = (ind1 + ind2) / 2;
                if(mid > ind1) {
                    ind1 = mid;
                } else {
                    ind2 = mid;
                }
            }
        }
        return arr[mid];
    }

    public static void main(String[] args) {
        System.out.println(findMinInTheFlippedArray(new int[]{3,4,5,1,2}));
        System.out.println(findMinInTheFlippedArray(new int[]{1,2,3,4,5}));
        System.out.println(findMinInTheFlippedArray(new int[]{1,0,1,1,1}));
        System.out.println(findMinInTheFlippedArray(new int[]{1,1,1,0,1}));
    }
}

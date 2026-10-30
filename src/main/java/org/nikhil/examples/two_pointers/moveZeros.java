package org.nikhil.examples.two_pointers;

import java.util.Arrays;

/**
 * Two Pointers - Move Zeros
 * DESCRIPTION (inspired by Leetcode.com)
 * Given an integer array nums, write a function to rearrange the array by moving all zeros to the end while keeping the order of non-zero elements unchanged.
 * Perform this operation in-place without creating a copy of the array.
 * Input: nums = [2,0,4,0,9]
 * Output: [2,4,9,0,0]
 */

public class moveZeros {

    public static int[] moveZeros(int[] nums) {
        int nextNonZeroPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {


            }
        }
        return nums;
    }

    public static void moveZeroes(int[] nums) {
        int writeIndex = 0;

        // Copy each non-zero value forward, preserving its order.
        for (int num : nums) {
            if (num != 0) {
                nums[writeIndex++] = num;
            }
        }

        // Fill the remaining positions with zeros.
        while (writeIndex < nums.length) {
            nums[writeIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 4, 0, 9};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int n = 5;
        n = ++n;
        n = n++;
        n =+ 1;
        System.out.println("n = " + n);

        for (int i = 1; i <= 3; ++i) {
            System.out.print(i);
        }
    }
}

package org.nikhil.examples.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 3-Sum
 * DESCRIPTION (inspired by Leetcode.com)
 * Given an input integer array nums (not necessarily sorted), write a function to find all unique triplets [nums[i], nums[j], nums[k]] such that i, j, and k are distinct indices,
 * and the sum of nums[i], nums[j], and nums[k] equals zero. Ensure that the resulting list does not contain any duplicate triplets.
 *
 * Input:
 * nums = [-1,0,1,2,-1,-1]
 * Output:
 * [[-1,-1,2],[-1,0,1]]
 *
 * Explanation: Both nums[0], nums[1], nums[2] and nums[1], nums[2], nums[4] both include [-1, 0, 1] and sum to 0. nums[0], nums[3], nums[4] ([-1,-1,2]) also sum to 0.
 * Since we are looking for unique triplets, we can ignore the duplicate [-1, 0, 1] triplet and return [[-1, -1, 2], [-1, 0, 1]].
 * The order of the triplets and the order of the elements within the triplets do not matter.
 */

public class threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort array to enable 2-pointer technique and handle duplicates
        Arrays.sort(nums);

        // Fix the first element and use two pointers for the remaining 2
        for (int i=0; i < nums.length-2; i++) {
            // skip duplicate values for the first element to avoid duplicate triplets
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            // Initialize two-pointers for the remaining subarray
            int left = i + 1;
            int right = nums.length - 1;

            // Use two-pointer technique to find pairs that sum to -nums[i]
            while(left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if(total < 0) {
                    // sum too small, move left pointer right to increase sum
                    left++;
                } else if(total > 0) {
                    // sum too large, move right pointer left to decrease sum
                    right--;
                } else {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip all duplicate values to avoid duplicate triplets
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // Move both pointers to continue searching
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] inputArr = new int[n];

        System.out.println("Enter the elements in the array:");
        for(int i=0; i<n; i++) {
            inputArr[i] = scanner.nextInt();
        }

        List<List<Integer>> result = threeSum(inputArr);
        System.out.println("Output => " + result);
    }
}

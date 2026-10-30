package org.nikhil.examples.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Max Sum of Distinct Subarrays Length k
 * DESCRIPTION (inspired by Leetcode.com)
 * Given an integer array nums and an integer k, write a function to identify the highest possible sum of a subarray within nums, where the subarray meets the
 * following criteria: its length is k, and all of its elements are unique. If no such subarray exists, return 0.
 * Example 1: Input:
 * nums = [3, 2, 2, 3, 4, 6, 7, 7, -1]
 * k = 4
 * Output: 20
 *
 * Explanation: The subarrays of nums with length 4 are:
 * [3, 2, 2, 3] # elements 3 and 2 are repeated.
 * [2, 2, 3, 4] # element 2 is repeated.
 * [2, 3, 4, 6] # meets the requirements and has a sum of 15.
 * [3, 4, 6, 7] # meets the requirements and has a sum of 20.
 * [4, 6, 7, 7] # element 7 is repeated.
 * [6, 7, 7, -1] # element 7 is repeated.
 * We return 20 because it is the maximum subarray sum of all the subarrays that meet the conditions.
 *
 * Example 2: Input:
 * nums = [5, 5, 5, 5, 5]
 * k = 3
 * Output: 0
 * Explanation: Every subarray of length 3 contains duplicate elements, so no valid subarray exists. Return 0.
 */

public class MaxSumDistinctSubarrays {

    public static long maxSum(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE;
        int start = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        long currentSum = 0;

        for(int end = 0; end < nums.length; end++){
            currentSum += nums[end];
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);

            if(end - start + 1 == k) {
                if(freqMap.size() == k) {
                    maxSum = Math.max(maxSum, currentSum);
                }

                currentSum -= nums[start];
                freqMap.put(nums[start], freqMap.get(nums[start]) - 1);
                if(freqMap.get(nums[start]) == 0) {
                    freqMap.remove(nums[start]);  // Remove the element from the map if its frequency becomes 0.
                }
                start++;
            }
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 4, 6, 7, 7, -1};
        long maxSum1 = maxSum(nums, 4);
        System.out.println("maxSum1= " + maxSum1);

        int[] nums2 = {5, 5, 5, 5, 5};
        long maxSum2 = maxSum(nums2, 3);
        System.out.println("maxSum2= " + maxSum2);
    }
}

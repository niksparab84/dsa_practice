package org.nikhil.examples.sliding_window;

import java.util.Arrays;

/**
 * * Fixed Length Sliding Window * *
 * This technique refers to creating a window that "slides" through an input sequence (typically an array or string).
 * When you know the length of the subarray/substring you are looking for, you can use a fixed-length sliding window. The concept is
 * similar to the variable-length sliding window, but the implementation is a bit simpler, as during each iteration, you both add and
 * remove an element from the window to maintain its fixed size.
 *
 * Problem: Maximum Sum of Subarray with Size K
 * DESCRIPTION
 * Given an array of integers nums and an integer k, find the maximum sum of any contiguous subarray of size k.
 * Example:
 * Input: nums = [2, 1, 5, 1, 3, 2], k = 3
 * Output: 9
 * Explanation: The subarray with the maximum sum is [5, 1, 3] with a sum of 9.
 */

public class FixedLengthSlidingWindow {

    public static int maxSubArraySum(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int start = 0;

        for(int end = 0; end < nums.length; end++) {
            windowSum += nums[end];

            if(end - start + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int maxSum = maxSubArraySum(nums, 3);
        System.out.println("Max Sum = " + maxSum);
    }
}

/**
 * Solution:
 * We start by extending the window to size k. Whenever our window is of size k, we first compute the sum of the window and update max_sum if it is larger than max_sum.
 * Then, we contract the window by removing the leftmost element to prepare for the next iteration. Note how we calculate the sum of the window incrementally by
 * adding the new element and removing from the previous sum.
 * When Do I Use This?
 * Consider using the sliding window pattern for questions that involve searching for a continuous subarray/substring in an array or string that satisfies a certain constraint.
 * If you know the length of the subarray/substring you are looking for, use a fixed-length sliding window. Otherwise, use a variable-length sliding window.
 * Examples:
 * Finding the largest substring without repeating characters in a given string (variable-length).
 * Finding the largest substring containing a single character that can be made by replacing at most k characters in a given string (variable-length).
 * Finding the largest sum of a subarray of size k without duplicate elements in a given array (fixed-length).
 */
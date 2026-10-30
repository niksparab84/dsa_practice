package org.nikhil.examples.two_pointers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DESCRIPTION (inspired by Leetcode.com)
 * Write a function to count the number of triplets in an array nums of non-negative integers that could form the sides of a triangle.
 *
 * For three sides to form a valid triangle, all three of these conditions must hold: (a + b > c), (a + c > b), and (b + c > a),
 * where (a), (b), and (c) are the side lengths. In other words, the sum of every possible pair must exceed the third side.
 *
 * Valid triangle requires:
 * a + b > c AND a + c > b AND b + c > a
 * (every pair must sum to more than the third side)
 * The triplets do not need to be unique.
 *
 * Example:
 * Input: nums = [11,4,9,6,15,18]
 * Output: 10
 *
 * Explanation: Valid combinations are... *
 * 4, 15, 18
 * 6, 15, 18
 * 9, 15, 18
 * 11, 15, 18
 * 9, 11, 18
 * 6, 11, 15
 * 9, 11, 15
 * 4, 9, 11
 * 6, 9, 11
 * 4, 6, 9
 */

public class triangleNumbers {

    public static int findTriangleNumbers(int[] nums) {
        int result = 0;

        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {

            //Initialize two-pointers for remaining subarray
            int left = 0;
            int right = i - 1;

            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println("Valid combinations:" +  result);
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

        int result = findTriangleNumbers(inputArr);
        System.out.println("Output: " + result);
    }

}

/**
 * Solution: https://www.hellointerview.com/learn/code/two-pointers/valid-triangle-number
 * Complexity Analysis:
 * Time Complexity: O(n²) where n is the length of the input array. Sorting costs O(n log n), but the counting step dominates: the outer loop fixes each of the n values
 * as the largest side, and for each one the left and right pointers sweep the array in O(n). That gives O(n²) overall.
 * Space Complexity: O(1) we only keep a running count and the i, left, and right indices, so we use constant extra space beyond sorting the array in place.
 */

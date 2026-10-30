package org.nikhil.examples.two_pointers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: Two Sum
 * DESCRIPTION:
 * Given a sorted array of integers nums, determine if there exists a pair of numbers that sum to a given target.
 * Example:
 * Input: nums = [1,3,4,6,8,10,13], target = 13
 * Output: True (3 + 10 = 13)
 * Input: nums = [1,3,4,6,8,10,13], target = 6
 * Output: False
 *
 * Solution:
 * two pointers in 4 lines
 * 1. Start at both ends
 * 2. Sum is too big: move right in
 * 3. sum is too small: move left in
 * 4. stop on a match, or when they meet
 * This technique uses two pointers to scan an array in a single pass. Most of the time the pointers start at opposite ends and move towards each other.
 * The two-pointer technique leverages the fact that the input array is sorted.
**/

public class twoSum {

    // naive approach using brute force = time compexity => O(n^2)
    public static boolean isPairSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTwoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int currentSum = numbers[left] + numbers[right];
            if(currentSum == target) {
                return true;
            }

            if(currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
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

        Arrays.sort(inputArr);

        System.out.println("Enter the target number:");
        int target = scanner.nextInt();

        System.out.println("Using brute force:");
        boolean isTwoSum = isPairSum(inputArr, target);
        System.out.println("Output => " + isTwoSum);

        System.out.println("Using Two Sum technique:");
        isTwoSum = isTwoSum(inputArr, target);
        System.out.println("Output => " + isTwoSum);
    }
}

/**
 * Solution: https://www.hellointerview.com/learn/code/two-pointers/two-sum
 *
 * Summary:
 * The two-pointer technique leverages the fact that the input array is sorted to eliminate the number of pairs we consider from O(n2)down to O(n).
 * The two-pointers start at opposite ends of the array, and represent the pair of numbers we are currently considering.
 * We repeatedly compare the sum of the current pair to the target, and move a pointer in a way that eliminates unnecessary pairs from our search.
 *
 * When Do I Use This?
 * Consider using the two-pointer technique for questions that involve searching for a pair (or more) of items in an array that meet a certain criteria.
 * Examples:
 * Finding a pair of items that sum to a given target in an array.
 * Finding a triplet of items that sum to 0 in a given array.
 * Finding the maximum amount of water that can be held between two array items representing wall heights.
 */


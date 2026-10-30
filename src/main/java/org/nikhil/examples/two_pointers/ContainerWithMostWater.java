package org.nikhil.examples.two_pointers;

import java.util.Scanner;

/**
 * DESCRIPTION (inspired by Leetcode.com)
 * Given an array heights where each element represents the height of a vertical line, pick two lines to act as the walls of a container.
 * Return the maximum area (amount of water) the container can hold.
 * What is area? Width × height, where width is the distance between walls, and height is the shorter wall (water overflows at the shorter wall).
 * Example 1:
 * heights = [3, 4, 1, 2, 2, 4, 1, 3, 2]
 * Output: 21
 * Example 2:
 * heights = [1, 2, 1]
 * Output: 2
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int currentMax = 0;

        while(left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int currentArea = width * height;

            currentMax = Math.max(currentMax, currentArea);

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return currentMax;
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

        int maxArea = maxArea(inputArr);
        System.out.println("Output: " + maxArea);
    }
}

/**
 * Solution: https://www.hellointerview.com/learn/code/two-pointers/container-with-most-water
 * 1. Start with the widest container
 * 2. Measure it, keep the best
 * 3. Move the pointer at the shorter line
 * 4. Each move rules out pairs that can't win
 *
 * Complexity Analysis:
 * Time Complexity: O(n) where n is the length of the input array. The two pointers start at opposite ends and only ever move toward each other,
 * so each element is visited at most once before they meet. We do constant work at every step, which gives us a single linear pass. *
 * Space Complexity: O(1) we only track the two pointers and a running maximum. No matter how large the input gets, the extra memory we use stays fixed.
 */
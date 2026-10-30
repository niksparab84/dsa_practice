package org.nikhil.examples.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * * Variable Length Sliding Window * *
 * https://www.hellointerview.com/learn/code/sliding-window/variable-length
 *
 * Problem: Fruit Into Baskets
 * DESCRIPTION (inspired by Leetcode.com)
 * Write a function to calculate the maximum number of fruits you can collect from an integer array fruits, where each element represents
 * a type of fruit. You can start collecting fruits from any position in the array, but you must stop once you encounter a third distinct
 * type of fruit. The goal is to find the longest subarray where at most two different types of fruits are collected.
 * Example:
 * Input: fruits = [3, 3, 2, 1, 2, 1, 0]
 * Output: 4
 * Explanation: We can pick up 4 fruit from the subarray [2, 1, 2, 1]
 */
public class VariableLengthSlidingWindow {

    public static int fruitIntoBasketsBruteForce(int[] fruits) {
        int maxLength = 0;

        // i and j are the start and end indices of the subarray
        for (int i = 0; i < fruits.length; i++) {
            for (int j = i; j < fruits.length; j++) {
                Set<Integer> distinct = new HashSet<>();

                for (int k = i; k <= j; k++) {
                    distinct.add(fruits[k]);
                }
                if (distinct.size() <= 2) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    // the subarray starting at i is invalid so we break and move to the next one
                    break;
                }
            }
        }

        return maxLength;
    }

/**
 * The Sliding Window
 * We now have enough context to understand the motivation behind the sliding window pattern. The "window" in the sliding window
 * refers to a subarray we are considering to contain the maximum number of fruits we can collect.
 * Initialization
 * We use two pointers, start and end, to represent the start and end indices of the window. The window is initially empty, and so is the
 * dictionary state that represents the contents of the window. We also initialize a variable max_fruit that represents the maximum amount of fruit we can collect.
 */

    public static int totalFruits(int[] fruits) {
        int start = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        int maxFruit = 0;

        for (int end =0; end < fruits.length; end++) {
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);

            while (basket.size() > 2) {
                basket.put(fruits[start], basket.get(fruits[start]) - 1);
                if (basket.get(fruits[start]) == 0) {
                    basket.remove(fruits[start]);
                }
                start++;
            }

            maxFruit = Math.max(maxFruit, end - start + 1);
        }
        return maxFruit;
    }

    public static void main(String[] args) {
        int[] fruits = {3, 3, 2, 1, 2, 1, 0};
        int maxFruitBrut =  fruitIntoBasketsBruteForce(fruits);
        System.out.println("maxFruitBrut= " + maxFruitBrut);

        //int[] nums2 = {5, 5, 5, 5, 5};
        int maxFruitSW = totalFruits(fruits);
        System.out.println("maxFruitSW= " + maxFruitSW);
    }

}

/**
 * Complexity
 * The time complexity of this algorithm is O(n), where n is the length of the input array. end iterates through the array once, and start iterates through the array
 * at most once. Each time either moves, we arrive at a new window, which requires O(1) time to check if its valid.
 * The space complexity of this algorithm is O(1), since state never contains more than 3 keys.
 *
 * When Do I Use This?
 * Consider using the sliding window pattern for questions that involve searching for a continuous subarray/substring in an array or string that satisfies a certain constraint.
 * If you know the length of the subarray/substring you are looking for, use a fixed-length sliding window. Otherwise, use a variable-length sliding window.
 *
 * Examples:
 * Finding the largest substring without repeating characters in a given string (variable-length).
 * Finding the largest substring containing a single character that can be made by replacing at most k characters in a given string (variable-length).
 * Finding the largest sum of a subarray of size k without duplicate elements in a given array (fixed-length).
 */




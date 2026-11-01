package org.nikhil.examples.sliding_window;

import java.util.HashMap;
import java.util.Map;

/** Longest Substring Without Repeating Characters **
 * DESCRIPTION (inspired by Leetcode.com)
 * Write a function to return the length of the longest substring of s in which every character is distinct. A substring is a contiguous block of characters,
 * so "bcd" is a substring of "abcde" but "ace" is not.
 * Example 1: Input:
 * s = "eghghhgg"
 * Output: 3
 * The longest substring without repeating characters is "egh" with length of 3.
 * Example 2: Input:
 * s = "substring"
 * Output: 8
 * The answer is "ubstring" with length of 8.
 * Constraints:
 * s can contain any characters: uppercase and lowercase letters, digits, symbols, and spaces.
 * Matching is case-sensitive, so "a" and "A" count as different characters (don't assume the input is only lowercase letters).
 * s may be empty, in which case the answer is 0.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> state = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            state.put(ch, state.getOrDefault(ch, 0) + 1);
            while(state.get(ch) > 1) {
                char startChar = s.charAt(start);
                state.put(startChar, state.get(startChar) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of longest substring => " + lengthOfLongestSubstring("eghghhgg"));
    }

}

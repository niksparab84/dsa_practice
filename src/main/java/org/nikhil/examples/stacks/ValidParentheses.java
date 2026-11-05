package org.nikhil.examples.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * * Valid Parentheses * *
 * DESCRIPTION (inspired by Leetcode.com)
 * Given an input string s consisting solely of the characters '(', ')', '{', '}', '[' and ']', determine whether 's' is a valid string.
 * A string is considered valid if every opening bracket is closed by a matching type of bracket and in the correct order, and every closing bracket has a
 * corresponding opening bracket of the same type.
 * Example 1: Inputs: s = "(){({})}"
 * Output: True
 * Example 2: Inputs: s = "(){({}})"
 * Output: False
 *
 * https://www.hellointerview.com/learn/code/stack/valid-parentheses
 */

public class ValidParentheses {

    public static boolean isValidString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        for(char c : s.toCharArray()){
            if(mapping.containsKey(c)){
                if( stack.isEmpty() || stack.peek() != mapping.get(c) ){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

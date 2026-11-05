package org.nikhil.examples.intervals;

import java.util.Arrays;

/**
 * * Can Attend Meetings * *
 * DESCRIPTION (inspired by Leetcode.com)
 * Write a function to check if a person can attend all the meetings scheduled without any time conflicts. Given an array intervals, where each element [s1, e1] represents
 * a meeting starting at time s1 and ending at time e1, determine if there are any overlapping meetings.
 * If there is no overlap between any meetings, return true; otherwise, return false.
 * Note that meetings ending and starting at the same time, such as (0,5) and (5,10), do not conflict.
 * Input: intervals = [(1,5),(3,9),(6,8)]
 * Output: false
 * Explanation: The meetings (1,5) and (3,9) overlap.
 * Input: intervals = [(10,12),(6,9),(13,15)]
 * Output: true
 * Explanation: There are no overlapping meetings, so the person can attend all.
 */

public class CanAttendMeetings {

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // how does this works ?

        for(int i = 1; i < intervals.length; i++) {
            int endTimeOfPrevMeeting = intervals[i-1][1];
            int startTimeOfNextMeeting = intervals[i][0];

            if(startTimeOfNextMeeting < endTimeOfPrevMeeting){
                return false;
            }
        }

        return true;
    }
}

/**
 * Complexity Analysis
 * Time Complexity: O(n log n) where n is the number of intervals. The time complexity is dominated by the sorting step.
 * Space Complexity: O(n) The sorting step requires O(n) auxiliary space in most language implementations (e.g., Timsort in Python, merge sort in Java).
 */

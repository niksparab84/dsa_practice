package org.nikhil.examples.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval *
 * DESCRIPTION (inspired by Leetcode.com)
 * You're given a list of intervals intervals that is already sorted by start time and has no overlaps, plus a single interval newInterval.
 * Write a function that returns a new list containing all the intervals after newInterval has been inserted. The returned list must stay sorted by start time
 * and have no overlaps, so any intervals that overlap once newInterval is added should be merged together. You don't need to modify intervals in place; just build and return the result.
 * Two intervals are considered overlapping if they share any common time, including if one ends exactly when another begins (e.g., [1,4] and [4,7] overlap and
 * should be merged into [1,7]).
 * Input: intervals = [[1,3],[6,9]]
 * newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Explanation: The new interval [2,5] overlaps with [1,3], so they are merged into [1,5].
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10]]
 * newInterval = [5,6]
 */

public class InsertInterval {

    public static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        merged.add(newInterval);
        for(int j = i; j < n; j++) {
            merged.add(intervals[j]);
        }

        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * Complexity Analysis
     * Time Complexity: O(n) where n is the number of intervals. We iterate through all intervals once to merge them.
     * Space Complexity: O(n) where n is the number of intervals. We need space for the merged output array.
     */
}

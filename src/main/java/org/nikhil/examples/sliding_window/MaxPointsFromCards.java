package org.nikhil.examples.sliding_window;

/**
 * Max Points You Can Obtain From Cards
 * DESCRIPTION (inspired by Leetcode.com)
 * Given an array of integers representing card values, write a function to calculate the maximum score you can achieve by picking exactly k cards.
 * You must pick cards in order from either end. You can take some cards from the beginning, then switch to taking cards from the end, but you cannot
 * skip cards or pick from the middle.
 * For example, with k = 3:
 * Take the first 3 cards: valid
 * Take the last 3 cards: valid
 * Take the first card, then the last 2 cards: valid
 * Take the first 2 cards, then the last card: valid
 * Take card at index 0, skip some, then take card at index 5: not valid (skipping cards)
 * Constraints: 1 <= k <= cards.length
 *
 * Example 1: Input:
 * cards = [2,11,4,5,3,9,2]
 * k = 3
 * Output: 17
 * Explanation:
 * First 3 cards: 2 + 11 + 4 = 17
 * Last 3 cards: 3 + 9 + 2 = 14
 * First 1 + last 2: 2 + 9 + 2 = 13
 * First 2 + last 1: 2 + 11 + 2 = 15
 * Maximum score is 17.
 *
 * Example 2: Input:
 * cards = [1, 100, 10, 0, 4, 5, 6]
 * k = 3
 * Output: 111
 * Explanation: Take the first three cards: 1 + 100 + 10 = 111. This is better than taking the last 3 cards (4 + 5 + 6 = 15) or any other combination.
 */

public class MaxPointsFromCards {

    public static int maxScore(int[] cards, int k) {
        int total = 0;
        for(int card : cards) {
            total += card;
        }
        if(k == cards.length) {
            return total;
        }

        int state = 0;
        int maxPoints = 0;
        int start = 0;
        for(int end = 0; end < cards.length; end++) {
            state += cards[end];

            if(end - start + 1 == cards.length - k) {
                maxPoints = Math.max(total - state, maxPoints);
                state -= cards[start];
                start++;
            }
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        int[] nums = {2,11,4,5,3,9,2};
        int maxPoints = maxScore(nums, 3);
        System.out.println("maxPoints= " + maxPoints);
    }
}

/**
 * Solution:
 * Since we know the total sum of all cards, we can calculate:
 * Sum of picked cards = Total sum - Sum of unpicked cards
 * So to maximize the sum of picked cards, we need to minimize the sum of unpicked cards.
 * This transforms the problem: instead of trying all combinations of picking from ends, we find the minimum sum of any window of size n - k.
 *
 * Use a fixed-length sliding window of size n - k to find the minimum sum of any consecutive n - k cards. For each window position, calculate
 * total - window_sum to get the corresponding score and track the maximum.
 */

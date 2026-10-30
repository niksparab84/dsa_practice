package org.nikhil.examples.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIndices {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                result[0] = indexMap.get(nums[left]);
                result[1] = indexMap.get(nums[right]);
                break;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexByValue.containsKey(complement)) {
                return new int[] { indexByValue.get(complement), i };
            }

            // Store this number's index for a later element.
            indexByValue.put(nums[i], i);
        }

        // The problem guarantees exactly one solution.
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int[] result = twoSumMap(nums, 6);
        System.out.println(Arrays.toString(result));
    }
}

package com.shikavani.basic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * You are given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i != j && (nums[i] + nums[j] == target)){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(numIndexMap.containsKey(target - nums[i])){
                return new int[]{i, numIndexMap.get(target - nums[i])};
            }else{
                numIndexMap.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};

        int[] ans = new TwoSum().twoSum(nums, 6);

        Arrays.stream(ans).forEach(System.out::println);
    }
}

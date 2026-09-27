package com.shikavani.basic;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 */
public class ContainDuplicate217 {

    // TC -> O(n^2)
    public boolean containsDuplicateBruteForce(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i != j && nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // TC -> O(nlogn) + O(n) => O(nlogn)
    public boolean containsDuplicateBetter(int[] nums){

        Arrays.sort(nums); // sort the array in O(nlogn)

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }


    // iterate on all the elements O(n)
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums){
            set.add(i);
        }

        return set.size() != nums.length;
    }

    // early exit -> O(n)
    public boolean containsDuplicateOptimal(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new ContainDuplicate217().containsDuplicateBetter(nums));
    }
}

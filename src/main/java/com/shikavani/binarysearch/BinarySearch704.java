package com.shikavani.binarysearch;

/**
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch704 {

    // Brute force -> O(n)
    public int search(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    // Since the array is sorted -> O(logn)
    public int binarySearch(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;

        while( l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};

        System.out.println(new BinarySearch704().binarySearch(nums, 10));
    }
}

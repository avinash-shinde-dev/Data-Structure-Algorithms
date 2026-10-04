package com.shikavani.binarysearch;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums,target);
        ans[1] = findLast(nums,target);
        return ans;
    }

    private int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int firstIndex = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                firstIndex = mid;
                high = mid - 1;
            }
            if(nums[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return firstIndex;
    }
    private int findLast(int[] nums, int target){
            int low = 0;
            int high = nums.length-1;
            int lastIndex = -1;
            while(low <= high) {
                int mid = (low + high) / 2;
                if(nums[mid] == target){
                    low = mid + 1;
                    lastIndex = mid;
                }
                if(nums[mid] < target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 5;

        int[] ans  = new FindFirstAndLastPositionOfElementInSortedArray34().searchRange(nums, target);
        System.out.printf("[ %s, %s]", ans[0],ans[1]);
    }
}

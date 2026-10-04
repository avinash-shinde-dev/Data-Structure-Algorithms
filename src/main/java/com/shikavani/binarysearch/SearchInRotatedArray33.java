package com.shikavani.binarysearch;

public class SearchInRotatedArray33 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                return mid;
            }

            // This tells us that the left half is sorted
            if(nums[low] <= nums[mid]){
                // check if the element is present in that sorted half
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low  = mid + 1;
                }
            }else{
                // check if the element is present in the right sorted half
                if(target <= nums[high] && target > nums[mid]){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,1,2,3};
        int target = 8;

        System.out.printf("Answer: %s", new SearchInRotatedArray33().search(nums, target));
    }
}

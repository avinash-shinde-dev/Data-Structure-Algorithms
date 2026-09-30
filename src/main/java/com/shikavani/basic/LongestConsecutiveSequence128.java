package com.shikavani.basic;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence128 {

    // Tc -> O(n) + O(n^2)
    public int longestConsecutiveBruteForce(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        // This set will help us to remember if we have seen this element in O(1)
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        int longestConsecutive = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int count = 1;
            while(set.contains(temp+1)){
                count++;
                temp = temp+1;
            }
            longestConsecutive = Math.max(longestConsecutive, count);
        }

        return longestConsecutive;
    }

    // TC -> O(nlogn) + O(n)
    public int longestConsecutiveBetter(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        // 0,0,1,2,3,4,5,6,7,8,
        int longestConsecutive = 0;
        int count = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            if((nums[i]+1) == nums[i+1]){
                count++;
            }else{
                longestConsecutive = Math.max(longestConsecutive, count);
                count = 1;
            }
        }

        longestConsecutive = Math.max(longestConsecutive, count);

        return longestConsecutive;
    }

    // How this doesn't belong to O(n^2) ?
    // Solution -> Think about how many times the inner loop will run
    // not for every element right? only for start position it will move forward
    // that's why it is not O(n^2)

    public int longestConsecutiveOptimal(int[] nums) {

        // This set will help us to remember if we have seen this element in O(1)
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        int longestConsecutive = 0;
        for(int num: set){
            // This means that num is the starting and then start walking forward
            if(!set.contains(num-1)){
                int count = 1;
                int temp = num;
                while(set.contains(temp)){
                    count++;
                    temp+=1;
                }
                longestConsecutive = Math.max(longestConsecutive, count);
            }
        }

        return longestConsecutive;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};

        System.out.println(new LongestConsecutiveSequence128().longestConsecutiveBetter(nums));
    }
}

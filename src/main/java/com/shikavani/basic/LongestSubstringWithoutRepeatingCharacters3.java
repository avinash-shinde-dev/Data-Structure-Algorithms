package com.shikavani.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring
 * without duplicate characters.
 *
 * s consists of English letters, digits, symbols and spaces.
 *
 * abcabcbb -> 3 i.e abc or cab
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    private boolean isValid(String s){
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        return s.length() == set.size();
    }

    // TC -> O(n^2*k) SC -> O(k)
    public int lengthOfLongestSubstringBruteForce(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) { // n
            for (int j = i+1; j < s.length(); j++) { // ~n
                String sub = s.substring(i, j+1);  // k
                if(isValid(sub)){  // k
                    maxLength = Math.max(maxLength, sub.length());
                }
            }
        }
        return maxLength;
    }

    // TC -> O(n) SC -> O(k)
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        while(r < s.length()){
            if(charIndexMap.get(s.charAt(r)) != null && charIndexMap.get(s.charAt(r)) >= l){
                l = charIndexMap.get(s.charAt(r))+1;
            }
            charIndexMap.put(s.charAt(r), r);
            maxLength = Math.max(maxLength, (r - l+1));
            r++;
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringArrayVariation(String s) {
        int maxLength = 0;
        int l = 0;
        int r = 0;
        int[] vis = new int[256];
        Arrays.fill(vis, -1);
        while(r < s.length()){
            if(vis[s.charAt(r)] >= l){
                l = vis[s.charAt(r)]+1;
            }
            vis[s.charAt(r)] = r;
            maxLength = Math.max(maxLength, (r - l + 1));
            r++;

        }

        return maxLength;

    }



    public static void main(String[] args) {
         String s = "pwwkew";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring(s));
    }
}

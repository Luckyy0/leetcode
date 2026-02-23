package leet_code.Problem_594_Easy_Longest_Harmonious_Subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Finds the length of the longest harmonious subsequence.
     * Strategy: Use a frequency map and check for pairs (x, x+1).
     * Time: O(N), Space: O(N).
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Build frequency map
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int longest = 0;

        // Check for each key if its "harmonious neighbor" (key + 1) exists
        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                int currentLen = countMap.get(key) + countMap.get(key + 1);
                longest = Math.max(longest, currentLen);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println("Longest Harmonious Subsequence: " + solution.findLHS(nums)); // 5
    }
}

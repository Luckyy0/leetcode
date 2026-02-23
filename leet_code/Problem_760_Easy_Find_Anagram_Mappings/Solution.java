package leet_code.Problem_760_Easy_Find_Anagram_Mappings;

import java.util.*;

public class Solution {

    /**
     * Maps elements from nums1 to nums2.
     * Strategy: Hash Map storing lists of indices.
     * Time: O(N), Space: O(N).
     */
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        // Build map from Value -> List of Indices in nums2
        for (int i = 0; i < nums2.length; i++) {
            map.computeIfAbsent(nums2[i], k -> new LinkedList<>()).add(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // Get index and remove it to handle duplicates correctly
            result[i] = map.get(nums1[i]).poll();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 12, 28, 46, 32, 50 };
        int[] nums2 = { 50, 12, 32, 46, 28 };
        System.out.println("Result 1: " + Arrays.toString(sol.anagramMappings(nums1, nums2)));
        // [1, 4, 3, 2, 0]

        int[] n1 = { 84, 46 };
        int[] n2 = { 84, 46 };
        System.out.println("Result 2: " + Arrays.toString(sol.anagramMappings(n1, n2)));
        // [0, 1]
    }
}

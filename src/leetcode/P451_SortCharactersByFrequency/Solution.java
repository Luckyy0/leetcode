package leetcode.P451_SortCharactersByFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 451: Sort Characters By Frequency
     * Approach: Bucket Sort
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String frequencySort(String s) {
        if (s == null || s.isEmpty())
            return s;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int n = s.length();
        List<Character>[] buckets = new List[n + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "tree" -> "eert" or "eetr"
        runTest(sol, "tree");

        // "cccaaa" -> "cccaaa" or "aaaccc"
        runTest(sol, "cccaaa");

        // "Aabb" -> "bbAa" or "bbaA"
        runTest(sol, "Aabb");
    }

    private static void runTest(Solution sol, String s) {
        String result = sol.frequencySort(s);
        System.out.println("Original: " + s + " -> Sorted: " + result);
    }
}

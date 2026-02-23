package leet_code.Problem_451_Medium_Sort_Characters_By_Frequency;

import java.util.*;

public class Solution_BucketSort {

    /**
     * Sorts characters in a string by their frequency.
     * Strategy: Count frequencies, then use Bucket Sort for O(N).
     * Time: O(N), Space: O(N).
     */
    public String frequencySort(String s) {
        if (s == null || s.isEmpty())
            return s;

        // Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Create buckets
        // Index of bucket array represents frequency
        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 1; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    // Append frequency times
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_BucketSort solution = new Solution_BucketSort();
        System.out.println("Result (tree): " + solution.frequencySort("tree")); // eert/eetr
        System.out.println("Result (cccaaa): " + solution.frequencySort("cccaaa")); // cccaaa/aaaccc
    }
}

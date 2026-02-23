package leet_code.Problem_692_Medium_Top_K_Frequent_Words;

import java.util.*;

public class Solution {

    /**
     * Finds the k most frequent words.
     * Strategy: HashMap for counts, Min-Heap of size k for top elements.
     * Time: O(N log K), Space: O(N).
     */
    public List<String> topKFrequent(String[] words, int k) {
        // 1. Count frequencies using a map
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        // 2. Use a PriorityQueue (Min-Heap) to maintain top K elements
        // Comparator logic:
        // - If frequencies differ, smaller frequency comes first (top of heap)
        // - If frequencies are same, lexicographically LARGER word comes first (top of
        // heap)
        // We want to remove the "worse" candidates if heap size > K.
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    int freqA = counts.get(a);
                    int freqB = counts.get(b);
                    if (freqA != freqB) {
                        return freqA - freqB; // Min-heap on frequency
                    }
                    return b.compareTo(a); // Inverse lexicographical in min-heap
                });

        for (String word : counts.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // Keep only k best
            }
        }

        // 3. Extract results and reverse to get highest-to-lowest order
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words1 = { "i", "love", "leetcode", "i", "love", "coding" };
        System.out.println("Result (k=2): " + sol.topKFrequent(words1, 2)); // ["i", "love"]

        String[] words2 = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        System.out.println("Result (k=4): " + sol.topKFrequent(words2, 4)); // ["the", "is", "sunny", "day"]
    }
}

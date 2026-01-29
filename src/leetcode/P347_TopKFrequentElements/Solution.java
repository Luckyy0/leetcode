package leetcode.P347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 347: Top K Frequent Elements
     * Approach: Bucket Sort
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[idx++] = num;
                    if (idx == k)
                        break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,1,1,2,2,3], k=2 -> [1,2]
        runTest(solution, new int[] { 1, 1, 1, 2, 2, 3 }, 2);

        // [1], k=1 -> [1]
        runTest(solution, new int[] { 1 }, 1);
    }

    private static void runTest(Solution s, int[] nums, int k) {
        int[] result = s.topKFrequent(nums, k);
        // Sort for deterministic validation if needed, but problem allows any order.
        // For simplicity, just print.
        System.out.println("Input: " + Arrays.toString(nums) + ", k=" + k + " -> " + Arrays.toString(result));
        System.out.println("-----------------");
    }
}

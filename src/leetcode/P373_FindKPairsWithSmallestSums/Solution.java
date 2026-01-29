package leetcode.P373_FindKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    /**
     * Problem 373: Find K Pairs with Smallest Sums
     * Approach: Min-Heap
     * 
     * Time Complexity: O(k log k)
     * Space Complexity: O(k)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }

        // Min-heap storing indices {index_in_nums1, index_in_nums2}
        // Ordered by sum
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long sumA = (long) nums1[a[0]] + nums2[a[1]];
            long sumB = (long) nums1[b[0]] + nums2[b[1]];
            return Long.compare(sumA, sumB);
        });

        // Init heap with pairs (i, 0)
        // Only need up to k rows because other rows start with larger sums
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[] { i, 0 });
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[0];
            int j = current[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Push next pair in the same row (i, j+1)
            if (j + 1 < nums2.length) {
                pq.offer(new int[] { i, j + 1 });
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,7,11], [2,4,6], k=3 -> [[1,2],[1,4],[1,6]]
        runTest(solution, new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);

        // [1,1,2], [1,2,3], k=2 -> [[1,1],[1,1]]
        runTest(solution, new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2);
    }

    private static void runTest(Solution s, int[] n1, int[] n2, int k) {
        List<List<Integer>> result = s.kSmallestPairs(n1, n2, k);
        System.out.println("Result: " + result);
        System.out.println("-----------------");
    }
}

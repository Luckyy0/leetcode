package leetcode.P444_SequenceReconstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    /**
     * Problem 444: Sequence Reconstruction
     * Approach: Topological Sort (Kahn's Algorithm)
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Initialize maps for all numbers in nums
        for (int x : nums) {
            adj.put(x, new ArrayList<>());
            inDegree.put(x, 0);
        }

        // Build graph from sequences
        boolean hasSequenceNodes = false;
        for (List<Integer> seq : sequences) {
            hasSequenceNodes = true;
            for (int i = 0; i < seq.size() - 1; i++) {
                int u = seq.get(i);
                int v = seq.get(i + 1);

                // If nodes not in nums, technically invalid but per constraints:
                if (!adj.containsKey(u) || !adj.containsKey(v))
                    return false;

                adj.get(u).add(v);
                inDegree.put(v, inDegree.get(v) + 1);
            }
        }

        if (!hasSequenceNodes && n > 0)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        for (int x : nums) {
            if (inDegree.get(x) == 0) {
                queue.offer(x);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            // If at any point more than one node can be processed, result is not unique
            if (queue.size() > 1)
                return false;

            int curr = queue.poll();
            // Order must match nums
            if (curr != nums[index++])
                return false;

            for (int next : adj.get(curr)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        return index == n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // nums = [1,2,3], sequences = [[1,2],[1,3]] -> false
        int[] nums1 = { 1, 2, 3 };
        List<List<Integer>> seq1 = new ArrayList<>();
        seq1.add(java.util.Arrays.asList(1, 2));
        seq1.add(java.util.Arrays.asList(1, 3));
        runTest(sol, nums1, seq1, false);

        // nums = [1,2,3], sequences = [[1,2]] -> false
        int[] nums2 = { 1, 2, 3 };
        List<List<Integer>> seq2 = new ArrayList<>();
        seq2.add(java.util.Arrays.asList(1, 2));
        runTest(sol, nums2, seq2, false);

        // nums = [1,2,3], sequences = [[1,2],[2,3]] -> true
        int[] nums3 = { 1, 2, 3 };
        List<List<Integer>> seq3 = new ArrayList<>();
        seq3.add(java.util.Arrays.asList(1, 2));
        seq3.add(java.util.Arrays.asList(2, 3));
        runTest(sol, nums3, seq3, true);
    }

    private static void runTest(Solution sol, int[] nums, List<List<Integer>> seq, boolean expected) {
        boolean result = sol.sequenceReconstruction(nums, seq);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

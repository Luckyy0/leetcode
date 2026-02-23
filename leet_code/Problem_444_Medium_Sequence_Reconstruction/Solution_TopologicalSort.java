package leet_code.Problem_444_Medium_Sequence_Reconstruction;

import java.util.*;

public class Solution_TopologicalSort {

    /**
     * Checks if nums is the unique shortest common supersequence of sequences.
     * Strategy: Topological sort on relations. Ensure only one choice at each step.
     * Time: O(V + E), Space: O(V + E).
     */
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[n + 1];

        // Build graph from sequences
        boolean hasNodes = false;
        for (List<Integer> seq : sequences) {
            hasNodes = true;
            for (int i = 0; i < seq.size(); i++) {
                int u = seq.get(i);
                if (i + 1 < seq.size()) {
                    int v = seq.get(i + 1);
                    adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                    inDegree[v]++;
                }
            }
        }

        if (!hasNodes)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            // If more than one choice, the supersequence is not unique
            if (queue.size() > 1)
                return false;

            int curr = queue.poll();
            // Current node must match the expected position in nums
            if (idx == n || curr != nums[idx])
                return false;
            idx++;

            if (adj.containsKey(curr)) {
                for (int next : adj.get(curr)) {
                    if (--inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return idx == n;
    }

    public static void main(String[] args) {
        Solution_TopologicalSort solution = new Solution_TopologicalSort();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> seqs = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3));
        System.out.println("Result: " + solution.sequenceReconstruction(nums, seqs)); // true
    }
}

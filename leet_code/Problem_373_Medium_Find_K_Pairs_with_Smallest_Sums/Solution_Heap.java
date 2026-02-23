package leet_code.Problem_373_Medium_Find_K_Pairs_with_Smallest_Sums;

import java.util.*;

public class Solution_Heap {

    /**
     * Finds k pairs with smallest sums.
     * Uses min-heap to keep track of candidates.
     * Time: O(K log min(N, K)), Space: O(min(N, K)).
     * 
     * Tìm k cặp có tổng nhỏ nhất.
     * Sử dụng min-heap để theo dõi các ứng cử viên.
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;

        // Min-heap stores {nums1_val, nums2_val, nums2_index}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // Initialize heap with first element of nums2 paired with up to k elements of
        // nums1
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[] { nums1[i], nums2[0], 0 });
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            res.add(Arrays.asList(curr[0], curr[1]));

            // If there's a next element in nums2 for this specific nums1[i]
            if (curr[2] + 1 < nums2.length) {
                pq.offer(new int[] { curr[0], nums2[curr[2] + 1], curr[2] + 1 });
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Heap solution = new Solution_Heap();

        // Test Case 1: [1,7,11], [2,4,6], k=3 -> [[1,2],[1,4],[1,6]]
        int[] n1 = { 1, 7, 11 };
        int[] n2 = { 2, 4, 6 };
        System.out.println("Result 1: " + solution.kSmallestPairs(n1, n2, 3));

        // Test Case 2: [1,1,2], [1,2,3], k=2 -> [[1,1],[1,1]]
        int[] n3 = { 1, 1, 2 };
        int[] n4 = { 1, 2, 3 };
        System.out.println("Result 2: " + solution.kSmallestPairs(n3, n4, 2));
    }
}

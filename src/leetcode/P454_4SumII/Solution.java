package leetcode.P454_4SumII;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 454: 4Sum II
     * Approach: HashMap (Meet-in-the-middle)
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int n = nums1.length;
        int count = 0;

        // Sums of nums1 and nums2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        // Match with sums of nums3 and nums4
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                int target = -(nums3[k] + nums4[l]);
                if (sumMap.containsKey(target)) {
                    count += sumMap.get(target);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2] -> 2
        int[] n1 = { 1, 2 };
        int[] n2 = { -2, -1 };
        int[] n3 = { -1, 2 };
        int[] n4 = { 0, 2 };
        runTest(sol, n1, n2, n3, n4, 2);

        // nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0] -> 1
        int[] zero = { 0 };
        runTest(sol, zero, zero, zero, zero, 1);
    }

    private static void runTest(Solution sol, int[] n1, int[] n2, int[] n3, int[] n4, int expected) {
        int result = sol.fourSumCount(n1, n2, n3, n4);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

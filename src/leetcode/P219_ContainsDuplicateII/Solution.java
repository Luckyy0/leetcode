package leetcode.P219_ContainsDuplicateII;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 219: Contains Duplicate II
     * Approach: Sliding Window using HashSet
     * 
     * Theoretical Basis:
     * - Keep a Set of elements in the current window of size k.
     * - If we find a duplicate in the Set, condition is met.
     * - Remove elements older than k indices.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(min(N, k))
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;

        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If window contains nums[i], we found a duplicate within range k
            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            // Maintain window size <= k
            // If size > k, remove the oldest element
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,1], k=3 -> true
        runTest(solution, new int[] { 1, 2, 3, 1 }, 3, true);

        // [1,0,1,1], k=1 -> true
        runTest(solution, new int[] { 1, 0, 1, 1 }, 1, true);

        // [1,2,3,1,2,3], k=2 -> false
        runTest(solution, new int[] { 1, 2, 3, 1, 2, 3 }, 2, false);
    }

    private static void runTest(Solution s, int[] nums, int k, boolean expected) {
        boolean result = s.containsNearbyDuplicate(nums, k);
        System.out.print("Nums: [");
        for (int i = 0; i < Math.min(nums.length, 5); i++)
            System.out.print(nums[i] + (i < nums.length - 1 ? "," : ""));
        System.out.println(nums.length > 5 ? "...], k: " + k : "], k: " + k);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

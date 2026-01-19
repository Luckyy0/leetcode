package leetcode.P220_ContainsDuplicateIII;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {

    /**
     * Problem 220: Contains Duplicate III
     * Approach: Bucketing (O(N))
     * 
     * Theoretical Basis:
     * - Map numbers to buckets of size (valueDiff + 1).
     * - Check current bucket and adjacent buckets.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(min(N, indexDiff))
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff < 0 || valueDiff < 0) {
            return false;
        }

        // Key: Bucket ID, Value: The number itself
        // Note: we only need to store ONE number per bucket given the window
        // constraint.
        // If we found another number in the same bucket within the window, we would
        // have returned true already.
        Map<Long, Long> buckets = new HashMap<>();
        long w = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long id = getBucketID(num, w);

            // Check if bucket already occupied
            if (buckets.containsKey(id)) {
                return true;
            }

            // Check adjacent buckets
            if (buckets.containsKey(id - 1) && Math.abs(num - buckets.get(id - 1)) < w) {
                return true;
            }

            if (buckets.containsKey(id + 1) && Math.abs(num - buckets.get(id + 1)) < w) {
                return true;
            }

            // Add current
            buckets.put(id, num);

            // Remove old
            if (i >= indexDiff) {
                long oldId = getBucketID(nums[i - indexDiff], w);
                buckets.remove(oldId);
            }
        }

        return false;
    }

    private long getBucketID(long val, long w) {
        // In Java, -3 / 5 = 0, but we want it to be -1 for continuous buckets
        // 0..w-1 -> 0
        // -w..-1 -> -1
        if (val < 0) {
            return (val + 1) / w - 1;
        }
        return val / w;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,1], k=3, t=0 -> true
        runTest(solution, new int[] { 1, 2, 3, 1 }, 3, 0, true);

        // [1,5,9,1,5,9], k=2, t=3 -> false
        runTest(solution, new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3, false);

        // Overflow test: [-1, 2147483647], k=1, t=2147483647 -> false
        // abs(-1 - 2147483647) = 2147483648 > 2147483647
        runTest(solution, new int[] { -1, 2147483647 }, 1, 2147483647, false);
    }

    private static void runTest(Solution s, int[] nums, int k, int t, boolean expected) {
        boolean result = s.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.print("Nums: [");
        for (int i = 0; i < Math.min(nums.length, 5); i++)
            System.out.print(nums[i] + (i < nums.length - 1 ? "," : ""));
        System.out.println(nums.length > 5 ? "...], k=" + k + ", t=" + t : "], k=" + k + ", t=" + t);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

package leetcode.P2040_KthSmallestProductOfTwoSortedArrays;

public class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L;
        long high = 10000000000L;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countLessEqual(nums1, nums2, mid) >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long val) {
        long count = 0;
        // Optimization: nums1 and nums2 are sorted.
        // We can split nums1 into negatives and non-negatives to use two pointers if
        // needed.
        // But straight binary search for each is simpler and fits complexity.
        // If slow, optimize. Simple O(N log N) per check:

        for (int x : nums1) {
            if (x > 0) {
                // x * y <= val => y <= val / x.
                // Floor division logic for negatives careful.
                // Java div rounds towards zero.
                // If val/x is truncation.
                // count y <= floor(val / x).
                // Use double division? Or accurate integer logic.
                // If val >= 0, x > 0 -> floor(val/x)
                // If val < 0, x > 0 -> floor(val/x) ? -5/2 = -2. Floor is -3.
                // Java -5/2 = -2. So if negative result, need adjust?
                // Logic: y * x <= val.
                // Binary search range in nums2.

                // floorDiv logic:
                long target = floorDiv(val, x);
                // Count elements in nums2 <= target
                count += countLeq(nums2, target);
            } else if (x < 0) {
                // x * y <= val => y >= val / x. (x is negative, flip inequality)
                // ceil(val / x).
                // Example: -2 * y <= 5 => y >= -2.5 => y >= -2.
                // val/x = 5/-2 = -2. Ceil is -2.
                // Example: -2 * y <= -5 => y >= 2.5 => y >= 3.
                // val/x = -5/-2 = 2. Ceil is 3.

                long target = ceilDiv(val, x);
                // Count elements in nums2 >= target
                count += countGeq(nums2, target);
            } else {
                // x == 0
                if (0 <= val) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }

    private long floorDiv(long a, long b) {
        // e.g. 5/2 = 2. -5/2 = -3.
        long q = a / b;
        if ((a ^ b) < 0 && (q * b != a)) {
            q--;
        }
        return q;
    }

    private long ceilDiv(long a, long b) {
        // e.g. 5/2 = 3. -5/2 = -2.
        long q = a / b;
        if ((a ^ b) >= 0 && (q * b != a)) {
            q++;
        }
        return q;
    }

    private int countLeq(int[] nums, long target) {
        // Count elements <= target using upper_bound equivalent
        int l = 0, r = nums.length - 1;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                res = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private int countGeq(int[] nums, long target) {
        // Count elements >= target
        // find first element >= target. then count from there to end.
        int l = 0, r = nums.length - 1;
        int idx = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                idx = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums.length - idx;
    }
}

package leetcode.P327_CountOfRangeSum;

public class Solution {

    /**
     * Problem 327: Count of Range Sum
     * Approach: Merge Sort (Divide and Conquer)
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return countAndMergeSort(prefix, lower, upper, 0, n);
    }

    private int countAndMergeSort(long[] sums, int lower, int upper, int start, int end) {
        if (end - start <= 0)
            return 0; // range size 1 (start==end) has 0 pairs. Wait, range of length 1 (i...j)
                      // corresponds to indices in sums?
        // sums array has size n+1. Indices 0 to n.
        // We want pairs (i, j) such that i < j.
        // start and end are indices in 'sums'.
        // If start >= end, no pairs.

        int mid = start + (end - start) / 2;
        int count = countAndMergeSort(sums, lower, upper, start, mid)
                + countAndMergeSort(sums, lower, upper, mid + 1, end);

        // Count valid pairs (i, j) where i is in left part, j is in right part
        int j = mid + 1;
        int k = mid + 1;
        int t = mid + 1;

        long[] cache = new long[end - start + 1];
        int r = 0;

        // Count loops
        // i is in left [start, mid]
        // Actually typical implementation iterates i in left, find j, k in right?
        // OR iterates i in Right, find j, k in Left?
        // Let's iterate i in Left [start, mid].
        // We want: lower <= sums[rightIdx] - sums[i] <= upper
        // => sums[i] + lower <= sums[rightIdx] <= sums[i] + upper

        // Often optimizing: iterate i in Left for counting? No, pointers usually move
        // monotonically if we iterate the OTHER side.
        // Standard: Iterate i in Left. Maintain j, k in Right.
        // But traditional code (Leetcode solutions) often does: Iterate i in Right
        // [mid+1, end]. Maintain m, n in Left.
        // Let's stick to: Iterate i in Left [start, mid].
        // For distinct i, range [sums[i]+lower, sums[i]+upper].
        // Right part is sorted. We can find range in Right.
        // Pointers j and k in Right part.
        // j: first index where sums[j] >= sums[i] + lower
        // k: first index where sums[k] > sums[i] + upper
        // count += k - j.

        // Wait, standard correct implementation usually structures:
        /*
         * int i = start, rightIndex = mid + 1;
         * int m = mid + 1, n = mid + 1;
         * for (i = start; i <= mid; i++) {
         * while (m <= end && sums[m] < sums[i] + lower) m++;
         * while (n <= end && sums[n] <= sums[i] + upper) n++;
         * count += n - m;
         * }
         */
        // Let's verify logic:
        // sums[m] < sums[i] + lower => sums[m] - sums[i] < lower. (Too small)
        // sums[n] <= sums[i] + upper => sums[n] - sums[i] <= upper. (Valid or small)
        // So range [m, n-1] satisfies condition.
        // Logic seems Correct.

        int m = mid + 1;
        int n = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (m <= end && sums[m] < sums[i] + lower)
                m++;
            while (n <= end && sums[n] <= sums[i] + upper)
                n++;
            count += n - m;
        }

        // Merge Sort step
        // Merge sums[start...mid] and sums[mid+1...end]
        int[] sorted = new int[end - start + 1]; // Actually long
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;

        while (p1 <= mid && p2 <= end) {
            if (sums[p1] < sums[p2]) {
                cache[p++] = sums[p1++];
            } else {
                cache[p++] = sums[p2++];
            }
        }
        while (p1 <= mid)
            cache[p++] = sums[p1++];
        while (p2 <= end)
            cache[p++] = sums[p2++];

        System.arraycopy(cache, 0, sums, start, cache.length);

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [-2,5,-1], lower=-2, upper=2 -> 3
        runTest(solution, new int[] { -2, 5, -1 }, -2, 2, 3);
    }

    private static void runTest(Solution s, int[] nums, int l, int u, int expected) {
        int result = s.countRangeSum(nums, l, u);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

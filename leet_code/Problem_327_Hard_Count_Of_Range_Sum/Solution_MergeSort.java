package leet_code.Problem_327_Hard_Count_Of_Range_Sum;

public class Solution_MergeSort {

    /**
     * Counts range sums in [lower, upper].
     * Uses Merge Sort.
     * Time: O(N log N), Space: O(N).
     * 
     * Đếm tổng phạm vi trong [lower, upper].
     * Sử dụng Sắp xếp Trộn.
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        return countAndMergeSort(sums, 0, n, lower, upper);
    }

    private int countAndMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end <= start) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = countAndMergeSort(sums, start, mid, lower, upper)
                + countAndMergeSort(sums, mid + 1, end, lower, upper);

        // Count valid pairs (i, j) where i is in left part, j in right part
        // Đếm cặp hợp lệ (i, j) trong đó i ở phần trái, j ở phần phải
        int j = mid + 1;
        int k = start;
        int t = start;

        // We iterate j from mid+1 to end.
        // For each j, we find range [k, t) in left part such that
        // sums[j] - upper <= sums[i] <= sums[j] - lower
        // Left part is already sorted.
        // Chúng ta lặp j từ mid+1 đến end.
        // Với mỗi j, chúng ta tìm phạm vi [k, t) trong phần trái sao cho
        // sums[j] - upper <= sums[i] <= sums[j] - lower
        // Phần trái đã được sắp xếp.
        long[] cache = new long[end - start + 1];
        int r = 0; // cache index

        // Need to iterate j for counting, AND perform merge.
        // Usually separate loops for clarity.

        // Counting Loop
        for (int i = mid + 1; i <= end; i++) {
            long min = sums[i] - upper;
            long max = sums[i] - lower;

            while (k <= mid && sums[k] < min) {
                k++;
            }
            while (t <= mid && sums[t] <= max) {
                t++;
            }
            count += t - k;
        }

        // Standard Merge Loop
        int p1 = start;
        int p2 = mid + 1;
        int idx = 0;

        while (p1 <= mid && p2 <= end) {
            if (sums[p1] < sums[p2]) {
                cache[idx++] = sums[p1++];
            } else {
                cache[idx++] = sums[p2++];
            }
        }
        while (p1 <= mid)
            cache[idx++] = sums[p1++];
        while (p2 <= end)
            cache[idx++] = sums[p2++];

        System.arraycopy(cache, 0, sums, start, cache.length);

        return count;
    }

    public static void main(String[] args) {
        Solution_MergeSort solution = new Solution_MergeSort();

        // Test Case 1: [-2,5,-1], lower=-2, upper=2 -> 3
        int[] n1 = { -2, 5, -1 };
        System.out.println("Result 1: " + solution.countRangeSum(n1, -2, 2));

        // Test Case 2: [0], lower=0, upper=0 -> 1
        int[] n2 = { 0 };
        System.out.println("Result 2: " + solution.countRangeSum(n2, 0, 0));
    }
}

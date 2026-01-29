package leetcode.P668_KthSmallestNumberInMultiplicationTable;

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (count(mid, m, n) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Count how many numbers are <= x in m x n table
    // Đếm xem có bao nhiêu số <= x trong bảng m x n
    private int count(int x, int m, int n) {
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += Math.min(x / i, n);
        }
        return res;
    }
}

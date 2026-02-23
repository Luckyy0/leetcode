package leet_code.Problem_668_Hard_Kth_Smallest_Number_in_Multiplication_Table;

public class Solution {

    /**
     * Finds the k-th smallest number in an m x n multiplication table.
     * Strategy: Binary search on the resulting value and count elements <= mid.
     * Time: O(m * log(m * n)), Space: O(1).
     */
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (count(mid, m, n) >= k) {
                // If count >= k, mid could be the k-th smallest or larger.
                // Narrow search to lower values.
                high = mid;
            } else {
                // Not enough elements <= mid, k-th smallest must be larger.
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * Helper to count how many numbers in m x n table are <= x.
     */
    private int count(int x, int m, int n) {
        int total = 0;
        for (int i = 1; i <= m; i++) {
            // In row i, elements are i*1, i*2... i*n.
            // i*j <= x => j <= x/i.
            // j is at most n.
            total += Math.min(n, x / i);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result (3x3, k=5): " + sol.findKthNumber(3, 3, 5)); // 3
        System.out.println("Result (2x3, k=6): " + sol.findKthNumber(2, 3, 6)); // 6
    }
}

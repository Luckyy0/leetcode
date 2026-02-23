package leet_code.Problem_1000_Hard_Minimum_Cost_to_Merge_Stones;

/**
 * Problem 1000: Minimum Cost to Merge Stones
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 */
public class Solution {

    /**
     * Calculates the minimum cost to merge all stones into one pile.
     * Strategy: Interval Dynamic Programming (DP).
     * 
     * @param stones Array of stone pile sizes.
     * @param k      The number of piles to merge at a time.
     * @return Minimum cost, or -1 if impossible.
     * 
     *         Tóm tắt chiến lược:
     *         1. Kiểm tra tính khả thi: Mỗi lần gộp K đống thành 1 đống, tổng số
     *         đống giảm đi (K - 1).
     *         Để từ N đống chỉ còn đúng 1 đống cuối cùng, số đống biến mất (N - 1)
     *         phải là bội số của (K - 1).
     *         Nếu `(N - 1) % (K - 1) != 0`, ta trả về -1 ngay lập tức.
     *         2. Ta dùng Quy hoạch động theo khoảng:
     *         `dp[i][j]` là chi phí tối thiểu để gộp đoạn đống đá từ vị trí `i` đến
     *         `j` thành số lượng đống NHỎ NHẤT CÓ THỂ.
     *         3. Tính tổng các viên đá nhanh bằng Mảng Cộng dồn (Prefix Sum Array).
     *         4. Lặp qua các độ dài đoạn `len` từ `k` đến `n`.
     *         Với mỗi đoạn `[i, j]` có độ dài `len`, ta sẽ chia đoạn này thành 2
     *         phần tại điểm cắt `mid`:
     *         - Phần trái: `[i, mid]`
     *         - Phần phải: `[mid + 1, j]`
     *         5. Điểm mấu chốt: Để tránh bị lòi ra các đoạn không thể gộp, ta BẮT
     *         BUỘC phần bên trái `[i, mid]` phải có thể gộp được thành CHÍNH XÁC 1
     *         ĐỐNG.
     *         Điều kiện để gộp thành 1 đống là độ dài của nó trừ đi 1 phải chia hết
     *         cho (K - 1).
     *         Tức là chiều dài `mid - i + 1` giảm dần xuống 1, suy ra `mid - i`
     *         phải là bội của `K - 1`.
     *         - Do đó, bước nhảy của `mid` trong vòng lặp tìm điểm cắt tốt nhất sẽ
     *         phải là `K - 1`.
     *         6. Sau khi quét tìm vị trí `mid` tối ưu để lấy `min(dp[i][mid] +
     *         dp[mid+1][j])`, ta kiểm tra xem
     *         TOÀN BỘ đoạn `[i, j]` HIỆN TẠI có thể gộp được thành 1 đống không?
     *         (`(j - i) % (K - 1) == 0`).
     *         Nếu có, nó sẽ phát sinh thêm 1 thao tác gộp TOÀN BỘ đá trong đoạn này
     *         ở bước cuối cùng.
     *         - Chi phí của phép gộp cuối cùng này chính là Tổng của toàn bộ các
     *         viên đá trong `[i, j]`. Trích xuất từ Prefix Sum rồi cộng vào.
     */
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;

        // Step 1: Check if it's possible to merge into 1 pile
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        // Step 2: Compute prefix sums for quick range sum queries
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // Step 3: Initialize DP table
        // dp[i][j] will store the minimum cost to merge stones[i...j] into the minimum
        // possible number of piles
        int[][] dp = new int[n][n];

        // Length of the subarray we are considering (from k to n)
        // Subarrays shorter than k cannot be merged, cost is implicitly 0 (default in
        // java array).
        for (int len = k; len <= n; len++) {
            // Start index of the subarray
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // End index
                dp[i][j] = Integer.MAX_VALUE;

                // Step 4: Try all valid split points 'mid'
                // We increment 'mid' by 'k - 1' to ensure that the left part [i, mid]
                // can eventually be perfectly merged into exactly 1 pile.
                for (int mid = i; mid < j; mid += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }

                // Step 5: If this entire subarray can be collapsed into exactly 1 pile,
                // we must add the sum of all stones in this subarray as the final merge cost.
                // It can form exactly 1 pile if (j - i) is a multiple of (k - 1).
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }

        // Return the minimum cost to merge the full array [0...n-1] into 1 pile
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] stones1 = { 3, 2, 4, 1 };
        System.out.println("Result 1 (k=2): " + sol.mergeStones(stones1, 2)); // 20

        int[] stones2 = { 3, 2, 4, 1 };
        System.out.println("Result 2 (k=3): " + sol.mergeStones(stones2, 3)); // -1

        int[] stones3 = { 3, 5, 1, 2, 6 };
        System.out.println("Result 3 (k=3): " + sol.mergeStones(stones3, 3)); // 25
    }
}

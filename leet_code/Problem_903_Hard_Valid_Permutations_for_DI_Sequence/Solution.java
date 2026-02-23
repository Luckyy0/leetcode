package leet_code.Problem_903_Hard_Valid_Permutations_for_DI_Sequence;

/**
 * Problem 903: Valid Permutations for DI Sequence
 * https://leetcode.com/problems/valid-permutations-for-di-sequence/
 */
public class Solution {

    /**
     * Calculates the number of valid permutations for a given DI sequence.
     * Strategy: Rank-based Dynamic Programming with Prefix Sum Optimization.
     * 
     * @param s String of 'D' (decreasing) and 'I' (increasing).
     * @return Number of valid permutations modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng quy hoạch động. Gọi dp[i][j] là số lượng hoán vị hợp lệ
     *         có độ dài i+1 (sử dụng các số 0...i) sao cho phần tử cuối cùng
     *         có thứ hạng j (tức là nó lớn hơn j số đã sử dụng trong hoán vị đó).
     *         2. Nếu s[i-1] == 'I' (Tăng):
     *         - Ta cần số tiếp theo (rank j trong tập 0...i) lớn hơn số trước đó.
     *         - Để số hiện tại có rank j trong tập mới (kích thước i+1), số trước
     *         đó
     *         phải có rank k < j trong tập cũ (kích thước i).
     *         - dp[i][j] = sum(dp[i-1][k]) với 0 <= k < j.
     *         3. Nếu s[i-1] == 'D' (Giảm):
     *         - Ta cần số tiếp theo nhỏ hơn số trước đó.
     *         - Để số hiện tại có rank j, số trước đó phải có rank k >= j trong tập
     *         cũ.
     *         - dp[i][j] = sum(dp[i-1][k]) với j <= k <= i-1.
     *         4. Các tổng này có thể được tính trong O(1) bằng cách cộng dồn
     *         (prefix sum/suffix sum)
     *         khi duyệt j.
     */
    public int numPermsDISequence(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        // dp[i][j]: number of valid permutations of length i+1 ending with rank j
        int[][] dp = new int[n + 1][n + 1];

        // Base case: length 1 permutation (just number 0), rank 0
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c == 'I') {
                // For 'I', we need previous rank k < j
                // Calculate prefix sums of dp[i-1] as we iterate j
                int currentSum = 0;
                for (int j = 0; j <= i; j++) {
                    // Start sum from k=0...j-1.
                    // When j=0, sum is 0 (no k < 0).
                    // When j=1, sum is dp[i-1][0].
                    if (j > 0) {
                        currentSum = (currentSum + dp[i - 1][j - 1]) % MOD;
                    }
                    dp[i][j] = currentSum;
                }
            } else {
                // For 'D', we need previous rank k >= j
                // Calculate suffix sums of dp[i-1] as we iterate j backwards
                int currentSum = 0;
                // Maximum possible rank in previous step (length i) was i-1
                for (int j = i - 1; j >= 0; j--) {
                    currentSum = (currentSum + dp[i - 1][j]) % MOD;
                    // Current rank j can go up to i, but for 'D' we only care up to i-1
                    // because if j=i, we need k >= i which is impossible (max k is i-1).
                    // So dp[i][i] is correctly 0.
                    dp[i][j] = currentSum;
                }
            }
        }

        // Use the filled DP table to sum up all possibilities for length n+1
        int ans = 0;
        for (int x : dp[n]) {
            ans = (ans + x) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.numPermsDISequence("DID")); // 5
        System.out.println("Result: " + sol.numPermsDISequence("D")); // 1
        System.out.println("Result: " + sol.numPermsDISequence("IDDDI")); // Example output
    }
}

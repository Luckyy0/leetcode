package leetcode.P1292_MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold;

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j] + mat[i][j];
            }
        }

        int maxLen = 0;

        // Iterate every possible bottom-right corner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Try to extend maxLen
                int k = maxLen + 1;
                // Square top-left would be (i - k + 1, j - k + 1)
                // Need i - k >= 0 and j - k >= 0 (in prefix indices where 1 is first element)
                // Actually indices are 1-based in prefix
                if (i >= k && j >= k) {
                    int r1 = i - k + 1;
                    int c1 = j - k + 1;
                    int sum = prefix[i][j] - prefix[r1 - 1][j] - prefix[i][c1 - 1] + prefix[r1 - 1][c1 - 1];
                    if (sum <= threshold) {
                        maxLen++;
                    }
                }
            }
        }

        return maxLen;
    }
}

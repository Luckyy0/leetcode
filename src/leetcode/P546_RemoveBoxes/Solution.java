package leetcode.P546_RemoveBoxes;

class Solution {
    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n][n][n];
        return calculatePoints(boxes, 0, n - 1, 0);
    }

    private int calculatePoints(int[] boxes, int l, int r, int k) {
        if (l > r)
            return 0;

        if (dp[l][r][k] != 0)
            return dp[l][r][k];

        // Optimization: Consecutive same boxes
        // Tối ưu hóa: Các hộp giống nhau liên tiếp
        while (l < r && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }

        // Option 1: Remove the group of boxes[r] (including k attached ones)
        // Tùy chọn 1: Xóa nhóm boxes[r] (bao gồm k hộp đính kèm)
        dp[l][r][k] = calculatePoints(boxes, l, r - 1, 0) + (k + 1) * (k + 1);

        // Option 2: Try to merge with previous occurrences of the same color
        // Tùy chọn 2: Thử hợp nhất với các lần xuất hiện trước đó của cùng một màu
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k],
                        calculatePoints(boxes, l, i, k + 1) + calculatePoints(boxes, i + 1, r - 1, 0));
            }
        }

        return dp[l][r][k];
    }
}

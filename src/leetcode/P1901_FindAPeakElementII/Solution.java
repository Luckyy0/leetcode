package leetcode.P1901_FindAPeakElementII;

public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Find max in row mid
            int maxCol = 0;
            for (int j = 1; j < n; j++) {
                if (mat[mid][j] > mat[mid][maxCol]) {
                    maxCol = j;
                }
            }

            // Check neighbors
            boolean topIsSmaller = (mid == 0) || (mat[mid][maxCol] > mat[mid - 1][maxCol]);
            boolean bottomIsSmaller = (mid == m - 1) || (mat[mid][maxCol] > mat[mid + 1][maxCol]);

            if (topIsSmaller && bottomIsSmaller) {
                return new int[] { mid, maxCol };
            }

            if (!bottomIsSmaller) {
                // Must be a peak below
                low = mid + 1;
            } else {
                // Must be a peak above
                high = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }
}

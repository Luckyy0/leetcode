package leet_code.Problem_661_Easy_Image_Smoother;

public class Solution {

    /**
     * Smoothes an image by calculating the average of each pixel and its neighbors.
     * Strategy: Iterate through each cell and sum its valid 3x3 neighbors.
     * Time: O(M * N), Space: O(M * N).
     */
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                // Iterate through 3x3 neighborhood
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        // Check bounds
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            sum += img[r][c];
                            count++;
                        }
                    }
                }

                res[i][j] = sum / count;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] img = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        int[][] result = sol.imageSmoother(img);

        // Print result
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

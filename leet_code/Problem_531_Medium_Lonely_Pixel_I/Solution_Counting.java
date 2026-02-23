package leet_code.Problem_531_Medium_Lonely_Pixel_I;

public class Solution_Counting {

    /**
     * Findings lonely pixels.
     * Strategy: Precompute row and column counts.
     * Time: O(M*N), Space: O(M+N).
     */
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Pass 1: Count 'B's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;

        // Pass 2: Verify lonely condition
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_Counting solution = new Solution_Counting();
        char[][] picture = {
                { 'W', 'W', 'B' },
                { 'W', 'B', 'W' },
                { 'B', 'W', 'W' }
        };
        System.out.println("Result: " + solution.findLonelyPixel(picture)); // 3
    }
}

package leetcode.P1351_CountNegativeNumbersInASortedMatrix;

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int r = 0;
        int c = n - 1;

        while (r < m && c >= 0) {
            if (grid[r][c] < 0) {
                count += m - r;
                c--;
            } else {
                r++;
            }
        }

        return count;
    }
}

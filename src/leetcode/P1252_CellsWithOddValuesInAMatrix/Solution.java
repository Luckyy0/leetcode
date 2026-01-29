package leetcode.P1252_CellsWithOddValuesInAMatrix;

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] idx : indices) {
            rows[idx[0]]++;
            cols[idx[1]]++;
        }

        int oddRows = 0;
        for (int r : rows) {
            if (r % 2 != 0)
                oddRows++;
        }

        int oddCols = 0;
        for (int c : cols) {
            if (c % 2 != 0)
                oddCols++;
        }

        // (oddRows combined with evenCols) + (evenRows combined with oddCols)
        // evenCols = n - oddCols
        // evenRows = m - oddRows
        return oddRows * (n - oddCols) + (m - oddRows) * oddCols;
    }
}

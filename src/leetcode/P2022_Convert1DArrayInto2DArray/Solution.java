package leetcode.P2022_Convert1DArrayInto2DArray;

public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0]; // Empty 2D array
        }

        int[][] res = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            res[i / n][i % n] = original[i];
        }

        return res;
    }
}

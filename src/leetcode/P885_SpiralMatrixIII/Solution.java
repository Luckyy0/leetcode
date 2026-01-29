package leetcode.P885_SpiralMatrixIII;

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int count = 0;
        int r = rStart, c = cStart;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // E, S, W, N
        int d = 0;
        int stepLen = 1;

        res[count++] = new int[] { r, c };

        while (count < rows * cols) {
            for (int i = 0; i < 2; i++) { // Two movements per step size increase
                for (int step = 0; step < stepLen; step++) {
                    r += dirs[d][0];
                    c += dirs[d][1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        res[count++] = new int[] { r, c };
                    }
                }
                d = (d + 1) % 4;
            }
            stepLen++;
        }

        return res;
    }
}

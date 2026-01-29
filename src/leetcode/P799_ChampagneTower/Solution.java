package leetcode.P799_ChampagneTower;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = poured;

        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double q = (tower[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    tower[r + 1][c] += q;
                    tower[r + 1][c + 1] += q;
                }
            }
        }

        return Math.min(1.0, tower[query_row][query_glass]);
    }
}

package leetcode.P1515_BestPositionForAServiceCentre;

class Solution {
    public double getMinDistSum(int[][] positions) {
        double x = 0, y = 0;
        for (int[] p : positions) {
            x += p[0];
            y += p[1];
        }
        x /= positions.length;
        y /= positions.length;

        double step = 100;
        double minSum = distSum(positions, x, y);
        double eps = 1e-7;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (step > eps) {
            boolean found = false;
            for (int[] d : dirs) {
                double nx = x + step * d[0];
                double ny = y + step * d[1];
                double nSum = distSum(positions, nx, ny);
                if (nSum < minSum) {
                    minSum = nSum;
                    x = nx;
                    y = ny;
                    found = true;
                    // Keep step same or break to re-evaluate?
                    // Usually break inner to check all neighbors from new center or just move
                    // instantly
                    // Moving instantly is greedy.
                    break;
                }
            }
            if (!found) {
                step /= 2;
            }
        }

        return minSum;
    }

    private double distSum(int[][] positions, double x, double y) {
        double sum = 0;
        for (int[] p : positions) {
            sum += Math.sqrt(Math.pow(p[0] - x, 2) + Math.pow(p[1] - y, 2));
        }
        return sum;
    }
}

package leetcode.P1453_MaximumNumberOfDartsInsideOfACircularDartboard;

class Solution {
    public int numPoints(int[][] darts, int r) {
        int n = darts.length;
        if (n == 0)
            return 0;
        int maxPoints = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = darts[i][0], y1 = darts[i][1];
                int x2 = darts[j][0], y2 = darts[j][1];

                double d2 = (double) (x1 - x2) * (x1 - x2) + (double) (y1 - y2) * (y1 - y2);
                if (d2 > 4.0 * r * r)
                    continue;

                double[] center1 = getCenter(x1, y1, x2, y2, r, true);
                double[] center2 = getCenter(x1, y1, x2, y2, r, false);

                maxPoints = Math.max(maxPoints, countPoints(darts, center1[0], center1[1], r));
                maxPoints = Math.max(maxPoints, countPoints(darts, center2[0], center2[1], r));
            }
        }

        return maxPoints;
    }

    private double[] getCenter(int x1, int y1, int x2, int y2, int r, boolean sign) {
        double d2 = (double) (x1 - x2) * (x1 - x2) + (double) (y1 - y2) * (y1 - y2);
        double d = Math.sqrt(d2);

        double midX = (x1 + x2) / 2.0;
        double midY = (y1 + y2) / 2.0;

        double h = Math.sqrt(Math.max(0, r * r - d2 / 4.0));

        double dx = x2 - x1;
        double dy = y2 - y1;

        double perX = -dy / d;
        double perY = dx / d;

        if (sign) {
            return new double[] { midX + h * perX, midY + h * perY };
        } else {
            return new double[] { midX - h * perX, midY - h * perY };
        }
    }

    private int countPoints(int[][] darts, double cx, double cy, int r) {
        int count = 0;
        double r2 = (double) r * r + 1e-6; // Tolerance
        for (int[] p : darts) {
            double d2 = (p[0] - cx) * (p[0] - cx) + (p[1] - cy) * (p[1] - cy);
            if (d2 <= r2) {
                count++;
            }
        }
        return count;
    }
}

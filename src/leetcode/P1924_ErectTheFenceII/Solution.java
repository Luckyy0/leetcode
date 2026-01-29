package leetcode.P1924_ErectTheFenceII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Solution {
    class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    class Circle {
        Point center;
        double r;

        Circle(Point c, double r) {
            center = c;
            this.r = r;
        }

        boolean contains(Point p) {
            return Math.hypot(p.x - center.x, p.y - center.y) <= r + 1e-6;
        }
    }

    public double[] outerTrees(int[][] trees) {
        List<Point> points = new ArrayList<>();
        for (int[] t : trees)
            points.add(new Point(t[0], t[1]));

        Collections.shuffle(points, new Random());
        Circle mec = welzl(points, new ArrayList<>(), points.size());

        return new double[] { mec.center.x, mec.center.y, mec.r };
    }

    private Circle welzl(List<Point> P, List<Point> R, int n) {
        if (n == 0 || R.size() == 3) {
            return trivial(R);
        }

        Point p = P.get(n - 1);
        Circle D = welzl(P, R, n - 1);

        if (D.contains(p)) {
            return D;
        }

        R.add(p);
        D = welzl(P, R, n - 1);
        R.remove(R.size() - 1);

        return D;
    }

    private Circle trivial(List<Point> R) {
        if (R.isEmpty())
            return new Circle(new Point(0, 0), 0);
        if (R.size() == 1)
            return new Circle(R.get(0), 0);
        if (R.size() == 2) {
            return circleFromTwo(R.get(0), R.get(1));
        }
        // Size 3
        // Check if one circle from 2 covers the 3rd
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                Circle c = circleFromTwo(R.get(i), R.get(j));
                boolean valid = true;
                for (int k = 0; k < 3; k++) {
                    if (!c.contains(R.get(k))) {
                        valid = false;
                        break;
                    }
                }
                if (valid)
                    return c;
            }
        }
        return circleFromThree(R.get(0), R.get(1), R.get(2));
    }

    private Circle circleFromTwo(Point p1, Point p2) {
        Point center = new Point((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0);
        double r = Math.hypot(p1.x - p2.x, p1.y - p2.y) / 2.0;
        return new Circle(center, r);
    }

    private Circle circleFromThree(Point A, Point B, Point C) {
        double D = 2 * (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y));
        double Ux = ((A.x * A.x + A.y * A.y) * (B.y - C.y) +
                (B.x * B.x + B.y * B.y) * (C.y - A.y) +
                (C.x * C.x + C.y * C.y) * (A.y - B.y)) / D;
        double Uy = ((A.x * A.x + A.y * A.y) * (C.x - B.x) +
                (B.x * B.x + B.y * B.y) * (A.x - C.x) +
                (C.x * C.x + C.y * C.y) * (B.x - A.x)) / D;
        Point center = new Point(Ux, Uy);
        double r = Math.hypot(center.x - A.x, center.y - A.y);
        return new Circle(center, r);
    }
}

package leetcode.P478_GenerateRandomPointInACircle;

import java.util.Random;

public class Solution {

    private final double radius;
    private final double xCenter;
    private final double yCenter;
    private final Random random;

    /**
     * Problem 478: Generate Random Point in a Circle
     * Approach: Polar Coordinates with Correct Radial Distribution
     */
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        double theta = random.nextDouble() * 2 * Math.PI;
        // Use sqrt for uniform area distribution
        double r = radius * Math.sqrt(random.nextDouble());

        double x = xCenter + r * Math.cos(theta);
        double y = yCenter + r * Math.sin(theta);

        return new double[] { x, y };
    }

    public static void main(String[] args) {
        Solution sol = new Solution(1.0, 0, 0);
        System.out.println("Point 1: " + java.util.Arrays.toString(sol.randPoint()));
        System.out.println("Point 2: " + java.util.Arrays.toString(sol.randPoint()));
        System.out.println("Point 3: " + java.util.Arrays.toString(sol.randPoint()));
    }
}

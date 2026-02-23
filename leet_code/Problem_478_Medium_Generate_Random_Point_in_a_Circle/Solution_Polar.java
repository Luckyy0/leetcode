package leet_code.Problem_478_Medium_Generate_Random_Point_in_a_Circle;

import java.util.Random;

public class Solution_Polar {
    private double radius;
    private double x_center;
    private double y_center;
    private Random rand;

    public Solution_Polar(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    /**
     * Generates a uniform random point in the circle.
     * Strategy: Polar coordinates with r = R * sqrt(U) and theta = 2*PI * U.
     * Time: O(1), Space: O(1).
     */
    public double[] randPoint() {
        double len = Math.sqrt(rand.nextDouble()) * radius;
        double deg = rand.nextDouble() * 2 * Math.PI;
        double x = x_center + len * Math.cos(deg);
        double y = y_center + len * Math.sin(deg);
        return new double[] { x, y };
    }

    // Alternative: Rejection Sampling
    public double[] randPointRejection() {
        double x, y;
        do {
            x = (rand.nextDouble() * 2 - 1) * radius; // [-R, R]
            y = (rand.nextDouble() * 2 - 1) * radius; // [-R, R]
        } while (x * x + y * y > radius * radius);

        return new double[] { x_center + x, y_center + y };
    }

    public static void main(String[] args) {
        Solution_Polar solution = new Solution_Polar(1.0, 0.0, 0.0);
        double[] p = solution.randPoint();
        System.out.println("Point: [" + p[0] + ", " + p[1] + "]");
    }
}

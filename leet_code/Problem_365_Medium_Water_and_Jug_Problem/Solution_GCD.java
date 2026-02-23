package leet_code.Problem_365_Medium_Water_and_Jug_Problem;

public class Solution_GCD {

    /**
     * Water and Jug Problem.
     * Uses Bézout's Identity: target must be divisible by GCD of capacities.
     * Time: O(log(min(X, Y))), Space: O(1).
     * 
     * Bài toán Nước và Bình chứa.
     * Sử dụng định lý Bézout: mục tiêu phải chia hết cho GCD của dung tích các
     * bình.
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 1. Total water cannot exceed total capacity
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }

        // 2. Target must be multiple of GCD(jug1, jug2)
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution_GCD solution = new Solution_GCD();

        // Test Case 1: 3, 5, 4 -> true
        System.out.println("Result 1: " + solution.canMeasureWater(3, 5, 4));

        // Test Case 2: 2, 6, 5 -> false
        System.out.println("Result 2: " + solution.canMeasureWater(2, 6, 5));

        // Test Case 3: 1, 2, 3 -> true
        System.out.println("Result 3: " + solution.canMeasureWater(1, 2, 3));
    }
}

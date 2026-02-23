package leet_code.Problem_149_Hard_Max_Points_On_A_Line;

import java.util.HashMap;
import java.util.Map;

public class Solution_GCD {

    /**
     * Finds the maximum number of points on a single straight line.
     * Uses O(N^2) approach with GCD to handle slope precision.
     * 
     * Tìm số lượng điểm tối đa trên một đường thẳng duy nhất.
     * Sử dụng phương pháp O(N^2) với GCD để xử lý độ chính xác của độ dốc.
     */
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2)
            return n;

        int maxGlobal = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int maxForPointI = 0;

            for (int j = i + 1; j < n; j++) {
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];

                // Normalize slope using GCD
                // Chuẩn hóa độ dốc bằng GCD
                int common = gcd(dy, dx);
                String slopeKey = (dy / common) + "/" + (dx / common);

                map.put(slopeKey, map.getOrDefault(slopeKey, 0) + 1);
                maxForPointI = Math.max(maxForPointI, map.get(slopeKey));
            }

            // maxForPointI counts lines between point i and others.
            // Add 1 to include point i itself.
            maxGlobal = Math.max(maxGlobal, maxForPointI + 1);
        }

        return maxGlobal;
    }

    // Helper: Calculate Greatest Common Divisor
    // Hỗ trợ: Tính ước chung lớn nhất
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution_GCD solution = new Solution_GCD();

        // Test Case 1: [[1,1],[2,2],[3,3]] -> 3
        int[][] p1 = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        System.out.println("Test Case 1: " + solution.maxPoints(p1));

        // Test Case 2: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] -> 4
        int[][] p2 = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        System.out.println("Test Case 2: " + solution.maxPoints(p2));
    }
}

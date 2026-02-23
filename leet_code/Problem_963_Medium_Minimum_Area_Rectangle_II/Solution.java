package leet_code.Problem_963_Medium_Minimum_Area_Rectangle_II;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 963: Minimum Area Rectangle II
 * https://leetcode.com/problems/minimum-area-rectangle-ii/
 */
public class Solution {

    /**
     * Finds min area of any rectangle (can be rotated) formed by the points.
     * Strategy: Iterate through all triplets of points, check for right angle, and
     * verify 4th point.
     * 
     * @param points Array of points.
     * @return Min area or 0.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ta cần tìm 4 điểm tạo thành hình chữ nhật. Một hình chữ nhật có
     *         các góc vuông.
     *         2. Nếu ta chọn 3 điểm A, B, C và giả sử B là đỉnh có góc vuông, thì
     *         vector BA và BC phải vuông góc.
     *         Điều kiện vuông góc: Tích vô hướng của vector BA và BC bằng 0.
     *         Vector BA = (xA - xB, yA - yB), Vector BC = (xC - xB, yC - yB).
     *         3. Nếu tìm được 3 điểm A, B, C tạo góc vuông tại B, điểm thứ 4 D để
     *         tạo thành hình chữ nhật phải thỏa mãn:
     *         Vector BD = Vector BA + Vector BC.
     *         Tọa độ D = (xA + xC - xB, yA + yC - yB).
     *         4. Kiểm tra xem điểm D có tồn tại trong tập hợp các điểm ban đầu hay
     *         không.
     *         Để kiểm tra nhanh, ta đưa tất cả toạ độ điểm vào một HashSet (dưới
     *         dạng chuỗi hoặc số hash).
     *         5. Nếu D tồn tại, tính diện tích hình chữ nhật: Area = độ dài BA * độ
     *         dài BC.
     *         Cập nhật diện tích nhỏ nhất tìm được.
     *         6. Vì số lượng điểm N <= 50, độ phức tạp O(N^3) là chấp nhận được
     *         (khoảng 125,000 phép tính).
     */
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        if (n < 4)
            return 0;

        // Store points for O(1) existence check
        // Using "x,y" string is simplest. Coordinates range 0-40000.
        // Can also use long logic: x * 40001 + y to avoid string overhead, but N is
        // small.
        Set<String> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
        }

        double minArea = Double.MAX_VALUE;
        boolean found = false;

        // Iterate through all triplets. Let p1 be the corner with 90 degree angle.
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int[] p2 = points[j];

                // Vector p1->p2
                int x12 = p2[0] - p1[0];
                int y12 = p2[1] - p1[1];

                // Optimization: Iterate k > j to avoid duplicate checks slightly?
                // Actually, since p1 is the pivot, p2 and p3 are symmetric.
                // We can enforce j < k if we iterate k fully.
                for (int k = j + 1; k < n; k++) {
                    if (k == i)
                        continue;
                    int[] p3 = points[k];

                    // Vector p1->p3
                    int x13 = p3[0] - p1[0];
                    int y13 = p3[1] - p1[1];

                    // Check dot product for orthogonality
                    if (x12 * x13 + y12 * y13 == 0) {
                        // Potential 4th point p4
                        // p4 = p2 + p3 - p1
                        int x4 = p2[0] + x13;
                        int y4 = p2[1] + y13;

                        if (pointSet.contains(x4 + "," + y4)) {
                            double area = Math.sqrt((double) x12 * x12 + (double) y12 * y12) *
                                    Math.sqrt((double) x13 * x13 + (double) y13 * y13);

                            // Since area can be 0 if points coincide (not possible by constraint
                            // uniqueness), it's safe.
                            // However, area > 0 is implied by uniqueness.
                            if (area < minArea) {
                                minArea = area;
                                found = true;
                            }
                        }
                    }
                }
            }
        }

        return found ? minArea : 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] p1 = { { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 1 } };
        System.out.println("Result: " + sol.minAreaFreeRect(p1)); // 2.00000

        int[][] p2 = { { 0, 1 }, { 2, 1 }, { 1, 1 }, { 1, 0 }, { 2, 0 } };
        System.out.println("Result: " + sol.minAreaFreeRect(p2)); // 1.00000

        int[][] p3 = { { 0, 3 }, { 1, 2 }, { 3, 1 }, { 1, 3 }, { 2, 1 } };
        System.out.println("Result: " + sol.minAreaFreeRect(p3)); // 0.0
    }
}

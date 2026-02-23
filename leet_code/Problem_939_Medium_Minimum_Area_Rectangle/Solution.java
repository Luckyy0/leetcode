package leet_code.Problem_939_Medium_Minimum_Area_Rectangle;

import java.util.*;

/**
 * Problem 939: Minimum Area Rectangle
 * https://leetcode.com/problems/minimum-area-rectangle/
 */
public class Solution {

    /**
     * Calculates the minimum area rectangle formed by 4 points.
     * Strategy: Diagonal Search with HashSet.
     * 
     * @param points Array of [x, y] coordinates.
     * @return Minimum area or 0.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một hình chữ nhật có các cạnh song song với trục tọa độ được xác
     *         định duy nhất bởi hai điểm chéo
     *         (x1, y1) và (x2, y2) nếu x1 != x2 và y1 != y2.
     *         2. Hai điểm còn lại của hình chữ nhật này PHẢI là (x1, y2) và (x2,
     *         y1).
     *         3. Ta lưu tất cả các điểm vào một HashSet để tra cứu nhanh O(1).
     *         Để tiết kiệm bộ nhớ và tránh tạo đối tượng, ta có thể mã hóa tọa độ
     *         (x, y) thành một số nguyên duy nhất.
     *         Vì tọa độ x, y <= 40000, ta có thể dùng công thức: key = 40001 * x +
     *         y.
     *         4. Duyệt qua tất cả các cặp điểm trong mảng.
     *         5. Với mỗi cặp điểm (p1, p2), kiểm tra xem chúng có tạo thành đường
     *         chéo hợp lệ không (x1 != x2 và y1 != y2).
     *         6. Nếu hợp lệ, kiểm tra xem hai điểm còn thiếu (x1, y2) và (x2, y1)
     *         có tồn tại trong HashSet không.
     *         7. Nếu tồn tại đủ 4 điểm, tính diện tích = |x1 - x2| * |y1 - y2| và
     *         cập nhật kết quả nhỏ nhất (minArea).
     */
    public int minAreaRect(int[][] points) {
        Set<Integer> pointSet = new HashSet<>();
        // Coordinate max is 40000. Use 40001 as base to ensure unique encoding.
        for (int[] p : points) {
            pointSet.add(40001 * p[0] + p[1]);
        }

        int minArea = Integer.MAX_VALUE;
        int n = points.length;

        // Iterate over all pairs of points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                // If points share x or share y, they form a line, not a diagonal of
                // axis-aligned rect
                if (x1 != x2 && y1 != y2) {
                    // Check if the other two required corners exist in the set
                    // Corner 3: (x1, y2)
                    // Corner 4: (x2, y1)
                    if (pointSet.contains(40001 * x1 + y2) && pointSet.contains(40001 * x2 + y1)) {
                        int currentArea = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        minArea = Math.min(minArea, currentArea);
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] p1 = { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } };
        System.out.println("Result: " + sol.minAreaRect(p1)); // 4

        int[][] p2 = { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 4, 1 }, { 4, 3 } };
        System.out.println("Result: " + sol.minAreaRect(p2)); // 2
    }
}

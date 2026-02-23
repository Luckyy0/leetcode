package leet_code.Problem_223_Medium_Rectangle_Area;

public class Solution_Math {

    /**
     * Calculates the total area covered by two rectangles.
     * Uses Inclusion-Exclusion Principle.
     * Time: O(1), Space: O(1).
     * 
     * Tính tổng diện tích được bao phủ bởi hai hình chữ nhật.
     * Sử dụng Nguyên lý Bao hàm - Loại trừ.
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Area of Rectangle A
        // Diện tích hình chữ nhật A
        int areaA = (ax2 - ax1) * (ay2 - ay1);

        // Area of Rectangle B
        // Diện tích hình chữ nhật B
        int areaB = (bx2 - bx1) * (by2 - by1);

        // Calculate overlap boundaries
        // Tính ranh giới phần chồng lấn
        int overlapLeft = Math.max(ax1, bx1);
        int overlapRight = Math.min(ax2, bx2);
        int overlapBottom = Math.max(ay1, by1);
        int overlapTop = Math.min(ay2, by2);

        int overlapArea = 0;

        // Check if there is an overlap
        // Kiểm tra xem có chồng lấn không
        if (overlapRight > overlapLeft && overlapTop > overlapBottom) {
            overlapArea = (overlapRight - overlapLeft) * (overlapTop - overlapBottom);
        }

        // Total Area = AreaA + AreaB - Overlap
        // Tổng diện tích = Diện tích A + Diện tích B - Phần chồng lấn
        return areaA + areaB - overlapArea;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: 45
        System.out.println("Total Area 1: " + solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));

        // Test Case 2: 16 (No overlap)
        System.out.println("Total Area 2: " + solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2)); // Actually full
                                                                                                 // overlap
    }
}

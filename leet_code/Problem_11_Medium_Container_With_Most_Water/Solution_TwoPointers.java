package leet_code.Problem_11_Medium_Container_With_Most_Water;

public class Solution_TwoPointers {

    /**
     * Finds the container with the most water using Two Pointers approach.
     * Time Complexity: O(N), Space Complexity: O(1).
     * Tìm thùng chứa có nhiều nước nhất sử dụng phương pháp Hai Con Trỏ.
     * Độ phức tạp thời gian: O(N), Độ phức tạp không gian: O(1).
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Determine the height of the container
            // Xác định chiều cao của thùng chứa
            int h = Math.min(height[left], height[right]);

            // Calculate width
            // Tính chiều rộng
            int w = right - left;

            // Update max area
            // Cập nhật diện tích tối đa
            int area = h * w;
            if (area > maxArea) {
                maxArea = area;
            }

            // Move the pointer pointing to the shorter line
            // Di chuyển con trỏ trỏ đến đường ngắn hơn
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        int[] h1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Test Case 1: " + solution.maxArea(h1));
        // Expected: 49

        // Test Case 2
        int[] h2 = { 1, 1 };
        System.out.println("Test Case 2: " + solution.maxArea(h2));
        // Expected: 1
    }
}

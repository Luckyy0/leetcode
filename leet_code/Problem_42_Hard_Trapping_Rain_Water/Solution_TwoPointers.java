package leet_code.Problem_42_Hard_Trapping_Rain_Water;

public class Solution_TwoPointers {

    /**
     * Computes how much water can be trapped.
     * Uses the Two Pointers approach.
     * Tính toán lượng nước có thể hứng được.
     * Sử dụng phương pháp Hai Con Trỏ.
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();

        // Test Case 1
        int[] h1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Test Case 1: " + solution.trap(h1));
        // Expected: 6

        // Test Case 2
        int[] h2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println("Test Case 2: " + solution.trap(h2));
        // Expected: 9
    }
}

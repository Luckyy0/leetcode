package leetcode.P042_TrappingRainWater;

public class Solution {

    /**
     * Problem 42: Trapping Rain Water
     * Approach: Two Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }, 6);
        runTest(solution, new int[] { 4, 2, 0, 3, 2, 5 }, 9);
        runTest(solution, new int[] { 1, 2, 3 }, 0);
        runTest(solution, new int[] { 3, 2, 1 }, 0);
    }

    private static void runTest(Solution s, int[] height, int expected) {
        System.out.println("Input: length " + height.length); // Avoid printing massive arrays
        int result = s.trap(height);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

package leetcode.P011_ContainerWithMostWater;

public class Solution {

    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n^2) - TLE likely
     */
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    /**
     * Approach 2: Two Pointers (Optimal)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int hLeft = height[left];
            int hRight = height[right];
            int currentArea = Math.min(hLeft, hRight) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer of the shorter line
            // Di chuyển con trỏ của đường ngắn hơn
            if (hLeft < hRight) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }, 49);
        runTest(solution, new int[] { 1, 1 }, 1);
        runTest(solution, new int[] { 4, 3, 2, 1, 4 }, 16);
        runTest(solution, new int[] { 1, 2, 1 }, 2);
    }

    private static void runTest(Solution s, int[] height, int expected) {
        System.out.print("Input: [");
        for (int i = 0; i < Math.min(height.length, 5); i++)
            System.out.print(height[i] + ",");
        if (height.length > 5)
            System.out.print("...");
        System.out.println("]");

        int resBF = s.maxAreaBruteForce(height);
        int resOpt = s.maxArea(height);

        System.out.println("BruteForce: " + resBF);
        System.out.println("Optimal:    " + resOpt + " (Expected: " + expected + ")");

        if (resBF == expected && resOpt == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

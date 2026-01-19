package leetcode.P162_FindPeakElement;

public class Solution {

    /**
     * Problem 162: Find Peak Element
     * Approach: Binary Search (Slope Climbing)
     * 
     * Theoretical Basis:
     * - If nums[mid] < nums[mid+1], we are on an upward slope, peak is to the
     * right.
     * - If nums[mid] > nums[mid+1], we are on a downward slope, peak is to the left
     * (including mid).
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Uphill slope, peak is on the right
                left = mid + 1;
            } else {
                // Downhill slope, current or left is a peak
                right = mid;
            }
        }

        // left == right at the end of the search
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,2,3,1] -> 2
        runTest(solution, new int[] { 1, 2, 3, 1 }, 2);

        // Test 2: [1,2,1,3,5,6,4] -> 1 or 5
        runTest(solution, new int[] { 1, 2, 1, 3, 5, 6, 4 }, 5);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.findPeakElement(nums);
        System.out.println("Output: " + result + " (Index)");

        // Since there can be multiple peaks, we check if the result is a peak
        boolean isPeak = true;
        if (result > 0 && nums[result] <= nums[result - 1])
            isPeak = false;
        if (result < nums.length - 1 && nums[result] <= nums[result + 1])
            isPeak = false;

        if (isPeak) {
            System.out.println("PASS (Valid Peak)");
        } else {
            System.out.println("FAIL (Not a Peak)");
        }
        System.out.println("-----------------");
    }
}

package leetcode.P410_SplitArrayLargestSum;

public class Solution {

    /**
     * Problem 410: Split Array Largest Sum
     * Approach: Binary Search on the Answer
     * 
     * Time Complexity: O(N * log(Sum))
     * Space Complexity: O(1)
     */
    public int splitArray(int[] nums, int m) {
        long low = 0;
        long high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        long result = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canSplit(nums, m, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) result;
    }

    private boolean canSplit(int[] nums, int m, long maxSum) {
        int subarrays = 1;
        long currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
                if (subarrays > m)
                    return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [7,2,5,10,8], m = 2 -> 18
        runTest(solution, new int[] { 7, 2, 5, 10, 8 }, 2, 18);

        // [1,2,3,4,5], m = 2 -> 9
        runTest(solution, new int[] { 1, 2, 3, 4, 5 }, 2, 9);

        // [1,4,4], m = 3 -> 4
        runTest(solution, new int[] { 1, 4, 4 }, 3, 4);
    }

    private static void runTest(Solution sol, int[] nums, int m, int expected) {
        int result = sol.splitArray(nums, m);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

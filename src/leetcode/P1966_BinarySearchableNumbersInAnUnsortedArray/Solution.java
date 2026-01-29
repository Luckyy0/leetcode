package leetcode.P1966_BinarySearchableNumbersInAnUnsortedArray;

public class Solution {
    public int binarySearchableNumbers(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxLeft[i] = currentMax;
            currentMax = Math.max(currentMax, nums[i]);
        }

        int currentMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minRight[i] = currentMin;
            currentMin = Math.min(currentMin, nums[i]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxLeft[i] && nums[i] < minRight[i]) {
                count++;
            }
        }

        return count;
    }
}

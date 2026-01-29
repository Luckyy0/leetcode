package leetcode.P1144_DecreaseElementsToMakeArrayZigzag;

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(calculateMoves(nums, 0), calculateMoves(nums, 1));
    }

    // Calculate moves where indices starting at 'start' (0 or 1) are VALLEYS.
    private int calculateMoves(int[] nums, int start) {
        int moves = 0;
        int n = nums.length;
        for (int i = start; i < n; i += 2) {
            int left = (i > 0) ? nums[i - 1] : Integer.MAX_VALUE;
            int right = (i < n - 1) ? nums[i + 1] : Integer.MAX_VALUE;
            int minNeighbor = Math.min(left, right);

            if (nums[i] >= minNeighbor) {
                moves += nums[i] - minNeighbor + 1;
            }
        }
        return moves;
    }
}

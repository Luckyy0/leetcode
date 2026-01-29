package leetcode.P1725_NumberOfRectanglesThatCanFormTheLargestSquare;

public class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int count = 0;

        for (int[] rect : rectangles) {
            int k = Math.min(rect[0], rect[1]);
            if (k > maxLen) {
                maxLen = k;
                count = 1;
            } else if (k == maxLen) {
                count++;
            }
        }

        return count;
    }
}

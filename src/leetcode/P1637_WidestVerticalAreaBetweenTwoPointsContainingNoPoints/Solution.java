package leetcode.P1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints;

import java.util.Arrays;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xCoords = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xCoords[i] = points[i][0];
        }

        Arrays.sort(xCoords);

        int maxWidth = 0;
        for (int i = 1; i < xCoords.length; i++) {
            maxWidth = Math.max(maxWidth, xCoords[i] - xCoords[i - 1]);
        }

        return maxWidth;
    }
}

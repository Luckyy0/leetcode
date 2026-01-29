package leetcode.P1274_NumberOfShipsInARectangle;

// This is Sea's API interface.
// You should not implement it, or speculate about its implementation
class Sea {
    public boolean hasShips(int[] topRight, int[] bottomLeft) {
        return false;
    }
}

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        // Unpack coordinates
        int top = topRight[1];
        int right = topRight[0];
        int bottom = bottomLeft[1];
        int left = bottomLeft[0];

        // Check validity
        if (bottom > top || left > right)
            return 0;

        // Base API check
        // If no ships in this range, return 0 immediately (pruning)
        if (!sea.hasShips(topRight, bottomLeft))
            return 0;

        // Base case: Single point
        if (top == bottom && left == right)
            return 1;

        // Divide
        int midX = (left + right) / 2;
        int midY = (top + bottom) / 2;

        // Four quadrants
        // 1. Bottom-Left: (midY, midX) - (bottom, left) -- inclusive ranges
        // TopRight: [midX, midY], BottomLeft: [left, bottom]
        int q1 = countShips(sea, new int[] { midX, midY }, new int[] { left, bottom });

        // 2. Bottom-Right: TopRight: [right, midY], BottomLeft: [midX+1, bottom]
        int q2 = countShips(sea, new int[] { right, midY }, new int[] { midX + 1, bottom });

        // 3. Top-Left: TopRight: [midX, top], BottomLeft: [left, midY+1]
        int q3 = countShips(sea, new int[] { midX, top }, new int[] { left, midY + 1 });

        // 4. Top-Right: TopRight: [right, top], BottomLeft: [midX+1, midY+1]
        int q4 = countShips(sea, new int[] { right, top }, new int[] { midX + 1, midY + 1 });

        return q1 + q2 + q3 + q4;
    }
}

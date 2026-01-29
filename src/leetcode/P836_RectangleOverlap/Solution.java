package leetcode.P836_RectangleOverlap;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // [x1, y1, x2, y2]
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) &&
                Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }
}

package leetcode.P699_FallingSquares;

import java.util.ArrayList;
import java.util.List;

class Solution {
    class Interval {
        int left, right, height;

        Interval(int l, int r, int h) {
            left = l;
            right = r;
            height = h;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int h = 0;

        for (int[] p : positions) {
            int left = p[0], size = p[1], right = left + size;
            int baseHeight = 0;

            // Check overlap with existing intervals
            // Kiểm tra sự chồng chéo với các khoảng hiện có
            for (Interval i : intervals) {
                if (i.left < right && i.right > left) {
                    baseHeight = Math.max(baseHeight, i.height);
                }
            }

            int currentHeight = baseHeight + size;
            intervals.add(new Interval(left, right, currentHeight));
            h = Math.max(h, currentHeight);
            res.add(h);
        }

        return res;
    }
}

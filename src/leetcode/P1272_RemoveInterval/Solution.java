package leetcode.P1272_RemoveInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        int removeStart = toBeRemoved[0];
        int removeEnd = toBeRemoved[1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (end <= removeStart || start >= removeEnd) {
                result.add(Arrays.asList(start, end));
            } else {
                if (start < removeStart) {
                    result.add(Arrays.asList(start, removeStart));
                }
                if (end > removeEnd) {
                    result.add(Arrays.asList(removeEnd, end));
                }
            }
        }

        return result;
    }
}

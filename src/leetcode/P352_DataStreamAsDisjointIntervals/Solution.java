package leetcode.P352_DataStreamAsDisjointIntervals;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    /**
     * Problem 352: Data Stream as Disjoint Intervals
     * Approach: TreeMap
     * 
     * Time Complexity: addNum O(log K), getIntervals O(K)
     * Space Complexity: O(K)
     */
    public static class SummaryRanges {
        TreeMap<Integer, int[]> map;

        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int value) {
            if (map.containsKey(value))
                return;

            Integer lowerKey = map.lowerKey(value);
            Integer higherKey = map.higherKey(value);

            // Check overlaps/merges
            if (lowerKey != null && higherKey != null &&
                    map.get(lowerKey)[1] == value - 1 && higherKey == value + 1) {
                // Bridge lower and higher: [1, 1] + 2 + [3, 3] -> [1, 3]
                map.get(lowerKey)[1] = map.get(higherKey)[1];
                map.remove(higherKey);
            } else if (lowerKey != null && map.get(lowerKey)[1] >= value) {
                // Value already covered in lower interval [1, 3] + 2 -> [1, 3]
                return;
            } else if (lowerKey != null && map.get(lowerKey)[1] == value - 1) {
                // Extend lower: [1, 1] + 2 -> [1, 2]
                map.get(lowerKey)[1] = value;
            } else if (higherKey != null && higherKey == value + 1) {
                // Extend higher: 2 + [3, 3] -> [2, 3]
                int[] higher = map.get(higherKey);
                map.remove(higherKey);
                map.put(value, new int[] { value, higher[1] });
                // Wait, use higher[1] as end.
            } else {
                // Isolated
                map.put(value, new int[] { value, value });
            }
        }

        public int[][] getIntervals() {
            int[][] res = new int[map.size()][2];
            int i = 0;
            for (int[] interval : map.values()) {
                res[i++] = interval;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();

        sr.addNum(1);
        printIntervals(sr); // [1, 1]

        sr.addNum(3);
        printIntervals(sr); // [1, 1], [3, 3]

        sr.addNum(7);
        printIntervals(sr); // [1, 1], [3, 3], [7, 7]

        sr.addNum(2);
        printIntervals(sr); // [1, 3], [7, 7]

        sr.addNum(6);
        printIntervals(sr); // [1, 3], [6, 7]
    }

    private static void printIntervals(SummaryRanges sr) {
        int[][] res = sr.getIntervals();
        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            System.out.print(Arrays.toString(res[i]));
            if (i < res.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}

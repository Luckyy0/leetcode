package leet_code.Problem_352_Hard_Data_Stream_As_Disjoint_Intervals;

import java.util.TreeMap;
import java.util.Arrays;

public class SummaryRanges {

    // Map: start -> [start, end]
    private TreeMap<Integer, int[]> treeMap;

    /**
     * Data Stream as Disjoint Intervals.
     * Uses TreeMap for O(log N) updates.
     * Time: O(log N) for addNum, O(N) for getIntervals.
     * Space: O(N).
     * 
     * Luồng Dữ liệu dưới dạng các Khoảng Rời rạc.
     * Sử dụng TreeMap để cập nhật trong O(log N).
     */
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int value) {
        if (treeMap.containsKey(value))
            return;

        Integer leftKey = treeMap.floorKey(value);
        Integer rightKey = treeMap.higherKey(value);

        if (leftKey != null && rightKey != null && treeMap.get(leftKey)[1] + 1 == value
                && treeMap.get(rightKey)[0] - 1 == value) {
            // Case 1: Merge both
            treeMap.get(leftKey)[1] = treeMap.get(rightKey)[1];
            treeMap.remove(rightKey);
        } else if (leftKey != null && treeMap.get(leftKey)[1] + 1 >= value) {
            // Case 2: Already covered or extends left
            treeMap.get(leftKey)[1] = Math.max(treeMap.get(leftKey)[1], value);
        } else if (rightKey != null && treeMap.get(rightKey)[0] - 1 == value) {
            // Case 3: Extends right
            treeMap.put(value, new int[] { value, treeMap.get(rightKey)[1] });
            treeMap.remove(rightKey);
        } else {
            // Case 4: Isolated
            treeMap.put(value, new int[] { value, value });
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treeMap.size()][2];
        int i = 0;
        for (int[] interval : treeMap.values()) {
            res[i++] = interval;
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        System.out.println("Intervals: " + Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 1]]
        summaryRanges.addNum(3);
        System.out.println("Intervals: " + Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 1], [3, 3]]
        summaryRanges.addNum(7);
        System.out.println("Intervals: " + Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 1], [3, 3], [7,
                                                                                               // 7]]
        summaryRanges.addNum(2);
        System.out.println("Intervals: " + Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 3], [7, 7]]
        summaryRanges.addNum(6);
        System.out.println("Intervals: " + Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 3], [6, 7]]
    }
}

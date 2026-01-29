package leetcode.P632_SmallestRangeCoveringElementsFromKLists;

import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min Heap stores [value, list_index, element_index]
        // Min Heap lưu trữ [giá trị, chỉ mục danh sách, chỉ mục phần tử]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int maxVal = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        int minRangeStart = 0;
        int n = nums.size();

        // Init heap
        for (int i = 0; i < n; i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[] { val, i, 0 });
            maxVal = Math.max(maxVal, val);
        }

        while (pq.size() == n) {
            int[] curr = pq.poll();
            int minVal = curr[0];
            int row = curr[1];
            int col = curr[2];

            // Update range
            if (maxVal - minVal < minRange) {
                minRange = maxVal - minVal;
                minRangeStart = minVal;
            }

            // Try to add next element from the same list
            if (col + 1 < nums.get(row).size()) {
                int nextVal = nums.get(row).get(col + 1);
                pq.offer(new int[] { nextVal, row, col + 1 });
                maxVal = Math.max(maxVal, nextVal);
            }
        }

        return new int[] { minRangeStart, minRangeStart + minRange };
    }
}

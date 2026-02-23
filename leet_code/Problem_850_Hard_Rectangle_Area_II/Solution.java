package leet_code.Problem_850_Hard_Rectangle_Area_II;

import java.util.*;

/**
 * Problem 850: Rectangle Area II
 * https://leetcode.com/problems/rectangle-area-ii/
 */
public class Solution {

    /**
     * Calculates the total area covered by rectangles.
     * Strategy: Sweep Line algorithm. We process vertical boundaries
     * (x-coordinates)
     * and calculate the vertical length covered by active rectangles for each
     * strip.
     * 
     * @param rectangles 2D array [x1, y1, x2, y2].
     * @return Total area modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Thu thập tất cả các biên dọc (x1 là điểm vào, x2 là điểm ra).
     *         2. Sắp xếp các biên này theo tọa độ x.
     *         3. Một đường quét dọc đi từ trái sang phải qua các tọa độ x.
     *         Giữa hai tọa độ x liên tiếp, ta tính tổng chiều cao (hợp của các đoạn
     *         y)
     *         đang được bao phủ bởi các hình chữ nhật "hoạt động".
     *         4. Diện tích của dải = (x_tiếp_theo - x_hiện_tại) * tổng_chiều_cao_y.
     */
    public int rectangleArea(int[][] rectangles) {
        int OPEN = 0;
        int CLOSE = 1;
        int[][] events = new int[rectangles.length * 2][4];

        int t = 0;
        for (int[] r : rectangles) {
            // event: {x, type, y1, y2}
            events[t++] = new int[] { r[0], OPEN, r[1], r[3] };
            events[t++] = new int[] { r[2], CLOSE, r[1], r[3] };
        }

        // Sort events by x-coordinate
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> active = new ArrayList<>();
        long totalArea = 0;
        int prevX = events[0][0];
        long MOD = 1_000_000_007;

        for (int[] event : events) {
            int currX = event[0];
            int type = event[1];
            int y1 = event[2];
            int y2 = event[3];

            // Calculate area of the vertical strip between prevX and currX
            if (currX > prevX) {
                totalArea = (totalArea + calculateYCover(active) * (currX - prevX)) % MOD;
            }

            // Update active rectangles
            if (type == OPEN) {
                active.add(new int[] { y1, y2 });
            } else {
                for (int i = 0; i < active.size(); i++) {
                    if (active.get(i)[0] == y1 && active.get(i)[1] == y2) {
                        active.remove(i);
                        break;
                    }
                }
            }
            prevX = currX;
        }

        return (int) totalArea;
    }

    /**
     * Calculates the union length of y-intervals currently active.
     */
    private long calculateYCover(List<int[]> active) {
        if (active.isEmpty())
            return 0;

        // Sort intervals by their starting y
        active.sort((a, b) -> Integer.compare(a[0], b[0]));

        long totalLen = 0;
        int curStart = -1;
        int curEnd = -1;

        for (int[] interval : active) {
            if (interval[0] > curEnd) {
                // New non-overlapping interval
                totalLen += (curEnd - curStart);
                curStart = interval[0];
                curEnd = interval[1];
            } else {
                // Extend current end if needed
                curEnd = Math.max(curEnd, interval[1]);
            }
        }
        // Add the last segment
        totalLen += (curEnd - curStart);

        return totalLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] r1 = { { 0, 0, 2, 2 }, { 1, 0, 2, 3 }, { 1, 0, 3, 1 } };
        System.out.println("Area: " + sol.rectangleArea(r1)); // 6

        int[][] r2 = { { 0, 0, 1000000000, 1000000000 } };
        System.out.println("Area: " + sol.rectangleArea(r2)); // 49
    }
}

package leet_code.Problem_986_Medium_Interval_List_Intersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 986: Interval List Intersections
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class Solution {

    /**
     * Finds the intersection of two lists of disjoint, sorted intervals.
     * Strategy: Two Pointers.
     * 
     * @param firstList  The first list of intervals.
     * @param secondList The second list of intervals.
     * @return An array containing the intersections.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt đồng thời qua cả `firstList` và `secondList` sử dụng hai con
     *         trỏ `i` và `j`.
     *         2. Tại mỗi bước xét đoạn `A = firstList[i]` và `B = secondList[j]`:
     *         - Khu vực giao nhau (nếu có) sẽ bắt đầu tại `start = max(A.start,
     *         B.start)`
     *         - Khu vực giao nhau kết thúc tại `end = min(A.end, B.end)`
     *         - Kiểm tra xem điều kiện `start <= end` có đúng không. Nếu có, ta lấy
     *         được đoạn giao `[start, end]`.
     *         3. Do các danh sách đã được sắp xếp và rời rạc, ta sẽ tịnh tiến con
     *         trỏ của danh sách có điểm kết thúc NHỎ HƠN.
     *         Nguyên nhân là phần tử có điểm kết thúc nhỏ hơn sẽ không bao giờ có
     *         thể tạo giao cắt thêm với bất kỳ đoạn nào ở phía sau danh sách kia.
     *         Nó đã được tận dụng "hết mức".
     *         - Nếu `firstList[i][1] < secondList[j][1]`, thì `i++`.
     *         - Nếu không `j++`.
     *         4. Tiếp tục quá trình cho đến khi một trong hai con trỏ vượt độ dài
     *         của danh sách tương ứng.
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            // Calculate start and end bounds of intersection
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            // If they intersect, add the intersection to results
            if (start <= end) {
                intersections.add(new int[] { start, end });
            }

            // Move the pointer whichever ends earlier
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert the list of intersected arrays to an array
        return intersections.toArray(new int[intersections.size()][]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

        int[][] result = sol.intervalIntersection(firstList, secondList);
        System.out.println("Result: " + Arrays.deepToString(result));
        // Result: [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]
    }
}

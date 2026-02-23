package leet_code.Problem_406_Medium_Queue_Reconstruction_by_Height;

import java.util.*;

public class Solution_GreedySort {

    /**
     * Reconstructs the queue based on height and k-count.
     * Strategy: Sort by h descending, then k ascending, then insert at index k.
     * Time: O(N^2), Space: O(N).
     * 
     * Tái cấu trúc hàng đợi dựa trên chiều cao và số lượng k.
     * Chiến lược: Sắp xếp theo h giảm dần, k tăng dần, sau đó chèn tại chỉ số k.
     */
    public int[][] reconstructQueue(int[][] people) {
        // Sort: h desc, k asc
        // Sắp xếp: h giảm, k tăng
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            // Insert at index k
            // Chèn tại chỉ số k
            res.add(p[1], p);
        }

        return res.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        Solution_GreedySort solution = new Solution_GreedySort();

        // Test Case 1
        int[][] p1 = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        int[][] res1 = solution.reconstructQueue(p1);
        System.out.println("Result 1: " + Arrays.deepToString(res1));
    }
}

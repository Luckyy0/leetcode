package leet_code.Problem_947_Medium_Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.*;

/**
 * Problem 947: Most Stones Removed with Same Row or Column
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class Solution {

    /**
     * Finds the maximum number of stones that can be removed.
     * Strategy: Union-Find (DSU) to count Connected Components.
     * 
     * @param stones 2D array of stone coordinates.
     * @return Maximum removed stones.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bài toán có thể được mô hình hóa dưới dạng đồ thị:
     *         - Mỗi viên đá là một cạnh nối "Row Node" và "Column Node".
     *         - Các viên đá thuộc cùng một hàng hoặc cùng một cột sẽ liên kết với
     *         nhau, tạo thành các Thành phần Liên thông (Connected Components).
     *         2. Trong mỗi thành phần liên thông gồm `k` viên đá (hoặc `k` cặp
     *         hàng-cột liên kết),
     *         ta luôn có thể tìm ra thứ tự xóa sao cho xóa được tối đa `k-1` viên
     *         đá, giữ lại 1 viên "gốc".
     *         3. Số lượng đá tối đa có thể xóa = (Tổng số đá) - (Số lượng thành
     *         phần liên thông).
     *         4. Sử dụng Union-Find để nhóm các chỉ số hàng và cột lại với nhau.
     *         - Vì tọa độ x, y <= 10000, ta có thể dùng một mảng cha `parent` kích
     *         thước khoảng 20002.
     *         - Chỉ số hàng `x` sử dụng trực tiếp `0..10000`.
     *         - Chỉ số cột `y` sẽ được ánh xạ thành `y + 10001` để tránh trùng với
     *         hàng.
     *         5. Duyệt qua từng viên đá (x, y), thực hiện `union(x, y + 10001)`.
     *         6. Sau khi hợp nhất, đếm số lượng "root" riêng biệt của các viên đá.
     *         Đó chính là số lượng thành phần liên thông.
     */
    public int removeStones(int[][] stones) {
        int n = stones.length;

        // Max coordinate is 10000.
        // Row indices: 0 to 10000
        // Col indices: 10001 to 20001
        int range = 20002;
        int[] parent = new int[range];

        // Initially, each node is its own parent
        for (int i = 0; i < range; i++) {
            parent[i] = i;
        }

        // Union row index and col index for each stone
        for (int[] stone : stones) {
            union(parent, stone[0], stone[1] + 10001);
        }

        // Count number of unique Connected Components formed by stones
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            // Find the root of the row index (which is now connected to col index)
            uniqueRoots.add(find(parent, stone[0]));
        }

        // Result is Total Stones - Number of Connected Components
        return n - uniqueRoots.size();
    }

    // Find with Path Compression
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    // Union two sets
    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] s1 = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println("Result: " + sol.removeStones(s1)); // 5

        int[][] s2 = { { 0, 0 }, { 0, 2 }, { 1, 1 }, { 2, 0 }, { 2, 2 } };
        System.out.println("Result: " + sol.removeStones(s2)); // 3

        int[][] s3 = { { 0, 0 } };
        System.out.println("Result: " + sol.removeStones(s3)); // 0
    }
}

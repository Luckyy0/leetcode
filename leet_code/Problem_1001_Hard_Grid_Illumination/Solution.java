package leet_code.Problem_1001_Hard_Grid_Illumination;

import java.util.*;

/**
 * Problem 1001: Grid Illumination
 * https://leetcode.com/problems/grid-illumination/
 */
public class Solution {

    /**
     * Determines if given queries on a grid are illuminated based on lamp
     * placement.
     * Strategy: Coordinate Hashing & Line Mapping.
     * 
     * @param n       Size of the grid (n x n).
     * @param lamps   2D array of coordinates where lamps are placed.
     * @param queries 2D array of coordinates to query for illumination.
     * @return Array of 1s (illuminated) or 0s (not illuminated).
     * 
     *         Tóm tắt chiến lược:
     *         1. Lưới N x N có thể lên tới 10^9 x 10^9, quá khủng khiếp để có thể
     *         dùng mảng 2D biểu diễn trực tiếp lưới.
     *         2. Nhận xét: Một bóng đèn chỉ có vùng ảnh hưởng trực tiếp trên 4 trục
     *         đường thẳng:
     *         - Cùng Hàng: r
     *         - Cùng Cột: c
     *         - Cùng đường chéo chính: r - c
     *         - Cùng đường chéo phụ: r + c
     *         3. Do đó, ta chỉ cần duy trì 4 cái `HashMap` để đếm số lượng bóng đèn
     *         chiếu vào mỗi "trục" cụ thể.
     *         Ví dụ: `rowMap.get(0) = 2` tức là dọc theo Hàng thứ 0 có 2 bóng đèn
     *         đang bật.
     *         4. Dùng thêm một cái `HashSet<Long>` để chứa tọa độ CHÍNH XÁC của các
     *         bóng đèn đang hoạt động.
     *         Do N bé hơn bằng 10^9, ta ép tọa độ `[r, c]` thành một giá trị `long`
     *         DUY NHẤT bằng công thức: `(long)r * n + c`.
     *         Lưu ý: Một tọa độ có thể bị gắn cờ làm đèn nhiều lần trong mảng gốc,
     *         ta dùng Hash Set để loại bỏ đèn chập vòng lặp (vì đèn đã sáng thì đè
     *         bao nhiêu chiếc vô cũng không quan trọng, nhưng lúc xóa chỉ làm 1
     *         lần).
     *         5. Khi nhận một `query[qr, qc]`:
     *         - Một ô được Chiếu Sáng (kết quả 1) chỉ khi 1 trong 4 HashMaps tại
     *         tọa độ của nó có giá trị > 0. Ngược lại là 0.
     *         - Lập tức tắt các đèn (nếu có) nằm trong khu vực 3x3 quanh `query[qr,
     *         qc]`.
     *         - Duyệt vòng lặp 3x3: Nếu Set `activeLamps` có chứa khu vực đó, CHỨNG
     *         TỎ có CÓ đèn! Xóa bóng đèn đó khỏi Set, ĐỒNG THỜI rút đi số lượng
     *         chiếu sáng 1 đơn vị trên TẤT CẢ 4 Maps tại vị trí đã gỡ đèn.
     */
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        // Maps to track illumination counts
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> diag1Map = new HashMap<>(); // Major diagonal
        Map<Integer, Integer> diag2Map = new HashMap<>(); // Minor diagonal

        // Exact active lamp positions
        Set<Long> lampSet = new HashSet<>();

        // Step 1: Initialize illumination
        for (int[] lamp : lamps) {
            int r = lamp[0];
            int c = lamp[1];
            // Encode 2D coordinate into a unique 1D long
            long hash = (long) r * n + c;

            // Only add if there isn't already a lamp here (handle duplicate lamps in input)
            if (lampSet.add(hash)) {
                rowMap.put(r, rowMap.getOrDefault(r, 0) + 1);
                colMap.put(c, colMap.getOrDefault(c, 0) + 1);
                // Diagonal r-c is constant along major diagonal
                diag1Map.put(r - c, diag1Map.getOrDefault(r - c, 0) + 1);
                // Diagonal r+c is constant along minor diagonal
                diag2Map.put(r + c, diag2Map.getOrDefault(r + c, 0) + 1);
            }
        }

        int[] ans = new int[queries.length];

        // Step 2: Answer queries and turn off lamps
        for (int i = 0; i < queries.length; i++) {
            int qr = queries[i][0];
            int qc = queries[i][1];

            // Query logic: illuminated if any line covering the cell has >0 lamps
            if (rowMap.getOrDefault(qr, 0) > 0 ||
                    colMap.getOrDefault(qc, 0) > 0 ||
                    diag1Map.getOrDefault(qr - qc, 0) > 0 ||
                    diag2Map.getOrDefault(qr + qc, 0) > 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }

            // Turn-off logic: 3x3 area around the query
            for (int r = qr - 1; r <= qr + 1; r++) {
                for (int c = qc - 1; c <= qc + 1; c++) {
                    // Check bounds
                    if (r >= 0 && r < n && c >= 0 && c < n) {
                        long hash = (long) r * n + c;
                        // If there is an active lamp here, remove it and decrement maps
                        if (lampSet.remove(hash)) {
                            rowMap.put(r, rowMap.get(r) - 1);
                            colMap.put(c, colMap.get(c) - 1);
                            diag1Map.put(r - c, diag1Map.get(r - c) - 1);
                            diag2Map.put(r + c, diag2Map.get(r + c) - 1);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 5;
        int[][] lamps1 = { { 0, 0 }, { 4, 4 } };
        int[][] queries1 = { { 1, 1 }, { 1, 0 } };
        int[] result1 = sol.gridIllumination(n1, lamps1, queries1);
        System.out.println("Result 1: " + Arrays.toString(result1)); // [1, 0]

        int n2 = 5;
        int[][] lamps2 = { { 0, 0 }, { 0, 4 } };
        int[][] queries2 = { { 0, 4 }, { 0, 1 }, { 1, 4 } };
        int[] result2 = sol.gridIllumination(n2, lamps2, queries2);
        System.out.println("Result 2: " + Arrays.toString(result2)); // [1, 1, 0]
    }
}

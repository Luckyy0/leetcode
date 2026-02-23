package leet_code.Problem_296_Hard_Best_Meeting_Point;

import java.util.ArrayList;
import java.util.List;

public class Solution_Median {

    /**
     * Finds minimal total travel distance.
     * Uses Median property for Manhattan Distance (Separable 1D problems).
     * Time: O(M*N), Space: O(M+N).
     * 
     * Tìm tổng khoảng cách di chuyển tối thiểu.
     * Sử dụng tính chất Trung vị cho Khoảng cách Manhattan (Các bài toán 1D tách
     * biệt).
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        // Collect rows (already sorted by natural scan order)
        // Thu thập hàng (đã được sắp xếp theo thứ tự quét tự nhiên)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }

        // Collect cols (scan by column to get them sorted without explicit sort)
        // Thu thập cột (quét theo cột để lấy chúng theo thứ tự đã sắp xếp mà không cần
        // sort)
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }

        return getMinDist(rows) + getMinDist(cols);
    }

    private int getMinDist(List<Integer> list) {
        int dist = 0;
        int left = 0;
        int right = list.size() - 1;

        // The median minimizes sum of absolute differences.
        // Sum of (|p_i - median|) is equal to moving inwards from both ends.
        // Trung vị giảm thiểu tổng các chênh lệch tuyệt đối.
        // Tổng của (|p_i - median|) bằng với việc di chuyển vào trong từ hai đầu.
        while (left < right) {
            dist += list.get(right) - list.get(left);
            left++;
            right--;
        }
        return dist;
    }

    public static void main(String[] args) {
        Solution_Median solution = new Solution_Median();

        // Test Case: Explain example 1
        int[][] grid = {
                { 1, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 }
        };
        System.out.println("Min Dist: " + solution.minTotalDistance(grid)); // 6
    }
}

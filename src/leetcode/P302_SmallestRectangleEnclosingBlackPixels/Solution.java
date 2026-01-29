package leetcode.P302_SmallestRectangleEnclosingBlackPixels;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 302: Smallest Rectangle Enclosing Black Pixels
     * Approach: Binary Search on Boundaries
     * 
     * Theoretical Basis:
     * - Connected region projects to continuous intervals on x and y axes.
     * - BS to find first/last occurrence.
     * 
     * Time Complexity: O(N log M + M log N)
     * Space Complexity: O(1)
     */
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;

        int top = searchRows(image, 0, x, true);
        int bottom = searchRows(image, x + 1, m, false);
        int left = searchCols(image, 0, y, top, bottom, true);
        int right = searchCols(image, y + 1, n, top, bottom, false);

        return (bottom - top) * (right - left);
    }

    // Find boundary row
    // opt=true: find first '1' in [min, max). (Top)
    // opt=false: find first '0' (all 0s row) in [min, max). (Bottom boundary + 1)
    private int searchRows(char[][] image, int min, int max, boolean opt) {
        int i = min, j = max;
        while (i < j) {
            int mid = i + (j - i) / 2;
            boolean hasBlack = false;
            for (int k = 0; k < image[0].length; k++) {
                if (image[mid][k] == '1') {
                    hasBlack = true;
                    break;
                }
            }

            // Logic:
            // Top (opt=true): We want first 1. If mid has 1, answer is <= mid. j = mid.
            // Bottom (opt=false): We want first 0 after the block of 1s. If mid has 1,
            // answer is > mid. i = mid + 1.
            if (opt) {
                if (hasBlack)
                    j = mid;
                else
                    i = mid + 1;
            } else {
                if (hasBlack)
                    i = mid + 1;
                else
                    j = mid;
            }
        }
        return i;
    }

    // Find boundary col
    private int searchCols(char[][] image, int min, int max, int top, int bottom, boolean opt) {
        int i = min, j = max;
        while (i < j) {
            int mid = i + (j - i) / 2;
            boolean hasBlack = false;
            // Only check within known valid rows [top, bottom)
            for (int k = top; k < bottom; k++) {
                if (image[k][mid] == '1') {
                    hasBlack = true;
                    break;
                }
            }

            if (opt) {
                if (hasBlack)
                    j = mid;
                else
                    i = mid + 1;
            } else {
                if (hasBlack)
                    i = mid + 1;
                else
                    j = mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Input: image = [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]], x =
        // 0, y = 2
        char[][] img = {
                { '0', '0', '1', '0' },
                { '0', '1', '1', '0' },
                { '0', '1', '0', '0' }
        };
        // Black pixels: (0,2), (1,1), (1,2), (2,1)
        // Rows: 0, 1, 2. Top=0, BottomBound=3 (row index 3 is empty or out).
        // Cols: 1, 2. Left=1, RightBound=3.
        // H = 3, W = 2. Area = 6.

        runTest(solution, img, 0, 2, 6);
    }

    private static void runTest(Solution s, char[][] img, int x, int y, int expected) {
        int area = s.minArea(img, x, y);
        System.out.println("Area: " + area + " (Expected: " + expected + ")");
        if (area == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

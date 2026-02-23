package leet_code.Problem_533_Medium_Lonely_Pixel_II;

import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Finds lonely pixels II.
     * Strategy: Group rows by string content. Check counts.
     * Time: O(M*N), Space: O(M*N).
     */
    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length;
        int n = picture[0].length;

        // Count 'B's in each column
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    colCount[j]++;
                }
            }
        }

        // Group rows by content
        Map<String, Integer> rowMap = new HashMap<>();
        for (char[] row : picture) {
            String s = new String(row);
            rowMap.put(s, rowMap.getOrDefault(s, 0) + 1);
        }

        int result = 0;

        for (String rowStr : rowMap.keySet()) {
            // Check if we have exactly target identical rows
            if (rowMap.get(rowStr) != target) {
                continue;
            }

            // Check if row has exactly target 'B's (Rule 2a)
            int rowBCount = 0;
            for (int j = 0; j < n; j++) {
                if (rowStr.charAt(j) == 'B') {
                    rowBCount++;
                }
            }

            if (rowBCount != target) {
                continue;
            }

            // Check Rule 2b and Rule 3 (implied)
            // For each column j where row has 'B', check if colCount[j] == target
            for (int j = 0; j < n; j++) {
                if (rowStr.charAt(j) == 'B') {
                    if (colCount[j] == target) {
                        // All 'B's in this column must come from these 'target' identical rows
                        // because sum is target and we have target rows having 'B'.
                        // We add target to result?
                        // Wait, we add number of pixels.
                        // The loop iterates over row GROUPS.
                        // If this group is valid for column j, then ALL 'target' rows contribute 1
                        // pixel.
                        // So we add 'target' pixels.
                        // BUT, we sum up over all valid columns for this row group.
                        // So for each valid column, add 'target'.
                        result += target;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();
        char[][] picture = {
                { 'W', 'B', 'W', 'B', 'B', 'W' },
                { 'W', 'B', 'W', 'B', 'B', 'W' },
                { 'W', 'B', 'W', 'B', 'B', 'W' },
                { 'W', 'W', 'B', 'W', 'B', 'W' }
        };
        int target = 3;
        System.out.println("Result: " + solution.findBlackPixel(picture, target)); // 6
    }
}

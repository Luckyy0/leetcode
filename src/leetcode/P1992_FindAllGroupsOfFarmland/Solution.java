package leetcode.P1992_FindAllGroupsOfFarmland;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    // Check if top-left
                    if (i > 0 && land[i - 1][j] == 1)
                        continue;
                    if (j > 0 && land[i][j - 1] == 1)
                        continue;

                    // Found top-left. Determine scope.
                    // Expand right
                    int c2 = j;
                    while (c2 + 1 < n && land[i][c2 + 1] == 1) {
                        c2++;
                    }
                    // Expand down
                    int r2 = i;
                    while (r2 + 1 < m && land[r2 + 1][j] == 1) {
                        r2++;
                    }

                    res.add(new int[] { i, j, r2, c2 });
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}

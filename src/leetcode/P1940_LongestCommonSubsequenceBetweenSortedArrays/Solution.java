package leetcode.P1940_LongestCommonSubsequenceBetweenSortedArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        // Values usually up to 100 per Leetcode typical constraint for this ID range
        // But if general, Map count. Since output sorted, TreeMap or just list count.
        // Assuming values <= 100.
        // Actually P1940: "1 <= nums[i][j] <= 100". constraint check.

        int[] count = new int[101];
        for (int[] arr : arrays) {
            for (int val : arr) {
                count[val]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int n = arrays.length;
        for (int i = 1; i <= 100; i++) {
            if (count[i] == n) {
                ans.add(i);
            }
        }
        return ans;
    }
}

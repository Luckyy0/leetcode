package leetcode.P1090_LargestValuesFromLabels;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int n = values.length;
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }

        Arrays.sort(items, (a, b) -> b[0] - a[0]); // Sort by value desc

        Map<Integer, Integer> counts = new HashMap<>();
        int sum = 0;
        int taken = 0;

        for (int[] item : items) {
            if (taken >= num_wanted)
                break;

            int val = item[0];
            int label = item[1];

            int used = counts.getOrDefault(label, 0);
            if (used < use_limit) {
                sum += val;
                counts.put(label, used + 1);
                taken++;
            }
        }

        return sum;
    }
}

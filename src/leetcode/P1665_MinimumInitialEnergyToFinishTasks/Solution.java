package leetcode.P1665_MinimumInitialEnergyToFinishTasks;

import java.util.Arrays;

public class Solution {
    public int minimumEffort(int[][] tasks) {
        // Sort by difference (minimum - actual) descending
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int ans = 0;
        int currentEnergy = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if (currentEnergy < minimum) {
                int add = minimum - currentEnergy;
                ans += add;
                currentEnergy += add;
            }

            currentEnergy -= actual;
        }

        return ans;
    }
}

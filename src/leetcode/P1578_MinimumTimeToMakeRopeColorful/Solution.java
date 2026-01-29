package leetcode.P1578_MinimumTimeToMakeRopeColorful;

public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int n = colors.length();
        int currentMax = 0;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            // If it's the first element or same color as previous
            if (i > 0 && colors.charAt(i) == colors.charAt(i - 1)) {
                currentSum += neededTime[i];
                currentMax = Math.max(currentMax, neededTime[i]);
            } else {
                // New color group starts
                // Finalize previous group
                if (i > 0) {
                    totalCost += (currentSum - currentMax);
                }

                // Start new group
                currentSum = neededTime[i];
                currentMax = neededTime[i];
            }
        }

        // Finalize the last group
        totalCost += (currentSum - currentMax);

        return totalCost;
    }
}

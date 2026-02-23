package leet_code.Problem_624_Medium_Maximum_Distance_in_Arrays;

import java.util.List;

public class Solution_Greedy {

    /**
     * Finds the maximum distance between two integers from different arrays.
     * Strategy: Single pass tracking of global min and max.
     * Time: O(M), Space: O(1).
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int currMin = curr.get(0);
            int currMax = curr.get(curr.size() - 1);

            // Step 1: Calculate potential max distance using current vs global extremes
            // Note: This ensures min and max are from different arrays
            res = Math.max(res, Math.abs(currMax - minVal));
            res = Math.max(res, Math.abs(maxVal - currMin));

            // Step 2: Update global extremes for the next iterations
            minVal = Math.min(minVal, currMin);
            maxVal = Math.max(maxVal, currMax);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        // Example test can be added here with List.of(...)
    }
}

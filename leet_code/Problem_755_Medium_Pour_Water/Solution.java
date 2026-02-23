package leet_code.Problem_755_Medium_Pour_Water;

import java.util.Arrays;

public class Solution {

    /**
     * Simulates pouring water onto terrain.
     * Strategy: Iterate V times, each time scan left then right for a lower spot.
     * Time: O(V * N), Space: O(1).
     */
    public int[] pourWater(int[] heights, int volume, int k) {
        // Iterate for each unit of water
        for (int v = 0; v < volume; v++) {

            // 1. Try moving Left
            int bestL = k;
            for (int i = k - 1; i >= 0; i--) {
                if (heights[i] > heights[i + 1]) {
                    // Wall blocks movement
                    break;
                }
                if (heights[i] < heights[bestL]) {
                    // Found a strictly lower spot
                    bestL = i;
                }
            }

            if (heights[bestL] < heights[k]) {
                heights[bestL]++;
                continue; // Droplet settled
            }

            // 2. Try moving Right
            int bestR = k;
            for (int i = k + 1; i < heights.length; i++) {
                if (heights[i] > heights[i - 1]) {
                    // Wall blocks movement
                    break;
                }
                if (heights[i] < heights[bestR]) {
                    bestR = i;
                }
            }

            if (heights[bestR] < heights[k]) {
                heights[bestR]++;
                continue; // Droplet settled
            }

            // 3. Stay at K
            heights[k]++;
        }

        return heights;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] h1 = { 2, 1, 1, 2, 1, 2, 2 };
        System.out.println("Result 1: " + Arrays.toString(sol.pourWater(h1, 4, 3)));
        // Expected: [2, 2, 2, 3, 2, 2, 2]

        int[] h2 = { 1, 2, 3, 4 };
        System.out.println("Result 2: " + Arrays.toString(sol.pourWater(h2, 2, 2)));
        // Pour at index 2 (val 3). Left is 2. Left is 1. Fills 0. Next fills 0 again?
        // No, fills 0 then next vol fills 1?
        // Let's trace:
        // Drop 1: i=2. L scan: 2(2)<3, 1(2)==2(not<), 0(1)<2. bestL=0. Fill 0.
        // h=[2,2,3,4].
        // Drop 2: i=2. L scan: 2(2)<3, 1(2)==2, 0(2)==2. bestL=2? Wait.
        // i=1: h[1]=2 < bestL(3). bestL=1.
        // i=0: h[0]=2 not < bestL(2). Keep bestL=1.
        // Fill 1. h=[2,3,3,4].
        // Output: [2, 3, 3, 4]
    }
}

package leetcode.P2078_TwoFurthestHousesWithDifferentColors;

public class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        // Case 1: Max distance involving start
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                maxDist = Math.max(maxDist, i);
                break; // Found largest j
            }
        }

        // Case 2: Max distance involving end
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, n - 1 - i);
                break; // Found smallest i
            }
        }

        return maxDist;
    }
}

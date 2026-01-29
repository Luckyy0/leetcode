package leetcode.P765_CouplesHoldingHands;

class Solution {
    public int minSwapsCouples(int[] row) {
        int swaps = 0;
        int n = row.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++)
            pos[row[i]] = i;

        for (int i = 0; i < n; i += 2) {
            int p1 = row[i];
            int p2 = p1 ^ 1; // partner of p1

            if (row[i + 1] != p2) {
                swaps++;
                int currentP2Index = pos[p2];
                int currentNextValue = row[i + 1];

                // Swap
                row[currentP2Index] = currentNextValue;
                row[i + 1] = p2;

                // Update positions
                pos[currentNextValue] = currentP2Index;
                pos[p2] = i + 1;
            }
        }
        return swaps;
    }
}

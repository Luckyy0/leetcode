package leetcode.P1151_MinimumSwapsToGroupAll1sTogether;

class Solution {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int x : data)
            totalOnes += x;

        if (totalOnes <= 1)
            return 0;

        int currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            currentOnes += data[i];
        }

        int maxOnes = currentOnes;
        for (int i = totalOnes; i < data.length; i++) {
            currentOnes -= data[i - totalOnes]; // Remove outgoing
            currentOnes += data[i]; // Add incoming
            maxOnes = Math.max(maxOnes, currentOnes);
        }

        return totalOnes - maxOnes;
    }
}

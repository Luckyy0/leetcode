package leetcode.P1653_MinimumDeletionsToMakeStringBalanced;

public class Solution {
    public int minimumDeletions(String s) {
        int totalA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a')
                totalA++;
        }

        int bCount = 0;
        int minDeletions = totalA; // Initially assume split at 0 (all become b, delete all a)
        int currentA = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                currentA++;
            } else {
                bCount++;
            }
            // Logic: Split AFTER this character
            // Delete b's seen so far (bCount)
            // Delete a's remaining (totalA - currentA)
            minDeletions = Math.min(minDeletions, bCount + (totalA - currentA));
        }

        return minDeletions;
    }
}

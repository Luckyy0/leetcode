package leetcode.P1989_MaximumNumberOfPeopleThatCanBeCaughtInTag;

public class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int n = team.length;
        int i = 0; // Pointer for IT (1)
        int j = 0; // Pointer for Not IT (0)
        int ans = 0;

        while (i < n && j < n) {
            // Find next IT
            while (i < n && team[i] != 1)
                i++;
            // Find next Not IT
            while (j < n && team[j] != 0)
                j++;

            if (i < n && j < n) {
                if (Math.abs(i - j) <= dist) {
                    ans++;
                    i++;
                    j++;
                } else if (i < j) {
                    // IT is too far left. Move IT.
                    i++;
                } else {
                    // Not IT is too far left. Move Not IT.
                    j++;
                }
            }
        }

        return ans;
    }
}

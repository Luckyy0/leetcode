package leetcode.P544_OutputContestMatches;

class Solution {
    public String findContestMatch(int n) {
        String[] team = new String[n];
        for (int i = 1; i <= n; i++) {
            team[i - 1] = String.valueOf(i);
        }

        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                team[i] = "(" + team[i] + "," + team[n - 1 - i] + ")";
            }
            n /= 2;
        }

        return team[0];
    }
}

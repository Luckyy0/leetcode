package leetcode.P1904_TheNumberOfFullRoundsYouHavePlayed;

public class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int start = toMinutes(loginTime);
        int finish = toMinutes(logoutTime);

        if (finish < start) {
            finish += 24 * 60;
        }

        // Round start up to next 15 min mark
        int firstRound = (start + 14) / 15 * 15;
        // Round finish down to prev 15 min mark
        int lastRound = finish / 15 * 15;

        if (lastRound < firstRound)
            return 0;

        return (lastRound - firstRound) / 15;
    }

    private int toMinutes(String s) {
        String[] parts = s.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

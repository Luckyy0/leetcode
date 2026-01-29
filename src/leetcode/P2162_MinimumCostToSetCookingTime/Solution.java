package leetcode.P2162_MinimumCostToSetCookingTime;

public class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minCost = Integer.MAX_VALUE;

        // Candidate 1: Max minutes
        int m1 = targetSeconds / 60;
        int s1 = targetSeconds % 60;
        if (m1 <= 99 && s1 <= 99) {
            minCost = Math.min(minCost, calculate(startAt, moveCost, pushCost, m1, s1));
        }

        // Candidate 2: One less minute, 60 more seconds
        int m2 = m1 - 1;
        int s2 = s1 + 60;
        if (m2 >= 0 && m2 <= 99 && s2 <= 99) {
            minCost = Math.min(minCost, calculate(startAt, moveCost, pushCost, m2, s2));
        }

        return minCost;
    }

    private int calculate(int startAt, int moveCost, int pushCost, int m, int s) {
        // Construct digits. e.g. m=10, s=0 -> "1000"
        // m=0, s=5 -> "5" (leading zeros stripped)
        // Strictly use 4 digit block? No, leading zeros of the 4-digit block are
        // ignored logic.
        // Actually: "10:00" -> 1,0,0,0. "01:00" -> 1,0,0.

        String str = "";
        if (m > 0) {
            str += m;
            if (s < 10)
                str += "0" + s;
            else
                str += s;
        } else {
            str += s;
        }

        // Wait. If m=0, s=5. str="5".
        // If m=0, s=30. str="30".
        // Logic check: "0005" -> "5". "0030" -> "30".
        // My logic above: if m=0, appends s. Is s printed as "5" or "05"?
        // If m=0, we just type seconds. so "5" is correct.
        // What if m=1, s=5? "105". "1:05".
        // My logic: m="1". s < 10 append "05". -> "105". Correct.
        // Correct.

        int curr = startAt;
        int cost = 0;
        for (char c : str.toCharArray()) {
            int digit = c - '0';
            if (digit != curr) {
                cost += moveCost;
                curr = digit;
            }
            cost += pushCost;
        }
        return cost;
    }
}

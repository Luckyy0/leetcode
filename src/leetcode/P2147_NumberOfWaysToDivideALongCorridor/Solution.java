package leetcode.P2147_NumberOfWaysToDivideALongCorridor;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> seats = new ArrayList<>();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seats.add(i);
            }
        }

        int n = seats.size();
        if (n == 0 || n % 2 != 0)
            return 0;

        long ways = 1;
        int MOD = 1_000_000_007;

        // Pairs are (seats[0], seats[1]), (seats[2], seats[3]), ...
        // Gap between pair i and pair i+1 is seats[2*i+2] - seats[2*i+1].

        for (int i = 2; i < n; i += 2) {
            int gap = seats.get(i) - seats.get(i - 1);
            ways = (ways * gap) % MOD;
        }

        return (int) ways;
    }
}

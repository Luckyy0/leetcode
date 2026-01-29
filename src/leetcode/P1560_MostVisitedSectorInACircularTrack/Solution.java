package leetcode.P1560_MostVisitedSectorInACircularTrack;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result = new ArrayList<>();
        int start = rounds[0];
        int end = rounds[rounds.length - 1];

        if (start <= end) {
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        } else {
            // From 1 to end
            for (int i = 1; i <= end; i++) {
                result.add(i);
            }
            // From start to n
            for (int i = start; i <= n; i++) {
                result.add(i);
            }
        }

        return result;
    }
}

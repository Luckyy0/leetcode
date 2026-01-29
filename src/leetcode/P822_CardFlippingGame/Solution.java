package leetcode.P822_CardFlippingGame;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> banned = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                banned.add(fronts[i]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x : fronts) {
            if (!banned.contains(x))
                min = Math.min(min, x);
        }
        for (int x : backs) {
            if (!banned.contains(x))
                min = Math.min(min, x);
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

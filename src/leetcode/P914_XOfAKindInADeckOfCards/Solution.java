package leetcode.P914_XOfAKindInADeckOfCards;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int c : deck)
            count.put(c, count.getOrDefault(c, 0) + 1);

        int g = -1;
        for (int f : count.values()) {
            if (g == -1)
                g = f;
            else
                g = gcd(g, f);
        }

        return g >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

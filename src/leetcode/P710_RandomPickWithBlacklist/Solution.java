package leetcode.P710_RandomPickWithBlacklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class Solution {
    private Map<Integer, Integer> map;
    private int M;
    private Random random;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        M = n - blacklist.length;

        Set<Integer> upperValid = new HashSet<>();
        for (int i = M; i < n; i++)
            upperValid.add(i);

        for (int x : blacklist)
            upperValid.remove(x);

        var iter = upperValid.iterator();
        for (int x : blacklist) {
            if (x < M) {
                map.put(x, iter.next());
            }
        }
    }

    public int pick() {
        int r = random.nextInt(M);
        return map.getOrDefault(r, r);
    }
}

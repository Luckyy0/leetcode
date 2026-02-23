package leet_code.Problem_710_Hard_Random_Pick_with_Blacklist;

import java.util.*;

public class Solution {
    private Map<Integer, Integer> map;
    private Random random;
    private int w; // The boundary of valid pick range [0, w-1]

    /**
     * Strategy: Map blacklist numbers in [0, w-1] to valid numbers in [w, n-1].
     */
    public Solution(int n, int[] blacklist) {
        this.random = new Random();
        this.map = new HashMap<>();
        int bSize = blacklist.length;
        this.w = n - bSize;

        // Use a set to quickly check if a number is in the blacklist
        Set<Integer> topBlacklist = new HashSet<>();
        for (int b : blacklist) {
            if (b >= w) {
                topBlacklist.add(b);
            }
        }

        // Find available targets in [w, n-1] that are NOT in the blacklist
        int last = n - 1;
        for (int b : blacklist) {
            // We only need to map blacklist items that fall within [0, w-1]
            if (b < w) {
                // Find a target position from the end of the range [w, n-1]
                while (topBlacklist.contains(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }
        }
    }

    /**
     * Picks a random number. Time: O(1).
     */
    public int pick() {
        int r = random.nextInt(w);
        // If r is blacklisted, return its mapped valid target
        return map.getOrDefault(r, r);
    }

    public static void main(String[] args) {
        Solution sol = new Solution(7, new int[] { 2, 3, 5 });
        for (int i = 0; i < 10; i++) {
            System.out.print(sol.pick() + " ");
        }
    }
}

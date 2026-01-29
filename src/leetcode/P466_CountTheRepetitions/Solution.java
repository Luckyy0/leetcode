package leetcode.P466_CountTheRepetitions;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 466: Count The Repetitions
     * Approach: Simulation with Cycle Detection
     * 
     * Time Complexity: O(s1.length * s2.length)
     * Space Complexity: O(s2.length)
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length(), len2 = s2.length();
        int count1 = 0, count2 = 0, idx2 = 0;

        // Maps idx2 (index in s2) to [count1, count2]
        Map<Integer, int[]> seen = new HashMap<>();

        while (count1 < n1) {
            count1++;
            for (int i = 0; i < len1; i++) {
                if (s1.charAt(i) == s2.charAt(idx2)) {
                    idx2++;
                    if (idx2 == len2) {
                        idx2 = 0;
                        count2++;
                    }
                }
            }

            if (seen.containsKey(idx2)) {
                int[] prev = seen.get(idx2);
                int prevCount1 = prev[0];
                int prevCount2 = prev[1];

                int cycleLen1 = count1 - prevCount1;
                int cycleCount2 = count2 - prevCount2;

                int remainingBlocks1 = n1 - count1;
                int cycles = remainingBlocks1 / cycleLen1;

                count2 += cycles * cycleCount2;
                count1 += cycles * cycleLen1;
            }
            seen.put(idx2, new int[] { count1, count2 });
        }

        return count2 / n2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // s1="acb", n1=4, s2="ab", n2=2 -> 2
        System.out.println("Result: " + sol.getMaxRepetitions("acb", 4, "ab", 2) + " (Expected: 2)");

        // s1="acb", n1=1, s2="acb", n2=1 -> 1
        System.out.println("Result: " + sol.getMaxRepetitions("acb", 1, "acb", 1) + " (Expected: 1)");
    }
}

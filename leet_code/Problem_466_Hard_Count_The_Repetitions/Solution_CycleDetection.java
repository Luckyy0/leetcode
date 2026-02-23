package leet_code.Problem_466_Hard_Count_The_Repetitions;

import java.util.HashMap;
import java.util.Map;

public class Solution_CycleDetection {

    /**
     * Finds max m such that [s2, n2*m] is subseq of [s1, n1].
     * Strategy: Detect repetition cycle in matching s2 inside s1 copies.
     * Time: O(s1_len * s2_len), Space: O(s2_len).
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        // Maps current index in s2 -> [s1 count, s2 count]
        Map<Integer, int[]> memo = new HashMap<>();

        int s1Count = 0;
        int s2Count = 0;
        int idx = 0; // matching pointer for s2

        while (s1Count < n1) {
            s1Count++;
            for (int i = 0; i < s1Len; i++) {
                if (s1.charAt(i) == s2.charAt(idx)) {
                    idx++;
                    if (idx == s2Len) {
                        idx = 0;
                        s2Count++;
                    }
                }
            }

            // Cycle detection
            if (memo.containsKey(idx)) {
                int[] prev = memo.get(idx);
                int prevS1 = prev[0];
                int prevS2 = prev[1];

                int deltaS1 = s1Count - prevS1;
                int deltaS2 = s2Count - prevS2;

                int remainingS1 = n1 - s1Count;
                int numCycles = remainingS1 / deltaS1;

                s1Count += numCycles * deltaS1;
                s2Count += numCycles * deltaS2;

                // Clear map to avoid hitting the same cycle again
                memo.clear();
            } else {
                memo.put(idx, new int[] { s1Count, s2Count });
            }
        }

        return s2Count / n2;
    }

    public static void main(String[] args) {
        Solution_CycleDetection solution = new Solution_CycleDetection();
        System.out.println("Result: " + solution.getMaxRepetitions("acb", 4, "ab", 2)); // 2
    }
}

package leet_code.Problem_555_Medium_Split_Concatenated_Strings;

public class Solution_GreedyExploration {

    /**
     * Finds the lexicographically largest string after cutting the loop.
     * Strategy: Greedy choice for non-cut strings, exhaustive search for the cut
     * string.
     * Time: O(L^2), Space: O(L).
     */
    public String splitLoopedString(String[] strs) {
        int n = strs.length;
        String[] bestStrs = new String[n];

        // Phase 1: Pre-process non-cut strings greedily
        for (int i = 0; i < n; i++) {
            String s = strs[i];
            String r = new StringBuilder(s).reverse().toString();
            bestStrs[i] = (s.compareTo(r) > 0) ? s : r;
        }

        String maxResult = "";

        // Phase 2: Iterate through each string as the "cut string"
        for (int i = 0; i < n; i++) {
            String s = strs[i];
            String r = new StringBuilder(s).reverse().toString();

            // Middle part of the final concatenation: bestStrs[i+1...n-1] +
            // bestStrs[0...i-1]
            StringBuilder middlePart = new StringBuilder();
            for (int k = i + 1; k < n; k++)
                middlePart.append(bestStrs[k]);
            for (int k = 0; k < i; k++)
                middlePart.append(bestStrs[k]);
            String middle = middlePart.toString();

            // Try all cut points in original string and its reverse
            for (String t : new String[] { s, r }) {
                for (int j = 0; j < t.length(); j++) {
                    // Start from index j, wrap around
                    // Candidate: T[j...end] + Middle + T[0...j-1]
                    String candidate = t.substring(j) + middle + t.substring(0, j);
                    if (candidate.compareTo(maxResult) > 0) {
                        maxResult = candidate;
                    }
                }
            }
        }

        return maxResult;
    }

    public static void main(String[] args) {
        Solution_GreedyExploration solution = new Solution_GreedyExploration();
        String[] strs1 = { "abc", "xyz" };
        System.out.println("Result 1: " + solution.splitLoopedString(strs1)); // "zyxcba"

        String[] strs2 = { "abc" };
        System.out.println("Result 2: " + solution.splitLoopedString(strs2)); // "cba"
    }
}

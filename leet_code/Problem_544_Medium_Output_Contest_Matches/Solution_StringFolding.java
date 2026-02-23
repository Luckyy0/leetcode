package leet_code.Problem_544_Medium_Output_Contest_Matches;

public class Solution_StringFolding {

    /**
     * Outputs contest matches.
     * Strategy: Iterative folding. Pair matches[i] and matches[n-1-i].
     * Time: O(N), Space: O(N).
     */
    public String findContestMatch(int n) {
        String[] matches = new String[n];
        for (int i = 0; i < n; i++) {
            matches[i] = String.valueOf(i + 1);
        }

        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                matches[i] = "(" + matches[i] + "," + matches[n - 1 - i] + ")";
            }
            n /= 2;
        }

        return matches[0];
    }

    public static void main(String[] args) {
        Solution_StringFolding solution = new Solution_StringFolding();
        System.out.println("Result 4: " + solution.findContestMatch(4));
        // "((1,4),(2,3))"
        System.out.println("Result 8: " + solution.findContestMatch(8));
        // "(((1,8),(4,5)),((2,7),(3,6)))"
    }
}

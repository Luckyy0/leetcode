package leet_code.Problem_521_Easy_Longest_Uncommon_Subsequence_I;

public class Solution_Logic {

    /**
     * Finds longest uncommon subsequence.
     * Strategy: If strings equal, -1. Else max length.
     * Time: O(min(len(a), len(b))) for equals check. Space: O(1).
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        Solution_Logic solution = new Solution_Logic();
        System.out.println("Result: " + solution.findLUSlength("aba", "cdc")); // 3
    }
}

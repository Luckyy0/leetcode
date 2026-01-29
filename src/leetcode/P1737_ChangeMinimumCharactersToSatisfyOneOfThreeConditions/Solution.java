package leetcode.P1737_ChangeMinimumCharactersToSatisfyOneOfThreeConditions;

public class Solution {
    public int minCharacters(String a, String b) {
        int[] ca = new int[26];
        int[] cb = new int[26];
        int n = a.length();
        int m = b.length();

        for (char c : a.toCharArray())
            ca[c - 'a']++;
        for (char c : b.toCharArray())
            cb[c - 'a']++;

        int ans = Integer.MAX_VALUE;

        // Condition 3: Distinct letter
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, (n - ca[i]) + (m - cb[i]));
        }

        // Prefix sums for conditions 1 and 2
        // We iterate boundary k from 0 to 24 (representing 'a' to 'y')
        // We want A <= k and B > k (Condition 1)
        // Or B <= k and A > k (Condition 2)

        int prefixA = 0;
        int prefixB = 0;

        for (int i = 0; i < 25; i++) {
            prefixA += ca[i];
            prefixB += cb[i];

            // Condition 1: A <= char(i), B > char(i)
            // Moves = (A_total - A_prefix) + B_prefix
            // A needs to lose elements > i. B needs to lose elements <= i.
            // B elements <= i become > i.
            // A elements > i become <= i.
            ans = Math.min(ans, (n - prefixA) + prefixB);

            // Condition 2: B <= char(i), A > char(i)
            ans = Math.min(ans, (m - prefixB) + prefixA);
        }

        return ans;
    }
}

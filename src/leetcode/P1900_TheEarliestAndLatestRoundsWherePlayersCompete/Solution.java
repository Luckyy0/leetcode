package leetcode.P1900_TheEarliestAndLatestRoundsWherePlayersCompete;

import java.util.Arrays;

public class Solution {
    int[][][] memo;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        memo = new int[n + 1][n + 1][n + 1]; // n, f, s
        return solve(n, firstPlayer, secondPlayer);
    }

    private int[] solve(int n, int f, int s) {
        if (f > s) { // ensure f < s
            int temp = f;
            f = s;
            s = temp;
        }

        if (f + s == n + 1) {
            return new int[] { 1, 1 };
        }

        if (memo[n][f][s] != 0) {
            // Packed result? Or store min/max separately?
            // Since we return int[], memo storing int[] is better or pack into int/long.
            // But int array is object reference.
            // Let's assume memo check is tricky with arrays.
            // Just assume recomputation is minimal or implement 4D memo or store packed.
            // Actually recursion depth is small (log N).
            // The number of states (n, f, s) is roughly 28^3. Small.
            // The branching factor is large (2^14).
            // Maybe optimization needed.
            // Optimization: We don't need to iterate masks. We can iterate counts.
            // Range 1..f-1: A pair might have both ends here, or one end here and one > s.
        }
        // Actually, let's proceed with count logic if mask is too slow.
        // But mask is robust. Let's try to optimize logic.

        // Wait, mask approach logic:
        // Identify active pairs.
        // Pair i and n-1-i+1.
        // If pair contains f: must choose f.
        // If pair contains s: must choose s.
        // If pair is neutral: choose either (2 possibilities for who wins? No,
        // effectively just contributes 1 winner to the pool).
        // Wait, the new index of f is determined by how many winners are < f.
        // The new index of s is determined by how many winners are < s.
        // So for neutral pairs, we care about "Does the winner have index < f?", "Does
        // the winner have index < s?".
        // Pair (u, v) with u < v.
        // Since u < v, u is closer to 1.
        // New index mapping preserves relative order.
        // If (u, v) is neutral:
        // If we pick u as winner: u < f? u < s?
        // If we pick v as winner: v < f? v < s?
        // Indices are re-assigned 1..k based on winners.
        // So IF u is chosen, it contributes to count < f if u < f.
        // If v is chosen, it contributes if v < f.
        // BUT v is n-u+1. If u < f, v is definitely > s (usually, unless f,s overlap
        // center).
        // Actually, simpler:
        // Let 'l' be number of pairs strictly left of f. (Both endpoints < f? No,
        // pairing is 1 with n, etc.)
        // Pairs are (1, n), (2, n-1)...
        // f is in pair (f, n-f+1).
        // s is in pair (s, n-s+1).
        // Range A: Pairs (i, n-i+1) where i < f.
        // For these pairs, i < f and n-i+1 > s (since f < n-f+1 usually implies left
        // half).
        // Wait. f < s.
        // Usually f <= n/2. s could be > n/2.
        // Let's iterate i from 1 to n/2.
        // Determine if f, s are in the pair.
        // If pair is neutral:
        // Winner will be i OR n-i+1.
        // Does it matter for new index of f/s?
        // Yes.
        // If i wins (i < f), new_f increases.
        // If n-i+1 wins (usually > f), new_f does NOT increase.
        // So for each neutral pair with i < f, we can have 0 or 1 contribution to
        // new_f.
        // This applies to ranges.
        // Let L = number of pairs with i < f.
        // Let M = number of pairs with f < i < s? Wait.
        // We need to count winners < f, and winners < s.
        // Since f < s, winners < f are also < s.
        // Let W1 = winners with index < f.
        // Let W2 = winners with index in (f, s).
        // New f' = W1 + 1.
        // New s' = W1 + 1 + W2 + 1 = W1 + W2 + 2.

        // We need to iterate possible values of W1 and W2.
        // Analyze pairs:
        // i loops 1 to n/2.
        // Three types of pairs:
        // 1. Pair (i, n-i+1) where i < f.
        // This pair definitely produces a winner.
        // If i wins, winner index < f.
        // If n-i+1 wins, winner index > n-i+1 > n-f+1 > s (usually).
        // So winner index > s.
        // Thus, from these L pairs, we can choose `k` winners to be < f. `L-k` winners
        // will be > s.
        // `k` ranges from 0 to L.
        // 2. Pair (i, n-i+1) where f < i < s? (Depends on s).
        // Check if s is played.
        // Let's classify indices `1..n/2` into:
        // Group A: i < f. Count = f - 1.
        // Group B: i == f or n-i+1 == f. (The f pair).
        // Group C: i > f and (i < s and n-i+1 > s). (Between pairs).
        // Group D: i == s or n-i+1 == s. (The s pair).
        // Wait. If s > n/2, s is on right side. Pair is (n-s+1, s).
        // If s <= n/2, s is on left side. Pair is (s, n-s+1).

        // Let `mid = n/2`.
        // Loop i from 1 to mid.
        // Count neutral pairs where `i < f`: Count `L`. (These contribute 0 or 1 to
        // W1).
        // Count neutral pairs where `f < i` AND `(i < s and n-i+1 > s)`??
        // Basically pairs strictly between f and s logic?
        // If s is on right (s > n/2):
        // Then neutral pairs 'between' are indices `i` such that `f < i < n-s+1`.
        // These pairs contribute to W2 (winner is i, i < s) OR (winner is n-i+1, n-i+1
        // > s).
        // If s is on left (s <= n/2):
        // Neutral pairs between f and s `f < i < s`.
        // These contribute to W2.
        // Winner i (i < s). Winner n-i+1 ( > n-s+1 > s).

        // Also need to check strict inequalities.
        // Actually:
        // Just iterate `i` from 1 to `n/2`.
        // Accumulate counts of available choices for W1 and W2.

        return solveMemo(n, f, s);
    }

    // Memoization helper
    private int[] solveMemo(int n, int f, int s) {
        if (memo[n][f][s] != null && memo[n][f][s][0] != 0)
            return memo[n][f][s];

        int minR = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;

        // Number of pairs
        int numPairs = n / 2;

        // Convert s to left-side index for logic? No.
        // Just iterate.
        // Range 1: Pairs with i < f.
        // All such pairs (i, n-i+1) have i < f and n-i+1 > s (since f < n-f+1 and s >
        // f).
        // Wait, check n-i+1 vs s.
        // If s is very large, n-i+1 could be s? No, i < f < s implies n-i+1 > n-f+1 >
        // n-s+1.
        // Wait. If s is just `f+1`. n-i+1 vs s.
        // Actually, simple condition:
        // For pair k (1..numPairs):
        // Indices are u=k, v=n-k+1.
        // Check relation with f, s.
        // If pair contains f: f wins.
        // If pair contains s: s wins.
        // Else: we can chose winner u or v.
        // If u, v < f: Impossible since u=k, so u < f means k < f.
        // If u < f:
        // Choosing u adds to count < f (and < s).
        // Choosing v (which is > s usually) adds to count > s.

        // Let's create lists of pairs.
        // Identify special pairs.
        int f_pair_idx = (f <= n / 2) ? f : n - f + 1;
        int s_pair_idx = (s <= n / 2) ? s : n - s + 1;

        // Range 1: 1 to f_pair_idx - 1. (Strictly before f_pair).
        // These pairs contribute to W1 (winners < f).
        // Each pair contributes 1 to W1 if we pick left, 0 if right.
        // Count = f_pair_idx - 1.

        // Range 2: f_pair_idx + 1 to s_pair_idx - 1. (Between f and s pairs).
        // These contribute to W2 (winners in (f, s)).
        // Each pair contributes 1 to W2 if we pick left, 0 if right.
        // Count = s_pair_idx - f_pair_idx - 1.

        // Range 3: s_pair_idx + 1 to numPairs. (After s).
        // These contribute to winners > s.
        // They affect n' but not f' or s'.
        // Actually n' is fixed (n+1)/2.

        // So we just iterate `i` (count of wins in Range 1) and `j` (count of wins in
        // Range 2).

        int count1 = f_pair_idx - 1;
        int count2 = s_pair_idx - f_pair_idx - 1;

        for (int i = 0; i <= count1; i++) {
            for (int j = 0; j <= count2; j++) {
                // Determine new f and s
                // f' = i + 1. (i winners from Range 1, plus f itself).
                // s' = i + 1 + j + 1 = i + j + 2. (i from R1, f, j from R2, s).

                // Wait.
                // We need to account for s potentially being on the "right" (v) or "left" (u).
                // If s > n/2, s is the 'v' element of pair 's_pair_idx'.
                // So s actually 'beats' the corresponding 'u'.
                // Does this affect s'?
                // Yes. s' is its rank among winners.
                // Rank = (winners < s) + 1.
                // Winners < s include:
                // - Winners from Range 1 (i winners).
                // - f (1 winner).
                // - Winners from Range 2 (j winners).
                // - What about the partner of s in s_pair?
                // If s > n/2, partner is u = s_pair_idx.
                // Since s > n/2, s > u. And s wins.
                // So u is eliminated.
                // So partner doesn't contribute.
                // So s' = i + 1 + j + 1. Correct.
                // If s <= n/2, s is the 'u' element.
                // Partner is v > s.
                // s wins.
                // Rank = i + 1 + j + 1. Correct.

                int next_f = i + 1;
                int next_s = i + j + 2;
                int next_n = (n + 1) / 2;

                int[] res = solve(next_n, next_f, next_s);
                minR = Math.min(minR, res[0]);
                maxR = Math.max(maxR, res[1]);
            }
        }

        memo[n][f][s] = new int[] { minR + 1, maxR + 1 };
        return memo[n][f][s];
    }
}

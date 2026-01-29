package leetcode.P1734_DecodeXORedPermutation;

public class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int totalXor = 0;
        for (int i = 1; i <= n; i++)
            totalXor ^= i;

        int nonFirstXor = 0;
        // encoded[1], encoded[3], ... contains pairs (1,2), (3,4)...
        // Indices in encoded are 0-based.
        // encoded[0] is p0^p1.
        // encoded[1] is p1^p2.
        // We want p[1]^...p[n-1].
        // This corresponds to encoded[1] (p1^p2), encoded[3] (p3^p4) ...
        // Logic check:
        // p = [a, b, c, d, e], n=5
        // enc = [a^b, b^c, c^d, d^e] (indices 0, 1, 2, 3)
        // enc[1] = b^c. enc[3] = d^e.
        // enc[1]^enc[3] = b^c^d^e.
        // total = a^b^c^d^e.
        // total ^ (enc[1]^enc[3]) = a = p[0]. Correct.

        for (int i = 1; i < n - 1; i += 2) {
            nonFirstXor ^= encoded[i];
        }

        int[] perm = new int[n];
        perm[0] = totalXor ^ nonFirstXor;

        for (int i = 0; i < n - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }

        return perm;
    }
}

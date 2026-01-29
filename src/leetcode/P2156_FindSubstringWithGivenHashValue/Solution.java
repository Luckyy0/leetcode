package leetcode.P2156_FindSubstringWithGivenHashValue;

public class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long curHash = 0;
        long pK = 1; // stores power^k
        int n = s.length();
        int resIdx = 0;

        // Calculate power^(k-1) to help with removal logic?
        // Formula: h_new = (val(new) + p * h_old - val(old) * p^k) % m
        // Wait, let's verify formula:
        // Window [i+1...i+k]: h_old = s[i+1] + s[i+2]p + ... + s[i+k]p^(k-1)
        // Window [i...i+k-1]: h_new = s[i] + s[i+1]p + ... + s[i+k-1]p^(k-1)
        // h_new = s[i] + p * (s[i+1] + s[i+2]p + ... + s[i+k-1]p^(k-2))
        // Inside parens is (h_old - s[i+k]p^(k-1)).
        // So h_new = s[i] + p * h_old - s[i+k] * p^k.
        // We need p^(k-1) or p^k.
        // Usually pre-calc p^(k-1) for direct term removal.
        // s[i+k] * p^k might be large.
        // Let's use p^(k-1) and logic: h_new = (s[i] + (h_old - s[i+k]*p^(k-1)%m + m)%m
        // * p) % m.
        // This avoids p^k.

        long pkMinus1 = 1;
        for (int i = 0; i < k - 1; i++) {
            pkMinus1 = (pkMinus1 * power) % modulo;
        }

        // Iterate backwards
        for (int i = n - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'a' + 1;

            if (i + k < n) {
                // Remove character at i+k
                // We are shifting window left: [i+1, i+k] -> [i, i+k-1]
                // The character falling out IS s[i+k] which had coefficient p^(k-1).
                int valOut = s.charAt(i + k) - 'a' + 1;
                long termOut = (valOut * pkMinus1) % modulo;

                curHash = (curHash - termOut + modulo) % modulo; // Remove highest power term
                curHash = (curHash * power) % modulo; // Shift powers up (multiply existing by p)
                curHash = (curHash + val) % modulo; // Add new term at p^0
            } else {
                // Building the first window (from right)
                // Just accumulate. But we need to be careful with powers.
                // When building [n-k, n-1] backwards:
                // i = n-1: val * p^0
                // i = n-2: val * p^0 + prev * p
                // This matches the update logic exactly (multiply old by p, add new).
                curHash = (curHash * power + val) % modulo;
            }

            if (i + k - 1 < n) { // Window is full size
                // Check hash. Note: loop goes down to 0, so valid windows [i, i+k-1] checked.
                // However, the "building" phase condition `i + k < n` handles transitions.
                // When `i = n - k`, we have just processed n-k..n-1.
                if (curHash == hashValue) {
                    resIdx = i;
                }
            }
        }

        return s.substring(resIdx, resIdx + k);
    }
}

package leetcode.P1652_DefuseTheBomb;

public class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0) {
            return res; // all zeros
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                for (int j = 1; j <= -k; j++) {
                    // Previous: i-1, i-2...
                    // Loop j=1 to |k| -> i-j
                    sum += code[(i - j + n) % n];
                }
            }
            res[i] = sum;
        }

        return res;
    }
}

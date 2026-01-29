package leetcode.P1220_CountVowelsPermutation;

class Solution {
    public int countVowelPermutation(int n) {
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long MOD = 1_000_000_007;

        for (int k = 1; k < n; k++) {
            long nextA = (e + i + u) % MOD;
            long nextE = (a + i) % MOD;
            long nextI = (e + o) % MOD;
            long nextO = i % MOD;
            long nextU = (i + o) % MOD;

            a = nextA;
            e = nextE;
            i = nextI;
            o = nextO;
            u = nextU;
        }

        return (int) ((a + e + i + o + u) % MOD);
    }
}

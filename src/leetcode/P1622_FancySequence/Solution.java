package leetcode.P1622_FancySequence;

import java.util.ArrayList;
import java.util.List;

class Fancy {
    private static final int MOD = 1_000_000_007;
    private List<Long> list;
    private long mul;
    private long add;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {
        // We want stored * mul + add = val
        // stored = (val - add) * inv(mul)
        long diff = (val - add) % MOD;
        if (diff < 0)
            diff += MOD;

        long stored = (diff * modInverse(mul)) % MOD;
        list.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) {
            return -1;
        }

        long stored = list.get(idx);
        long res = (stored * mul + add) % MOD;
        return (int) res;
    }

    private long modInverse(long a) {
        return power(a, MOD - 2);
    }

    private long power(long base, int exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}

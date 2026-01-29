package leetcode.P1447_SimplifiedFractions;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();

        for (int d = 2; d <= n; d++) {
            for (int num = 1; num < d; num++) {
                if (gcd(num, d) == 1) {
                    res.add(num + "/" + d);
                }
            }
        }

        return res;
    }

    // Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

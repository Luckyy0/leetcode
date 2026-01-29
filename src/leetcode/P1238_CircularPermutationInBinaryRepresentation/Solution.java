package leetcode.P1238_CircularPermutationInBinaryRepresentation;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        // 1 << n is 2^n
        for (int i = 0; i < (1 << n); i++) {
            // Standard Gray Code: i ^ (i >> 1)
            // Shifted by start: ^ start
            res.add((i ^ (i >> 1)) ^ start);
        }
        return res;
    }
}

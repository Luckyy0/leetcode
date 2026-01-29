package leetcode.P1915_NumberOfWonderfulSubstrings;

public class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1024];
        count[0] = 1; // Base case: empty prefix mask 0
        int mask = 0;
        long result = 0;

        for (char c : word.toCharArray()) {
            int bit = c - 'a';
            mask ^= (1 << bit);

            // 0 bits different
            result += count[mask];

            // 1 bit different
            for (int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }

            count[mask]++;
        }

        return result;
    }
}

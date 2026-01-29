package leetcode.P1806_MinimumNumberOfOperationsToReinitializeAPermutation;

public class Solution {
    public int reinitializePermutation(int n) {
        int pos = 1;
        int count = 0;

        do {
            if (pos < n / 2) {
                pos = 2 * pos;
            } else {
                pos = 2 * pos - n + 1;
            }
            count++;
        } while (pos != 1);

        return count;
    }
}

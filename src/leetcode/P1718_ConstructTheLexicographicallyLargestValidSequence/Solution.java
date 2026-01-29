package leetcode.P1718_ConstructTheLexicographicallyLargestValidSequence;

public class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        backtrack(0, res, used, n);
        return res;
    }

    private boolean backtrack(int idx, int[] res, boolean[] used, int n) {
        if (idx == res.length)
            return true;
        if (res[idx] != 0)
            return backtrack(idx + 1, res, used, n);

        for (int i = n; i >= 1; i--) {
            if (used[i])
                continue;

            if (i == 1) {
                res[idx] = 1;
                used[1] = true;
                if (backtrack(idx + 1, res, used, n))
                    return true;
                used[1] = false;
                res[idx] = 0;
            } else {
                if (idx + i < res.length && res[idx + i] == 0) {
                    res[idx] = i;
                    res[idx + i] = i;
                    used[i] = true;
                    if (backtrack(idx + 1, res, used, n))
                        return true;
                    used[i] = false;
                    res[idx] = 0;
                    res[idx + i] = 0;
                }
            }
        }
        return false;
    }
}

package leetcode.P936_StampingTheSequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[t.length];
        int stars = 0;

        while (stars < t.length) {
            boolean doneReplacement = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (!visited[i] && canReplace(t, i, s)) {
                    stars = doReplace(t, i, s.length, stars);
                    doneReplacement = true;
                    visited[i] = true;
                    res.add(i);
                    if (stars == t.length)
                        break;
                }
            }
            if (!doneReplacement)
                return new int[0];
        }

        Collections.reverse(res);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }

    private boolean canReplace(char[] t, int p, char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (t[p + i] != '*' && t[p + i] != s[i])
                return false;
        }
        return true;
    }

    private int doReplace(char[] t, int p, int len, int stars) {
        for (int i = 0; i < len; i++) {
            if (t[p + i] != '*') {
                t[p + i] = '*';
                stars++;
            }
        }
        return stars;
    }
}

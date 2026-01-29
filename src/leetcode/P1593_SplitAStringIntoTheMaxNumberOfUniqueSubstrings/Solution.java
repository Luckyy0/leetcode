package leetcode.P1593_SplitAStringIntoTheMaxNumberOfUniqueSubstrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }

    private int backtrack(int start, String s, Set<String> distinct) {
        if (start == s.length()) {
            return 0;
        }

        int maxSplits = 0;

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (!distinct.contains(sub)) {
                distinct.add(sub);
                int res = backtrack(i + 1, s, distinct);
                maxSplits = Math.max(maxSplits, 1 + res);
                distinct.remove(sub);
            }
        }

        return maxSplits;
    }
}

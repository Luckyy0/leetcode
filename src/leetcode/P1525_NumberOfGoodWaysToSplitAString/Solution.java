package leetcode.P1525_NumberOfGoodWaysToSplitAString;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] leftDistinct = new int[n];
        int[] rightDistinct = new int[n];

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
            leftDistinct[i] = set.size();
        }

        set.clear();
        for (int i = n - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            rightDistinct[i] = set.size();
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftDistinct[i] == rightDistinct[i + 1]) {
                count++;
            }
        }

        return count;
    }
}

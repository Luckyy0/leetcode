package leetcode.P1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxLen = 0;

    public int maxLength(List<String> arr) {
        // Pre-process to masks
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int m = 0;
            boolean valid = true;
            for (char c : s.toCharArray()) {
                int bit = 1 << (c - 'a');
                if ((m & bit) != 0) {
                    valid = false;
                    break;
                }
                m |= bit;
            }
            if (valid)
                masks.add(m);
        }

        backtrack(masks, 0, 0);
        return maxLen;
    }

    private void backtrack(List<Integer> masks, int index, int currentMask) {
        maxLen = Math.max(maxLen, Integer.bitCount(currentMask));

        for (int i = index; i < masks.size(); i++) {
            int m = masks.get(i);
            if ((currentMask & m) == 0) {
                backtrack(masks, i + 1, currentMask | m);
            }
        }
    }
}

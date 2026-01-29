package leetcode.P1291_SequentialDigits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> result = new ArrayList<>();

        for (int len = 2; len <= 9; len++) {
            for (int i = 0; i <= 9 - len; i++) {
                String sub = s.substring(i, i + len);
                long val = Long.parseLong(sub);
                if (val >= low && val <= high) {
                    result.add((int) val);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}

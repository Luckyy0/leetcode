package leetcode.P1441_BuildAnArrayWithStackOperations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int idx = 0;

        for (int i = 1; i <= n && idx < target.length; i++) {
            result.add("Push");
            if (target[idx] == i) {
                idx++;
            } else {
                result.add("Pop");
            }
        }

        return result;
    }
}

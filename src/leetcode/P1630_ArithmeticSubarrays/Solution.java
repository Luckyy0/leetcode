package leetcode.P1630_ArithmeticSubarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        int m = l.length;

        for (int i = 0; i < m; i++) {
            int left = l[i];
            int right = r[i];

            // Subarray length
            int len = right - left + 1;
            if (len < 2) {
                result.add(true);
                continue;
            }

            int[] sub = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(sub);

            boolean isArithmetic = true;
            int diff = sub[1] - sub[0];

            for (int k = 2; k < len; k++) {
                if (sub[k] - sub[k - 1] != diff) {
                    isArithmetic = false;
                    break;
                }
            }

            result.add(isArithmetic);
        }

        return result;
    }
}

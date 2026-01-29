package leetcode.P1073_AddingTwoNegabinaryNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int val1 = i >= 0 ? arr1[i--] : 0;
            int val2 = j >= 0 ? arr2[j--] : 0;
            int sum = val1 + val2 + carry;

            int rem = sum % 2;
            // Handle negative remainder
            if (rem < 0) {
                rem += 2; // e.g. -1 % 2 = -1 -> 1
            }

            // Calculate carry
            // sum = rem + carry_new * (-2)
            // carry_new = (sum - rem) / -2
            carry = -(sum - rem) / 2;

            res.add(rem);
        }

        // Remove leading zeros
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }

        Collections.reverse(res);
        int[] r = new int[res.size()];
        for (int k = 0; k < res.size(); k++)
            r[k] = res.get(k);
        return r;
    }
}

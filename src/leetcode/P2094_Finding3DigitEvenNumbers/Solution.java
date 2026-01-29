package leetcode.P2094_Finding3DigitEvenNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits)
            count[d]++;

        List<Integer> resList = new ArrayList<>();

        for (int i = 100; i < 1000; i += 2) {
            int x = i;
            int d1 = x / 100;
            int d2 = (x / 10) % 10;
            int d3 = x % 10;

            count[d1]--;
            count[d2]--;
            count[d3]--;

            if (count[d1] >= 0 && count[d2] >= 0 && count[d3] >= 0) {
                resList.add(i);
            }

            count[d1]++;
            count[d2]++;
            count[d3]++;
        }

        int[] res = new int[resList.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = resList.get(k);
        }
        return res;
    }
}

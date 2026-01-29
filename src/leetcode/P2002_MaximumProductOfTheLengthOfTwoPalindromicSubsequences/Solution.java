package leetcode.P2002_MaximumProductOfTheLengthOfTwoPalindromicSubsequences;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int limit = 1 << n;
        List<Integer> paliMasks = new ArrayList<>();
        List<Integer> paliLens = new ArrayList<>();

        for (int mask = 1; mask < limit; mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    sb.append(s.charAt(i));
                }
            }
            if (isPalindrome(sb)) {
                paliMasks.add(mask);
                paliLens.add(sb.length());
            }
        }

        int maxProd = 0;
        int size = paliMasks.size(); // usually a few hundreds

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((paliMasks.get(i) & paliMasks.get(j)) == 0) {
                    maxProd = Math.max(maxProd, paliLens.get(i) * paliLens.get(j));
                }
            }
        }

        return maxProd;
    }

    private boolean isPalindrome(StringBuilder sb) {
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

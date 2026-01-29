package leetcode.P2138_DivideAStringIntoGroupsOfSizeK;

public class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] ans = new String[groups];

        for (int i = 0; i < groups; i++) {
            int start = i * k;
            int end = start + k;
            if (end <= n) {
                ans[i] = s.substring(start, end);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(start));
                while (sb.length() < k) {
                    sb.append(fill);
                }
                ans[i] = sb.toString();
            }
        }

        return ans;
    }
}

package leetcode.P1432_MaxDifferenceYouCanGetFromChangingAnInteger;

class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String maxStr = s;
        String minStr = s;

        // Find Max
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxStr = s.replace(c, '9');
                break;
            }
        }

        // Find Min
        if (s.charAt(0) != '1') {
            minStr = s.replace(s.charAt(0), '1');
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    minStr = s.replace(s.charAt(i), '0');
                    break;
                }
            }
        }

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}

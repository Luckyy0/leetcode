package leetcode.P1638_CountSubstringsThatDifferByOneCharacter;

public class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int n = s.length();
        int m = t.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = 0;
                for (int k = 0; i + k < n && j + k < m; k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        diff++;
                    }
                    if (diff == 1) {
                        ans++;
                    } else if (diff > 1) {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}

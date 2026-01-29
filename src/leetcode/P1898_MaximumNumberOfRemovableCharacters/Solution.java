package leetcode.P1898_MaximumNumberOfRemovableCharacters;

public class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 0, high = removable.length;
        int ans = 0;

        char[] sChars = s.toCharArray();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(sChars, p, removable, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(char[] sChars, String p, int[] removable, int k) {
        boolean[] removed = new boolean[sChars.length];
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }

        int j = 0; // index for p
        for (int i = 0; i < sChars.length && j < p.length(); i++) {
            if (!removed[i] && sChars[i] == p.charAt(j)) {
                j++;
            }
        }

        return j == p.length();
    }
}

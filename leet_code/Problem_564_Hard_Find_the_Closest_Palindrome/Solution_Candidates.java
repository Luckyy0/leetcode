package leet_code.Problem_564_Hard_Find_the_Closest_Palindrome;

import java.util.ArrayList;
import java.util.List;

public class Solution_Candidates {

    /**
     * Finds the closest palindrome string.
     * Strategy: Generate 5 candidates based on mirroring and boundary cases.
     * Time: O(L), Space: O(L).
     */
    public String nearestPalindromic(String n) {
        long original = Long.parseLong(n);
        int len = n.length();

        List<Long> candidates = new ArrayList<>();
        // Edge case: 10^(len-1) - 1 (e.g., 99...9)
        candidates.add((long) Math.pow(10, len - 1) - 1);
        // Edge case: 10^len + 1 (e.g., 10...01)
        candidates.add((long) Math.pow(10, len) + 1);

        // Main logic: Take first half and try prefix, prefix+1, prefix-1
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            candidates.add(generatePalindrome(prefix + i, len % 2 == 0));
        }

        long closest = -1;
        long minDiff = Long.MAX_VALUE;

        for (long cand : candidates) {
            if (cand == original)
                continue;
            long diff = Math.abs(cand - original);
            if (diff < minDiff) {
                minDiff = diff;
                closest = cand;
            } else if (diff == minDiff) {
                closest = Math.min(closest, cand);
            }
        }

        return String.valueOf(closest);
    }

    private long generatePalindrome(long prefix, boolean even) {
        String s = String.valueOf(prefix);
        StringBuilder sb = new StringBuilder(s);
        // If even, reverse entire prefix. If odd, reverse prefix excluding last char
        String reverse = new StringBuilder(s.substring(0, even ? s.length() : s.length() - 1)).reverse().toString();
        sb.append(reverse);
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        Solution_Candidates solution = new Solution_Candidates();
        System.out.println("Result 123: " + solution.nearestPalindromic("123")); // 121
        System.out.println("Result 1: " + solution.nearestPalindromic("1")); // 0
    }
}

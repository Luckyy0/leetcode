package leetcode.P1849_SplittingAStringIntoDescendingConsecutiveValues;

public class Solution {
    public boolean splitString(String s) {
        // Try all prefixes as the first number
        // Must leave at least one character for the rest
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(0, i + 1);
            try {
                // Handle potential overflow if s length is 20
                // But since we leave at least 1 char, length is at most 19.
                // 19 digits fits in Long if not exceeding 9.22e18.
                // If it overflows Long, it's very large, but next number must be val-1.
                // If val > Long.MAX, we likely can't have many decreasing terms in 20 chars
                // anyway.
                // Actually constraint: s.length <= 20.
                if (sub.length() > 19 && s.length() == 20)
                    continue; // Skip if first part is too huge

                long val = Long.parseLong(sub);
                if (dfs(s, i + 1, val))
                    return true;

            } catch (NumberFormatException e) {
                // Ignore too large
                continue;
            }
        }
        return false;
    }

    // Expect next value to be target
    private boolean dfs(String s, int index, long prevVal) {
        if (index == s.length())
            return true;

        long target = prevVal - 1;

        // Iterate all possible next substring lengths
        for (int j = index; j < s.length(); j++) {
            String sub = s.substring(index, j + 1);
            try {
                if (sub.length() > 19)
                    continue; // Optimization
                long val = Long.parseLong(sub);

                if (val == target) {
                    if (dfs(s, j + 1, val))
                        return true;
                }

                if (val > target) {
                    // Since numbers are positive (substrings), if val > target, we took too much or
                    // impossible
                    // Wait, careful with leading zeros. "005" > "4"? No.
                    // But if val already exceeds target, taking more digits makes it larger.
                    // So we can break.
                    break;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        return false;
    }
}

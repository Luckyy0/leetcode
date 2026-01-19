package leetcode.P248_StrobogrammaticNumberIII;

public class Solution {

    /**
     * Problem 248: Strobogrammatic Number III
     * Approach: Recursive DFS Generation + Range Check
     * 
     * Theoretical Basis:
     * - Generate all candidates length by length.
     * - Filter based on string comparison with 'low' and 'high'.
     * 
     * Time Complexity: O(5^(high.len/2))
     * Space Complexity: O(high.len)
     */

    private int count = 0;
    private static final char[][] PAIRS = { { '0', '0' }, { '1', '1' }, { '8', '8' }, { '6', '9' }, { '9', '6' } };

    public int strobogrammaticInRange(String low, String high) {
        count = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            char[] buffer = new char[len];
            dfs(0, len - 1, buffer, low, high);
        }
        return count;
    }

    // left, right indices of the buffer to fill
    private void dfs(int left, int right, char[] buffer, String low, String high) {
        if (left > right) {
            String s = new String(buffer);
            // Check range
            // 1. Check length vs low/high length
            // 2. If same length, compare value strings
            if ((s.length() == low.length() && s.compareTo(low) < 0) ||
                    (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            count++;
            return;
        }

        for (char[] p : PAIRS) {
            // Cannot put '0' at start unless it's a single digit number "0"
            // If left == 0 (outermost) and length > 1, skip '0'
            if (left == 0 && left != right && p[0] == '0') {
                continue;
            }

            // If middle digit (left == right), it must be 0, 1, or 8 (6/9 invalid)
            if (left == right && (p[0] == '6' || p[0] == '9')) {
                continue;
            }

            buffer[left] = p[0];
            buffer[right] = p[1];

            dfs(left + 1, right - 1, buffer, low, high);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // low="50", high="100" -> 3 (69, 88, 96)
        runTest(solution, "50", "100", 3);

        // low="0", high="0" -> 1 ("0")
        runTest(solution, "0", "0", 1);

        // low="0", high="100" -> "0", "1", "8", "11", "69", "88", "96" -> 7
        runTest(solution, "0", "100", 7);
    }

    private static void runTest(Solution s, String low, String high, int expected) {
        int result = s.strobogrammaticInRange(low, high);
        System.out.println("Range [" + low + ", " + high + "] -> Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

package leet_code.Problem_727_Hard_Minimum_Window_Subsequence;

public class Solution {

    /**
     * Finds the minimum window in s1 that contains s2 as a subsequence.
     * Strategy: Forward scanning to find an end, then Backward scanning to optimize
     * the start.
     * Time: O(S1 * S2), Space: O(1).
     */
    public String minWindow(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int p1 = 0;
        String res = "";
        int minLen = Integer.MAX_VALUE;

        while (p1 < n1) {
            int p2 = 0;
            // Step 1: Forward Pass to find a candidate window end
            while (p1 < n1) {
                if (s1.charAt(p1) == s2.charAt(p2)) {
                    p2++;
                }
                if (p2 == n2)
                    break;
                p1++;
            }

            // If we reached the end of s1 without finding s2
            if (p1 == n1)
                break;

            // Step 2: Backward Pass to find the optimized starting point
            int end = p1;
            p2 = n2 - 1;
            while (p2 >= 0) {
                if (s1.charAt(p1) == s2.charAt(p2)) {
                    p2--;
                }
                if (p2 < 0)
                    break;
                p1--;
            }

            // Step 3: Update result if current window is smaller
            int start = p1;
            int currentLen = end - start + 1;
            if (currentLen < minLen) {
                minLen = currentLen;
                res = s1.substring(start, end + 1);
            }

            // Continue searching right after the optimized start
            p1 = start + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result: " + sol.minWindow("abcdebdde", "bde")); // bcde
    }
}

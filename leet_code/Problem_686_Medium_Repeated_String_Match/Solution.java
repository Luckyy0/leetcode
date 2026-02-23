package leet_code.Problem_686_Medium_Repeated_String_Match;

public class Solution {

    /**
     * Finds the minimum number of times string 'a' must repeat to contain 'b'.
     * Strategy: Repeat 'a' until its length >= 'b'. Check q and q+1 repetitions.
     * Time: O(N*M), Space: O(N+M).
     */
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // 1. Repeat 'a' until its length is at least 'b'.length()
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // 2. Check if b is now a substring
        if (sb.toString().contains(b)) {
            return count;
        }

        // 3. Add one more 'a' to handle cases where b spans across boundaries
        sb.append(a);
        count++;
        if (sb.toString().contains(b)) {
            return count;
        }

        // 4. If still not found, it's impossible
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result (abcd, cdabcdab): " + sol.repeatedStringMatch("abcd", "cdabcdab")); // 3
        System.out.println("Result (a, aa): " + sol.repeatedStringMatch("a", "aa")); // 2
    }
}

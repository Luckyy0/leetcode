package leet_code.Problem_467_Medium_Unique_Substrings_in_Wraparound_String;

public class Solution_MaxLen {

    /**
     * Counts unique substrings of s present in the infinite "abcd...z" string.
     * Strategy: Store the max length of a wraparound sequence ending with each
     * char.
     * Time: O(N), Space: O(1).
     */
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int[] count = new int[26];
        int currentLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (i > 0 && isSuccessor(s.charAt(i - 1), curr)) {
                currentLen++;
            } else {
                currentLen = 1;
            }

            int idx = curr - 'a';
            count[idx] = Math.max(count[idx], currentLen);
        }

        int total = 0;
        for (int c : count)
            total += c;
        return total;
    }

    // Checks if b is the next character after a in "a...za..."
    private boolean isSuccessor(char a, char b) {
        return (b - a == 1) || (a == 'z' && b == 'a');
    }

    public static void main(String[] args) {
        Solution_MaxLen solution = new Solution_MaxLen();
        System.out.println("Result (zab): " + solution.findSubstringInWraproundString("zab")); // 6
        System.out.println("Result (cac): " + solution.findSubstringInWraproundString("cac")); // 2
    }
}

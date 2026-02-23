package leet_code.Problem_791_Medium_Custom_Sort_String;

public class Solution {

    /**
     * Sorts string s based on the custom order.
     * Strategy: Count characters in s. Append them in the order specified by
     * 'order'. Append remaining.
     * Time: O(N + M), Space: O(1) (26 chars).
     */
    public String customSortString(String order, String s) {
        int[] count = new int[26];

        // Count frequency of each character in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        // Append characters in the order specified by 'order'
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }

        // Append remaining characters (not in 'order')
        // Order doesn't matter for these, typically alphabetical or arbitrary
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                sb.append((char) ('a' + i));
                count[i]--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.customSortString("cba", "abcd")); // "cbad" (or similar)
        System.out.println("Result 2: " + sol.customSortString("cbafg", "abcd")); // "cbad"
    }
}

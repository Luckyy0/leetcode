package leet_code.Problem_767_Medium_Reorganize_String;

public class Solution {

    /**
     * Reorganizes string so no two adjacent chars are same.
     * Strategy: Greedy filling (Odd/Even indices), prioritizing most frequent char.
     * Time: O(N), Space: O(N).
     */
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        int max = 0;
        int letter = 0; // Most frequent character

        for (int i = 0; i < 26; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }

        // Impossible condition
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int idx = 0;

        // 1. Fill the most frequent character into even indices (0, 2, 4...)
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }

        // 2. Fill the remaining characters
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                // If we reach end of even slots, wrap around to odd slots (1, 3, 5...)
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.reorganizeString("aab")); // "aba"
        System.out.println("Result 2: " + sol.reorganizeString("aaab")); // ""
    }
}

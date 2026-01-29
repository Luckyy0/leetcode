package leetcode.P318_MaximumProductOfWordLengths;

public class Solution {

    /**
     * Problem 318: Maximum Product of Word Lengths
     * Approach: Bitmask
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];

        for (int i = 0; i < n; i++) {
            String w = words[i];
            lens[i] = w.length();
            for (char c : w.toCharArray()) {
                masks[i] |= (1 << (c - 'a'));
            }
        }

        int maxProd = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, lens[i] * lens[j]);
                }
            }
        }

        return maxProd;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["abcw","baz","foo","bar","xtfn","abcdef"] -> 16
        runTest(solution, new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }, 16);

        // ["a","ab","abc","d","cd","bcd","abcd"] -> 4
        runTest(solution, new String[] { "a", "ab", "abc", "d", "cd", "bcd", "abcd" }, 4);

        // ["a","aa","aaa","aaaa"] -> 0
        runTest(solution, new String[] { "a", "aa", "aaa", "aaaa" }, 0);
    }

    private static void runTest(Solution s, String[] words, int expected) {
        int result = s.maxProduct(words);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

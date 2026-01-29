package leetcode.P336_PalindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 336: Palindrome Pairs
     * Approach: HashMap + Word Splitting
     * 
     * Time Complexity: O(N * K^2)
     * Space Complexity: O(N * K)
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2)
            return result;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j <= w.length(); j++) {
                String str1 = w.substring(0, j);
                String str2 = w.substring(j);

                // Case 1: str1 is palindrome.
                // We want words[k] + words[i] -> words[k] + str1 + str2.
                // If words[k] == reverse(str2), then reverse(str2) + str1 + str2.
                // Since str1 is palindrome, this forms P.
                if (isPalindrome(str1)) {
                    String str2Rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2Rev)) {
                        int k = map.get(str2Rev);
                        if (k != i) {
                            result.add(Arrays.asList(k, i));
                        }
                    }
                }

                // Case 2: str2 is palindrome.
                // We want words[i] + words[k] -> str1 + str2 + words[k].
                // If words[k] == reverse(str1), then str1 + str2 + reverse(str1).
                // Since str2 is palindrome, this forms P.
                // To avoid duplicate (overlapping with Case 1 empty string scenarios), ensure
                // str2 is not empty.
                if (str2.length() > 0 && isPalindrome(str2)) {
                    String str1Rev = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1Rev)) {
                        int k = map.get(str1Rev);
                        if (k != i) {
                            result.add(Arrays.asList(i, k));
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["abcd","dcba","lls","s","sssll"] -> [[0,1],[1,0],[3,2],[2,4]]
        runTest(solution, new String[] { "abcd", "dcba", "lls", "s", "sssll" });

        // ["bat","tab","cat"] -> [[0,1],[1,0]]
        runTest(solution, new String[] { "bat", "tab", "cat" });

        // ["a",""] -> [[0,1],[1,0]]
        runTest(solution, new String[] { "a", "" });
    }

    private static void runTest(Solution s, String[] words) {
        List<List<Integer>> result = s.palindromePairs(words);
        System.out.println("Input: " + Arrays.toString(words));
        System.out.println("Result: " + result);
        System.out.println("-----------------");
    }
}

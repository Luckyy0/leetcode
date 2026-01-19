package leetcode.P030_SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class Solution {

    /**
     * Problem 30: Substring with Concatenation of All Words
     * Approach: Sliding Window + HashMap
     * Time Complexity: O(N * L)
     * Space Complexity: O(M)
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int sLen = s.length();

        if (sLen < totalLen) {
            return result;
        }

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // We only need to iterate from i = 0 to wordLen - 1
        // as subsequent iterations would be covered by hopping wordLen
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0;

            while (right + wordLen <= sLen) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCounts.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;

                    while (seen.get(sub) > wordCounts.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "barfoothefoobarman", new String[] { "foo", "bar" }, List.of(0, 9));
        runTest(solution, "wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" },
                Collections.emptyList());
        runTest(solution, "barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }, List.of(6, 9, 12));
    }

    private static void runTest(Solution s, String str, String[] words, List<Integer> expected) {
        System.out.println("String: \"" + str + "\"");
        List<Integer> result = s.findSubstring(str, words);
        Collections.sort(result); // Order doesn't matter, sort for comparison
        List<Integer> sortedExpected = new ArrayList<>(expected);
        Collections.sort(sortedExpected);

        System.out.println("Output: " + result + " (Expected: " + sortedExpected + ")");

        if (result.equals(sortedExpected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}

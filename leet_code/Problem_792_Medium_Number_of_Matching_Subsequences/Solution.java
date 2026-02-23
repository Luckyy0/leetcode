package leet_code.Problem_792_Medium_Number_of_Matching_Subsequences;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // Helper class to track progress of each word
    private static class Node {
        int wordIndex;
        int charIndex;

        Node(int wordIndex, int charIndex) {
            this.wordIndex = wordIndex;
            this.charIndex = charIndex;
        }
    }

    /**
     * Counts how many words are subsequences of s.
     * Strategy: Bucket Queue (Next Letter Pointer). Process s once.
     * Time: O(S + Sum(len(words))), Space: O(words).
     */
    public int numMatchingSubseq(String s, String[] words) {
        // Buckets for 'a' to 'z'
        // Each bucket stores Nodes waiting for that character
        Deque<Node>[] buckets = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayDeque<>();
        }

        // Initialize buckets with the first character of each word
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0)
                continue; // Should not happen per constraints but safe check
            char startChar = words[i].charAt(0);
            buckets[startChar - 'a'].offer(new Node(i, 0));
        }

        int matchCount = 0;

        // Iterate through string s
        for (char c : s.toCharArray()) {
            Deque<Node> waiting = buckets[c - 'a'];
            // Size is fixed for this iteration step to avoid processing re-added nodes?
            // Yes, we only process nodes that were ALREADY waiting for 'c'.
            // Newly added nodes wait for the NEXT occurrence of their next char.
            // Using size loop is standard.
            int size = waiting.size();
            for (int k = 0; k < size; k++) {
                Node node = waiting.poll();

                // Move to next character in the word
                node.charIndex++;

                // Check if word is finished
                if (node.charIndex == words[node.wordIndex].length()) {
                    matchCount++;
                } else {
                    // Not finished, put into buket for next required character
                    char nextChar = words[node.wordIndex].charAt(node.charIndex);
                    buckets[nextChar - 'a'].offer(node);
                }
            }
        }

        return matchCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "abcde";
        String[] w1 = { "a", "bb", "acd", "ace" };
        System.out.println("Result 1: " + sol.numMatchingSubseq(s1, w1)); // 3

        String s2 = "dsahjpjauf";
        String[] w2 = { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" };
        System.out.println("Result 2: " + sol.numMatchingSubseq(s2, w2)); // 2
    }
}

package leetcode.P358_RearrangeStringkDistanceApart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    /**
     * Problem 358: Rearrange String k Distance Apart
     * Approach: Max Heap + Queue
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(A) where A=26
     */
    public String rearrangeString(String s, int k) {
        if (k == 0)
            return s;

        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() // Sort by freq desc
        );

        maxHeap.addAll(counts.entrySet());

        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result.append(current.getKey());

            // Decrement count
            current.setValue(current.getValue() - 1);

            // Add to wait queue
            waitQueue.offer(current);

            // If wait queue is size k, the front item is now valid (distance k satisfied)
            if (waitQueue.size() >= k) {
                Map.Entry<Character, Integer> front = waitQueue.poll();
                if (front.getValue() > 0) {
                    maxHeap.offer(front);
                }
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "aabbcc", 3 -> "abcabc"
        runTest(solution, "aabbcc", 3, "abcabc");

        // "aaabc", 3 -> ""
        runTest(solution, "aaabc", 3, "");

        // "aaadbbcc", 2 -> "abacabcd" (or similar)
        runTest(solution, "aaadbbcc", 2, "abacabcd");
    }

    private static void runTest(Solution s, String str, int k, String expected) {
        String result = s.rearrangeString(str, k);
        System.out.println("Input: " + str + ", k=" + k + " -> " + result + " (Expected: " + expected + ")");

        if (expected.isEmpty()) {
            if (result.isEmpty())
                System.out.println("PASS");
            else
                System.out.println("FAIL");
        } else {
            if (isValid(result, k) && result.length() == str.length()) {
                System.out.println("PASS (Verified valid)");
            } else {
                System.out.println("FAIL");
            }
        }
        System.out.println("-----------------");
    }

    private static boolean isValid(String s, int k) {
        if (k <= 0)
            return true;
        Map<Character, Integer> lastPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastPos.containsKey(c)) {
                if (i - lastPos.get(c) < k)
                    return false;
            }
            lastPos.put(c, i);
        }
        return true;
    }
}

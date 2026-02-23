package leet_code.Problem_358_Hard_Rearrange_String_K_Distance_Apart;

import java.util.*;

public class Solution_Greedy {

    /**
     * Rearranges string s so that same characters are at least distance k apart.
     * Uses Max-Heap and a waiting Queue.
     * Time: O(N log 26), Space: O(N).
     * 
     * Sắp xếp lại chuỗi s sao cho các ký tự giống nhau cách nhau ít nhất khoảng k.
     * Sử dụng Max-Heap và một Hàng đợi chờ.
     */
    public String rearrangeString(String s, int k) {
        if (k <= 1)
            return s;

        // 1. Count frequencies
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // 2. Max-Heap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
            int freqA = counts.get(a);
            int freqB = counts.get(b);
            if (freqA != freqB)
                return freqB - freqA;
            return a - b;
        });

        for (char c : counts.keySet()) {
            maxHeap.offer(c);
        }

        // 3. Waiting Queue for cool-down
        Queue<Character> waitQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char curr = maxHeap.poll();
            sb.append(curr);

            // Decrement frequency
            counts.put(curr, counts.get(curr) - 1);
            waitQueue.offer(curr);

            // If the wait queue reached size k, the front element is ready to be reused
            if (waitQueue.size() >= k) {
                char released = waitQueue.poll();
                if (counts.get(released) > 0) {
                    maxHeap.offer(released);
                }
            }
        }

        // If the result string length is correct, we succeeded
        return sb.length() == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: "aabbcc", k=3 -> "abcabc"
        System.out.println("Result 1: " + solution.rearrangeString("aabbcc", 3));

        // Test Case 2: "aaabc", k=3 -> ""
        System.out.println("Result 2: '" + solution.rearrangeString("aaabc", 3) + "'");

        // Test Case 3: "aaadbbcc", k=2 -> "abacabcd"
        System.out.println("Result 3: " + solution.rearrangeString("aaadbbcc", 2));
    }
}

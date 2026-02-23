package leet_code.Problem_854_Hard_K_Similar_String;

import java.util.*;

/**
 * Problem 854: K-Similar Strings
 * https://leetcode.com/problems/k-similar-strings/
 */
public class Solution {

    /**
     * Finds the minimum number of swaps to make s1 equal to s2.
     * Strategy: Breadth First Search (BFS) on the state space of strings.
     * 
     * @param s1 The source anagram.
     * @param s2 The target anagram.
     * @return The smallest k.
     * 
     *         Tóm tắt chiến lược:
     *         Sử dụng BFS để tìm đường đi ngắn nhất giữa s1 và s2. Trạng thái là
     *         chuỗi
     *         hiện tại. Để giảm số lượng trạng thái, chúng ta chỉ tráo đổi tại vị
     *         trí
     *         sai khác đầu tiên và chỉ tráo với những ký tự có thể mang lại kết quả
     *         đúng.
     */
    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2))
            return 0;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.offer(s1);
        visited.add(s1);

        int k = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(s2))
                    return k;

                // Find first mismatch
                int p = 0;
                while (curr.charAt(p) == s2.charAt(p))
                    p++;

                // Try all valid swaps to fix the mismatch at p
                for (int j = p + 1; j < curr.length(); j++) {
                    // Only swap if curr[j] matches the target character we need at s2[p]
                    // And only swap if curr[j] itself is a mismatch with s2[j] (heuristic)
                    if (curr.charAt(j) == s2.charAt(p) && curr.charAt(j) != s2.charAt(j)) {
                        String next = swap(curr, p, j);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            k++;
        }

        return k;
    }

    /**
     * Swaps characters at indices i and j in string s.
     */
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("k: " + sol.kSimilarity("ab", "ba")); // Expected: 1
        System.out.println("k: " + sol.kSimilarity("abc", "bca")); // Expected: 2
    }
}

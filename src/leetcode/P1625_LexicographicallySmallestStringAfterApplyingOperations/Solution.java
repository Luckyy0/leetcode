package leetcode.P1625_LexicographicallySmallestStringAfterApplyingOperations;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String minS = s;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        int n = s.length();

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (curr.compareTo(minS) < 0) {
                minS = curr;
            }

            // Op 1: Add a to odd indices
            char[] arr = curr.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int digit = arr[i] - '0';
                digit = (digit + a) % 10;
                arr[i] = (char) (digit + '0');
            }
            String next1 = new String(arr);
            if (!visited.contains(next1)) {
                visited.add(next1);
                queue.offer(next1);
            }

            // Op 2: Rotate by b
            String next2 = curr.substring(n - b) + curr.substring(0, n - b);
            if (!visited.contains(next2)) {
                visited.add(next2);
                queue.offer(next2);
            }
        }

        return minS;
    }
}

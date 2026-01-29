package leetcode.P773_SlidingPuzzle;

import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int[] row : board)
            for (int val : row)
                sb.append(val);
        String start = sb.toString();

        // Adjacency for 2x3 board indices flattened to string [0,1,2,3,4,5]
        int[][] neighbors = {
                { 1, 3 }, { 0, 2, 4 }, { 1, 5 },
                { 0, 4 }, { 1, 3, 5 }, { 2, 4 }
        };

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target))
                    return steps;

                int zero = curr.indexOf('0');
                for (int next : neighbors[zero]) {
                    String candidate = swap(curr, zero, next);
                    if (!visited.contains(candidate)) {
                        visited.add(candidate);
                        queue.add(candidate);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}

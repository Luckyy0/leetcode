package leetcode.P854_KSimilarStrings;

import java.util.*;

class Solution {
    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s1);
        visited.add(s1);

        int k = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(s2))
                    return k;

                int j = 0;
                while (curr.charAt(j) == s2.charAt(j))
                    j++;

                for (int m = j + 1; m < curr.length(); m++) {
                    if (curr.charAt(m) == s2.charAt(j) && curr.charAt(m) != s2.charAt(m)) {
                        String next = swap(curr, j, m);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            k++;
        }
        return k;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}

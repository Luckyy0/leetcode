package leetcode.P1202_SmallestStringWithSwaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (List<Integer> p : pairs) {
            union(p.get(0), p.get(1));
        }

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            components.putIfAbsent(root, new ArrayList<>());
            components.get(root).add(i);
        }

        char[] res = new char[n];
        for (List<Integer> indices : components.values()) {
            List<Character> chars = new ArrayList<>();
            for (int idx : indices)
                chars.add(s.charAt(idx));
            Collections.sort(chars);

            for (int i = 0; i < indices.size(); i++) {
                res[indices.get(i)] = chars.get(i);
            }
        }

        return new String(res);
    }

    private int find(int i) {
        if (parent[i] == i)
            return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}

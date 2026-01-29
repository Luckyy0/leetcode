package leetcode.P737_SentenceSimilarityII;

import java.util.*;

class Solution {
    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ)
                parent[rootI] = rootJ;
        }
    }

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;

        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (List<String> pair : similarPairs) {
            for (String s : pair) {
                if (!map.containsKey(s))
                    map.put(s, id++);
            }
        }

        DSU dsu = new DSU(id);
        for (List<String> pair : similarPairs) {
            dsu.union(map.get(pair.get(0)), map.get(pair.get(1)));
        }

        for (int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i], w2 = sentence2[i];
            if (w1.equals(w2))
                continue;
            if (!map.containsKey(w1) || !map.containsKey(w2))
                return false;
            if (dsu.find(map.get(w1)) != dsu.find(map.get(w2)))
                return false;
        }

        return true;
    }
}

package leetcode.P839_SimilarStringGroups;

class Solution {
    int[] parent;
    int groups;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        groups = n;
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        return groups;
    }

    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2)
                    return false;
            }
        }
        return diff == 0 || diff == 2;
    }

    private int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            groups--;
        }
    }
}

package leet_code.Problem_839_Hard_Similar_String_Groups;

public class Solution {

    // Disjoint Set Union Class
    class DSU {
        int[] parent;
        int count;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
            count = n;
        }

        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count--;
            }
        }
    }

    /**
     * Counts the number of similar string groups.
     * Strategy: Treat strings as nodes and similarity as edges. Use DSU to count
     * components.
     * Time: O(N^2 * L), Space: O(N).
     */
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.count;
    }

    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                // If more than 2 characters are different, they can't be made similar by one
                // swap
                if (diff > 2)
                    return false;
            }
        }
        // Identical strings or 2 swaps needed
        return diff == 2 || diff == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] s1 = { "tars", "rats", "arts", "star" };
        System.out.println("Result 1: " + sol.numSimilarGroups(s1)); // 2

        String[] s2 = { "omv", "ovm" };
        System.out.println("Result 2: " + sol.numSimilarGroups(s2)); // 1
    }
}

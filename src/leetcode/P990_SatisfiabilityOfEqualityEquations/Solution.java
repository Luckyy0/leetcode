package leetcode.P990_SatisfiabilityOfEqualityEquations;

class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        // 1. Union for ==
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int rootA = find(parent, eq.charAt(0) - 'a');
                int rootB = find(parent, eq.charAt(3) - 'a');
                if (rootA != rootB)
                    parent[rootA] = rootB;
            }
        }

        // 2. Check for !=
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int rootA = find(parent, eq.charAt(0) - 'a');
                int rootB = find(parent, eq.charAt(3) - 'a');
                if (rootA == rootB)
                    return false;
            }
        }
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }
}

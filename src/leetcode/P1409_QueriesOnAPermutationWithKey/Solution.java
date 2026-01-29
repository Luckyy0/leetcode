package leetcode.P1409_QueriesOnAPermutationWithKey;

import java.util.LinkedList;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> p = new LinkedList<>();
        for (int i = 1; i <= m; i++)
            p.add(i);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int idx = p.indexOf(q);
            result[i] = idx;

            p.remove(idx);
            p.addFirst(q);
        }

        return result;
    }
}

package leetcode.P1707_MaximumXORWithAnElementFromArray;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private void insert(TrieNode root, int num) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    private int query(TrieNode root, int x) {
        if (root.children[0] == null && root.children[1] == null)
            return -1;

        TrieNode curr = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            int desired = 1 - bit;
            if (curr.children[desired] != null) {
                maxXor |= (1 << i);
                curr = curr.children[desired];
            } else {
                curr = curr.children[bit];
            }
        }
        return maxXor;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][3];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i][0]; // xi
            sortedQueries[i][1] = queries[i][1]; // mi
            sortedQueries[i][2] = i; // original index
        }

        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[1]));

        TrieNode root = new TrieNode();
        int[] result = new int[qLen];
        int idx = 0;
        int n = nums.length;

        for (int[] q : sortedQueries) {
            int xi = q[0];
            int mi = q[1];
            int originalIdx = q[2];

            while (idx < n && nums[idx] <= mi) {
                insert(root, nums[idx]);
                idx++;
            }

            if (idx == 0)
                result[originalIdx] = -1;
            else
                result[originalIdx] = query(root, xi);
        }

        return result;
    }
}

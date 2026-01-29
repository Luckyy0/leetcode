package leetcode.P1803_CountPairsWithXORInARange;

public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count = 0;
    }

    private TrieNode root;
    private static final int MAX_BIT = 14; // nums up to 20000 < 2^15

    public int countPairs(int[] nums, int low, int high) {
        root = new TrieNode();
        int res = 0;

        for (int num : nums) {
            res += countLess(num, high + 1) - countLess(num, low);
            insert(num);
        }

        return res;
    }

    // Count elements currently in trie such that (val ^ element) < limit
    private int countLess(int val, int limit) {
        TrieNode curr = root;
        int count = 0;

        for (int i = MAX_BIT; i >= 0; i--) {
            if (curr == null)
                break;

            int bitVal = (val >> i) & 1;
            int bitLim = (limit >> i) & 1;

            if (bitLim == 1) {
                // If bitLim is 1, we can have xor bit 0 (strictly smaller) or 1 (continue)
                // xor bit 0 comes from child matching bitVal
                if (curr.children[bitVal] != null) {
                    count += curr.children[bitVal].count;
                }
                // Continue to try to match xor bit 1, which comes from child (1 - bitVal)
                curr = curr.children[1 - bitVal];
            } else {
                // If bitLim is 0, we can ONLY have xor bit 0 (equal prefix).
                // xor bit 0 comes from child matching bitVal
                curr = curr.children[bitVal];
            }
        }
        return count;
    }

    private void insert(int num) {
        TrieNode curr = root;
        for (int i = MAX_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
            curr.count++;
        }
    }
}

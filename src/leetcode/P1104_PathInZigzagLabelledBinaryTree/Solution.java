package leetcode.P1104_PathInZigzagLabelledBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path = new ArrayList<>();
        int node = label;
        int level = 0;

        // Find level
        while ((1 << (level + 1)) <= label) {
            level++;
        }
        // level of root is 0 in 1<<0=1 check? No.
        // If label=1, (1<<1)=2 > 1. loop doesn't run. level=0.
        // 1<<level = 1. range [1, 1]. Correct.
        // If label=14.
        // 1<<1 <= 14 yes (lvl 1 - range 2..3)
        // 1<<2 <= 14 yes (lvl 2 - range 4..7)
        // 1<<3 <= 14 yes (lvl 3 - range 8..15)
        // 1<<4 > 14 no.
        // level = 3. Range [8, 15]. Correct.

        while (node > 0) {
            path.add(node);
            node /= 2; // Standard parent
            level--;

            if (level < 0)
                break;

            // Invert using level range
            // Level d range [2^d, 2^(d+1) - 1]
            int start = 1 << level;
            int end = (1 << (level + 1)) - 1;
            node = start + end - node;
        }

        Collections.reverse(path);
        return path;
    }
}

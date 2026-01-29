package leetcode.P1215_SteppingNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res = new ArrayList<>();
        if (low == 0)
            res.add(0);

        Queue<Long> q = new LinkedList<>();
        for (long i = 1; i <= 9; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            long curr = q.poll();

            if (curr > high)
                continue; // Pruning if sorted generation not guaranteed?
            // Actually BFS generates in increasing order of magnitude? No, 12, 10, 21...
            // So we just check range.

            if (curr >= low && curr <= high) {
                res.add((int) curr);
            }

            int last = (int) (curr % 10);
            long next1 = curr * 10 + (last - 1);
            long next2 = curr * 10 + (last + 1);

            if (last > 0 && next1 <= high) {
                q.offer(next1);
            }
            if (last < 9 && next2 <= high) {
                q.offer(next2);
            }
        }

        Collections.sort(res);
        return res;
    }
}

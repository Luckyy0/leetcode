package leetcode.P1756_DesignMostRecentlyUsedQueue;

import java.util.ArrayList;
import java.util.List;

public class MRUQueue {
    private List<Integer> queue;

    public MRUQueue(int n) {
        queue = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int fetch(int k) {
        // k is 1-indexed
        int val = queue.remove(k - 1);
        queue.add(val);
        return val;
    }
}

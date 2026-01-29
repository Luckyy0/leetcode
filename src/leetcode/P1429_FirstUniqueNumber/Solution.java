package leetcode.P1429_FirstUniqueNumber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class FirstUnique {
    private Queue<Integer> q;
    private Map<Integer, Integer> count;

    public FirstUnique(int[] nums) {
        q = new LinkedList<>();
        count = new HashMap<>();
        for (int x : nums) {
            add(x);
        }
    }

    public int showFirstUnique() {
        while (!q.isEmpty() && count.get(q.peek()) > 1) {
            q.poll();
        }
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    public void add(int value) {
        int c = count.getOrDefault(value, 0);
        count.put(value, c + 1);
        if (c == 0) {
            q.offer(value);
        }
    }
}

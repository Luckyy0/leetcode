package leetcode.P1825_FindingMKAverage;

import java.util.LinkedList;
import java.util.Queue;

public class MKAverage {
    private int m, k;
    private Queue<Integer> queue;
    private long[] countBIT;
    private long[] sumBIT;
    private int maxVal = 100000;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.queue = new LinkedList<>();
        this.countBIT = new long[maxVal + 2];
        this.sumBIT = new long[maxVal + 2];
    }

    public void addElement(int num) {
        queue.offer(num);
        update(countBIT, num, 1);
        update(sumBIT, num, num);

        if (queue.size() > m) {
            int removed = queue.poll();
            update(countBIT, removed, -1);
            update(sumBIT, removed, -removed);
        }
    }

    public int calculateMKAverage() {
        if (queue.size() < m)
            return -1;

        long sumSmallestK = getSumOfSmallest(k);
        long sumSmallestMminusK = getSumOfSmallest(m - k);

        long sumMiddle = sumSmallestMminusK - sumSmallestK;
        int count = m - 2 * k;

        return (int) (sumMiddle / count);
    }

    private void update(long[] bit, int idx, int val) {
        idx++; // 1-based
        while (idx < bit.length) {
            bit[idx] += val;
            idx += idx & -idx;
        }
    }

    private long query(long[] bit, int idx) {
        idx++;
        long sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    // Returns sum of smallest 'count' elements
    private long getSumOfSmallest(int count) {
        int idx = findKthIndex(count);
        // idx is the value where total count >= k
        long countBefore = query(countBIT, idx - 1);
        long sumBefore = query(sumBIT, idx - 1);

        long countAtIdx = count - countBefore;
        return sumBefore + countAtIdx * idx;
    }

    // Find smallest index such that count query(index) >= k
    private int findKthIndex(int k) {
        int idx = 0;
        int n = maxVal + 1;
        for (int i = Integer.highestOneBit(n); i > 0; i >>= 1) {
            if (idx + i < n && countBIT[idx + i + 1] < k) { // bit is 1-based, array logic
                // Wait, standard BIT descent
                // BIT[x] stores sum of (x - (x&-x) + 1 .. x]
                // We check if accumulating count is enough.
                // Re-using standard binary lifting on BIT approach requires care.
                // Simple binary search is O(log^2 N), acceptable here?
                // Just use binary search on value range [0, 100000] using query().
                // Range 100000 -> log 17 steps. query is 17 steps. ~300 ops.
                // Acceptable.
                // But let's verify binary lifting.
                // Lifting typically works if bit array matches power of 2 structure.
                // Let's stick to binary search for simplicity and correctness.
                // Oh wait, inside search I do query which is log.
                // Total O(log^2 V).
            }
        }

        int lo = 0, hi = maxVal;
        int ans = maxVal;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (query(countBIT, mid) >= k) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}

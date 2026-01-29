package leetcode.P2071_MaximumNumberOfTasksYouCanAssign;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int n = tasks.length;
        int m = workers.length;
        int low = 0;
        int high = Math.min(n, m);
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, tasks, workers, pills, strength)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int k, int[] tasks, int[] workers, int pills, int strength) {
        if (k == 0)
            return true;

        // Use k smallest tasks
        // Use k strongest workers
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - 1; i >= workers.length - k; i--) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }

        int usedPills = 0;

        // Process tasks from largest to smallest (within the k selected)
        // Task indices: 0 to k-1. Largest is k-1.
        for (int i = k - 1; i >= 0; i--) {
            int t = tasks[i];

            // Try to use strongest worker without pill
            Integer strongest = workerMap.lastKey();
            if (strongest >= t) {
                removeOne(workerMap, strongest);
            } else {
                // Must use pill
                if (usedPills >= pills)
                    return false;

                // Need worker + strength >= t => worker >= t - strength
                // Use weakest capable worker to tackle this hard task?
                // Wait. Logic:
                // We are at a hard task. Strongest cannot do it without pill.
                // Anyone who attempts this MUST use a pill.
                // If we use Strongest + Pill, we solve it.
                // If we use WeakestValid + Pill, we solve it.
                // Who should we use?
                // If we save Strongest, he might be useful for NEXT task (which is smaller)
                // WITHOUT pill.
                // If we save WeakestValid, he might be useless for next tasks? No, next tasks
                // are smaller.
                // Generally saving Stronger units is better (more flexible).
                // So pick Smallest Valid Worker + Pill.

                Integer weakestValid = workerMap.ceilingKey(t - strength);
                if (weakestValid == null)
                    return false;

                removeOne(workerMap, weakestValid);
                usedPills++;
            }
        }

        return true;
    }

    private void removeOne(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1)
            map.remove(key);
        else
            map.put(key, count - 1);
    }
}

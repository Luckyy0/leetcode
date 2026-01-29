package leetcode.P1953_MaximumNumberOfWeeksForWhichYouCanWork;

public class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        long max = 0;
        for (int m : milestones) {
            sum += m;
            max = Math.max(max, m);
        }

        long rest = sum - max;
        if (max > rest + 1) {
            return 2 * rest + 1;
        } else {
            return sum;
        }
    }
}

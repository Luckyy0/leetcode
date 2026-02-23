package leet_code.Problem_495_Easy_Teemo_Attacking;

public class Solution_Linear {

    /**
     * Calculates total poisoned duration.
     * Strategy: Add min(duration, gap) for each interval.
     * Time: O(N), Space: O(1).
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0)
            return 0;

        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            // Actual duration from this attack is limited by the next attack
            total += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }

        // The last attack always runs for full duration
        total += duration;

        return total;
    }

    public static void main(String[] args) {
        Solution_Linear solution = new Solution_Linear();
        int[] times = { 1, 2 };
        System.out.println("Result: " + solution.findPoisonedDuration(times, 2)); // 3
    }
}

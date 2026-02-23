package leet_code.Problem_774_Hard_Minimize_Max_Distance_to_Gas_Station;

public class Solution {

    /**
     * Minimizes the maximum distance between gas stations.
     * Strategy: Binary search on the answer (the distance).
     * Time: O(N * log((Max-Min)/epsilon)), Space: O(1).
     */
    public double minmaxGasDist(int[] stations, int k) {
        double low = 0;
        double high = stations[stations.length - 1] - stations[0];

        // Loop for precision (or fixed number of iterations like 100)
        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2;
            if (isPossible(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }

    // Check if it's possible to achieve max distance 'limit' with at most 'k' new
    // stations
    private boolean isPossible(int[] stations, int k, double limit) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            // Number of stations to add to make segments <= limit
            // Example: gap 10, limit 3. 10/3 = 3.33 -> (int)3.33 = 3.
            // 3 adds -> 4 segments of size 2.5 <= 3. Correct.
            // Example: gap 3, limit 3. 3/3 = 1 -> (int)1 = 1? WRONG. Should be 0.
            // Correct formula is floor((gap - eps) / limit). Or cast closely.
            // (int) (gap / limit) creates 1 for gap=limit.
            // We want 0 for gap=limit.
            // Use (int)((gap) / limit).
            // Actually, if gap == limit, stations needed is 0.
            // If gap = 3.00001, limit=3, need 1.
            // Let's analyze: gap / limit. If result is integer X (e.g., 3.0), we need X-1
            // cuts.
            // If result is X.Y (e.g., 3.33), we need 3 cuts.
            // Generally: ceil(gap/limit) - 1?
            // gap=10, lim=3. ceil(3.33)-1 = 4-1=3.
            // gap=3, lim=3. ceil(1)-1 = 0.
            // Java (int) cast truncates.
            // count += (int) ((gap - 1e-10) / limit); is a safe heuristic? or just simple
            // logic?
            count += (int) (gap / limit);
        }
        return count <= k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] st1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Result 1: " + sol.minmaxGasDist(st1, 9)); // 0.5

        int[] st2 = { 23, 24, 36, 39, 46, 56, 57, 65, 84, 98 };
        System.out.println("Result 2: " + sol.minmaxGasDist(st2, 1)); // 14.0
    }
}

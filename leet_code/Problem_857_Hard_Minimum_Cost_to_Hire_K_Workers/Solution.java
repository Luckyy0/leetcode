package leet_code.Problem_857_Hard_Minimum_Cost_to_Hire_K_Workers;

import java.util.*;

/**
 * Problem 857: Minimum Cost to Hire K Workers
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
 */
public class Solution {

    /**
     * Finds the minimum cost to hire k workers under wage/quality proportionality.
     * Strategy: Sort workers by their wage-to-quality ratio. Use a Max-Heap to
     * keep track of the smallest qualities as we iterate.
     * 
     * @param quality Array of worker qualities.
     * @param wage    Array of minimum wage expectations.
     * @param k       Number of workers to hire.
     * @return Minimum cost.
     * 
     *         Tóm tắt chiến lược:
     *         Tổng chi phí = (tỉ lệ lương/chất lượng của người 'cầm đầu') * (tổng
     *         chất lượng của nhóm).
     *         Chúng ta sắp xếp theo tỉ lệ tăng dần để duyệt qua các tỉ lệ thực thi
     *         khả dĩ.
     *         Với mỗi tỉ lệ, chúng ta dùng Max-Heap để giữ k công nhân có chất
     *         lượng nhỏ nhất
     *         nhằm tối thiểu hóa tổng chi phí.
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        // Construct [ratio, quality] tuples
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = (double) quality[i];
        }

        // Sort by the ratio (wage/quality) ascending
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        // Max-Heap to maintain the k smallest qualities seen so far
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double minTotalCost = Double.MAX_VALUE;
        double currentQualitySum = 0;

        for (double[] worker : workers) {
            double ratio = worker[0];
            double q = worker[1];

            currentQualitySum += q;
            maxHeap.offer(q);

            // If we have more than k workers, remove the one with the highest quality
            if (maxHeap.size() > k) {
                currentQualitySum -= maxHeap.poll();
            }

            // If we have exactly k workers, calculate the candidate cost
            if (maxHeap.size() == k) {
                // Cost = (highest ratio in group) * (sum of group qualities)
                // Since we sorted by ratio, the 'highest' is always the current ratio.
                minTotalCost = Math.min(minTotalCost, ratio * currentQualitySum);
            }
        }

        return minTotalCost;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] q1 = { 10, 20, 5 };
        int[] w1 = { 7, 10, 4 };
        System.out.println("Min Cost: " + sol.mincostToHireWorkers(q1, w1, 2)); // 14.07143

        int[] q2 = { 3, 1, 10, 10, 1 };
        int[] w2 = { 4, 8, 2, 2, 7 };
        System.out.println("Min Cost: " + sol.mincostToHireWorkers(q2, w2, 3)); // 30.66667
    }
}

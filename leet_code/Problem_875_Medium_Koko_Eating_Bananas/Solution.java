package leet_code.Problem_875_Medium_Koko_Eating_Bananas;

/**
 * Problem 875: Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class Solution {

    /**
     * Finds the minimum eating speed k to finish all bananas within h hours.
     * Strategy: Binary Search on the speed k.
     * 
     * @param piles Array of bananas in each pile.
     * @param h     Maximum hours allowed.
     * @return Minimum speed k.
     * 
     *         Tóm tắt chiến lược:
     *         Tổng thời gian cần thiết để ăn hết chuối giảm dần khi tốc độ k tăng
     *         lên.
     *         Vì vậy, chúng ta có thể dùng tìm kiếm nhị phân để tìm giá trị k nhỏ
     *         nhất
     *         thỏa mãn điều kiện tổng thời gian <= h.
     *         Phạm vi tìm kiếm: từ 1 đến 1,000,000,000 (giá trị nải lớn nhất).
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1_000_000_000; // Max possible pile size

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                // If can finish at speed mid, try slower speeds
                high = mid;
            } else {
                // Speed is too slow, must eat faster
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * Checks if Koko can finish all bananas at speed k within h hours.
     */
    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int p : piles) {
            // Calculate ceiling division: ceil(p/k)
            // p + k - 1 handles the remainder effectively
            totalHours += (long) (p + k - 1) / k;
        }
        return totalHours <= (long) h;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Min Speed: " + sol.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8)); // 4
        System.out.println("Min Speed: " + sol.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5)); // 30
        System.out.println("Min Speed: " + sol.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6)); // 23
    }
}

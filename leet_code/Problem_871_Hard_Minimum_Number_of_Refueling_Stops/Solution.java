package leet_code.Problem_871_Hard_Minimum_Number_of_Refueling_Stops;

import java.util.*;

/**
 * Problem 871: Minimum Number of Refueling Stops
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 */
public class Solution {

    /**
     * Calculates the minimum refueling stops to reach target.
     * Strategy: Greedy using a Max-Heap. Collect gasoline from stations as
     * we pass them, but only use (refuel) when our tank is empty.
     * 
     * @param target    Goal distance.
     * @param startFuel Initial fuel.
     * @param stations  Array of [position, fuel_at_station].
     * @return Minimum stops or -1.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta "thu thập" các trạm xăng trên đường đi vào một hàng đợi ưu
     *         tiên
     *         (Max-Heap) nhưng không đổ ngay. Khi xe hết xăng trước khi tới đích
     *         hoặc
     *         tới trạm kế tiếp, ta sẽ lấy trạm có nhiều xăng nhất đã đi qua để "đổ
     *         bù".
     *         Điều này đảm bảo số lần dừng là ít nhất.
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max-Heap to store fuel amounts of reached stations
        PriorityQueue<Integer> fuelAvailable = new PriorityQueue<>((a, b) -> b - a);

        int currentDistance = startFuel;
        int stops = 0;
        int i = 0;
        int n = stations.length;

        // While we haven't reached the target
        while (currentDistance < target) {
            // Add all stations we can reach with the fuel we have
            while (i < n && stations[i][0] <= currentDistance) {
                fuelAvailable.offer(stations[i][1]);
                i++;
            }

            // If we have no more fuel and can't reach any more stations
            if (fuelAvailable.isEmpty()) {
                return -1;
            }

            // Refuel with the largest amount of gas we've passed
            currentDistance += fuelAvailable.poll();
            stops++;
        }

        return stops;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Stops: " + sol.minRefuelStops(1, 1, new int[][] {})); // 0
        System.out.println("Stops: " + sol.minRefuelStops(100, 1, new int[][] { { 10, 100 } })); // -1
        System.out.println("Stops: "
                + sol.minRefuelStops(100, 10, new int[][] { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } })); // 2
    }
}

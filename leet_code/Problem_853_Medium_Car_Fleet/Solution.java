package leet_code.Problem_853_Medium_Car_Fleet;

import java.util.*;

/**
 * Problem 853: Car Fleet
 * https://leetcode.com/problems/car-fleet/
 */
public class Solution {

    /**
     * Calculates the number of car fleets that will arrive at the destination.
     * Strategy: Sort cars by their starting position in descending order.
     * Calculate the time each car takes to reach the target.
     * 
     * @param target   The destination mile.
     * @param position Starting positions of cars.
     * @param speed    Speeds of cars.
     * @return Number of car fleets.
     * 
     *         Tóm tắt chiến lược:
     *         Sắp xếp các xe theo vị trí từ gần đích đến xa đích nhất. Tính thời
     *         gian
     *         mỗi xe đến đích. Nếu xe phía sau đến đích mất nhiều thời gian hơn xe
     *         trưởng đội phía trước, nó tạo thành một đội mới.
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0)
            return 0;

        // Store [position, arrival_time]
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // Time = (Distance to target / speed)
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort by position descending (closest to target starts the list)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleetCount = 0;
        double currentMaxTime = 0.0;

        for (int i = 0; i < n; i++) {
            double arrivalTime = cars[i][1];
            // If the current car takes more time than the leading fleet,
            // it cannot catch up, thus forming a new fleet.
            if (arrivalTime > currentMaxTime) {
                fleetCount++;
                currentMaxTime = arrivalTime;
            }
        }

        return fleetCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int target1 = 12;
        int[] position1 = { 10, 8, 0, 5, 3 };
        int[] speed1 = { 2, 4, 1, 1, 3 };
        System.out.println("Fleets: " + sol.carFleet(target1, position1, speed1)); // Expected: 3

        int target2 = 10;
        int[] position2 = { 3 };
        int[] speed2 = { 3 };
        System.out.println("Fleets: " + sol.carFleet(target2, position2, speed2)); // Expected: 1

        int target3 = 100;
        int[] position3 = { 0, 2, 4 };
        int[] speed3 = { 4, 2, 1 };
        System.out.println("Fleets: " + sol.carFleet(target3, position3, speed3)); // Expected: 1
    }
}

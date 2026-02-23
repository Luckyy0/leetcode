package leet_code.Problem_815_Hard_Bus_Routes;

import java.util.*;

public class Solution {

    /**
     * Finds the minimum number of buses needed to reach the target stop.
     * Strategy: BFS on bus routes.
     * Time: O(Sum(routes[i].length)), Space: O(Sum(routes[i].length)).
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // If already at destination
        if (source == target)
            return 0;

        // Map: stop ID -> list of indices of buses that pass through this stop
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        // If source stop doesn't exist in any route
        if (!stopToBuses.containsKey(source))
            return -1;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        // Add all buses passing through the source stop to the starting queue
        for (int bus : stopToBuses.get(source)) {
            queue.offer(bus);
            visitedBuses.add(bus);
        }

        int busCount = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Level-order traversal for BFS
            for (int i = 0; i < size; i++) {
                int bus = queue.poll();

                // Explore all stops on this bus's route
                for (int stop : routes[bus]) {
                    if (stop == target)
                        return busCount;

                    // If we haven't processed this stop yet, find other buses passing through it
                    if (!visitedStops.contains(stop)) {
                        visitedStops.add(stop);

                        // Check all other buses sharing this stop
                        List<Integer> otherBuses = stopToBuses.getOrDefault(stop, new ArrayList<>());
                        for (int nextBus : otherBuses) {
                            if (!visitedBuses.contains(nextBus)) {
                                visitedBuses.add(nextBus);
                                queue.offer(nextBus);
                            }
                        }
                    }
                }
            }
            busCount++;
        }

        return -1; // Target unreachable
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] r1 = { { 1, 2, 7 }, { 3, 6, 7 } };
        System.out.println("Result 1: " + sol.numBusesToDestination(r1, 1, 6)); // 2

        int[][] r2 = { { 7, 12 }, { 4, 5, 15 }, { 6 }, { 15, 19 }, { 9, 12, 13 } };
        System.out.println("Result 2: " + sol.numBusesToDestination(r2, 15, 12)); // -1
    }
}

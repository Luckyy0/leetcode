package leetcode.P815_BusRoutes;

import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        // Map stop to list of buses passing it
        // Anh xa diem dung toi danh sach cac xe buyt di qua no
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);
        boolean[] visitedBuses = new boolean[routes.length];

        int busesTaken = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            busesTaken++;
            for (int i = 0; i < size; i++) {
                int currStop = queue.poll();

                for (int busIdx : stopToBuses.getOrDefault(currStop, new ArrayList<>())) {
                    if (visitedBuses[busIdx])
                        continue;
                    visitedBuses[busIdx] = true;

                    for (int nextStop : routes[busIdx]) {
                        if (nextStop == target)
                            return busesTaken;
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.add(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}

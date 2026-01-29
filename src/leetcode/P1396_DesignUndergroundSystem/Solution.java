package leetcode.P1396_DesignUndergroundSystem;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkIns;
    private Map<String, Pair<Double, Integer>> travelData; // Key: "Start->End", Value: {TotalTime, Count}

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelData = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInInfo = checkIns.remove(id);
        String startStation = checkInInfo.getKey();
        int startTime = checkInInfo.getValue();

        String route = startStation + "->" + stationName;
        int duration = t - startTime;

        Pair<Double, Integer> stats = travelData.getOrDefault(route, new Pair<>(0.0, 0));
        travelData.put(route, new Pair<>(stats.getKey() + duration, stats.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Pair<Double, Integer> stats = travelData.get(route);
        return stats.getKey() / stats.getValue();
    }

    // Simple Pair class
    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

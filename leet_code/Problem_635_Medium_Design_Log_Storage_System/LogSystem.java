package leet_code.Problem_635_Medium_Design_Log_Storage_System;

import java.util.*;

public class LogSystem {

    private List<String[]> logs;
    private Map<String, Integer> indexMap;

    public LogSystem() {
        logs = new ArrayList<>();
        indexMap = new HashMap<>();
        indexMap.put("Year", 4);
        indexMap.put("Month", 7);
        indexMap.put("Day", 10);
        indexMap.put("Hour", 13);
        indexMap.put("Minute", 16);
        indexMap.put("Second", 19);
    }

    /**
     * Stores a log entry.
     */
    public void put(int id, String timestamp) {
        logs.add(new String[] { String.valueOf(id), timestamp });
    }

    /**
     * Retrieves IDs within range based on granularity.
     * Strategy: Truncate strings to prefix length dictated by granularity.
     */
    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> result = new ArrayList<>();
        int length = indexMap.get(granularity);

        String startPrefix = start.substring(0, length);
        String endPrefix = end.substring(0, length);

        for (String[] log : logs) {
            String logPrefix = log[1].substring(0, length);
            // Lexicographical comparison for fixed-length zero-padded strings
            if (logPrefix.compareTo(startPrefix) >= 0 && logPrefix.compareTo(endPrefix) <= 0) {
                result.add(Integer.parseInt(log[0]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");
        System.out
                .println("Retrieve Year: " + logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));
        System.out
                .println("Retrieve Hour: " + logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }
}

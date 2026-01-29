package leetcode.P635_DesignLogStorageSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LogSystem {

    private List<Log> logs;
    private Map<String, Integer> granularityIndex;

    class Log {
        int id;
        String timestamp;

        Log(int id, String timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    public LogSystem() {
        logs = new ArrayList<>();
        granularityIndex = new HashMap<>();
        // "2017:01:01:23:59:59"
        // Indices of separators: 4, 7, 10, 13, 16, 19
        // Substring(0, index) includes the component
        // Year: 2017 -> length 4
        // Month: 2017:01 -> length 7
        // Day: 2017:01:01 -> length 10
        granularityIndex.put("Year", 4);
        granularityIndex.put("Month", 7);
        granularityIndex.put("Day", 10);
        granularityIndex.put("Hour", 13);
        granularityIndex.put("Minute", 16);
        granularityIndex.put("Second", 19);
    }

    public void put(int id, String timestamp) {
        logs.add(new Log(id, timestamp));
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> result = new ArrayList<>();
        int idx = granularityIndex.get(granularity);

        String s = start.substring(0, idx);
        String e = end.substring(0, idx);

        for (Log log : logs) {
            String t = log.timestamp.substring(0, idx);
            if (t.compareTo(s) >= 0 && t.compareTo(e) <= 0) {
                result.add(log.id);
            }
        }

        return result;
    }
}

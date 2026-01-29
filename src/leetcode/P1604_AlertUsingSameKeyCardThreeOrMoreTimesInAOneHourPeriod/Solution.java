package leetcode.P1604_AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];

            // Parse time
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            int minutes = hour * 60 + minute;

            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(minutes);
        }

        TreeSet<String> alerted = new TreeSet<>();

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();

            Collections.sort(times);

            for (int i = 0; i < times.size() - 2; i++) {
                if (times.get(i + 2) - times.get(i) <= 60) {
                    alerted.add(name);
                    break;
                }
            }
        }

        return new ArrayList<>(alerted);
    }
}

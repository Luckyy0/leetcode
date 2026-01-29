package leetcode.P1436_DestinationCity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> starts = new HashSet<>();
        for (List<String> path : paths) {
            starts.add(path.get(0));
        }

        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!starts.contains(dest)) {
                return dest;
            }
        }

        return "";
    }
}

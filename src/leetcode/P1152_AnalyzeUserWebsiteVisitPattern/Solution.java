package leetcode.P1152_AnalyzeUserWebsiteVisitPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    class Visit {
        String username;
        int timestamp;
        String website;

        Visit(String u, int t, String w) {
            username = u;
            timestamp = t;
            website = w;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<Visit> visits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visits.add(new Visit(username[i], timestamp[i], website[i]));
        }

        Collections.sort(visits, (a, b) -> a.timestamp - b.timestamp);

        Map<String, List<String>> userVisits = new HashMap<>();
        for (Visit v : visits) {
            userVisits.putIfAbsent(v.username, new ArrayList<>());
            userVisits.get(v.username).add(v.website);
        }

        Map<String, Integer> patternCount = new HashMap<>();
        String bestPatternStr = "";
        int maxCount = 0;

        for (String user : userVisits.keySet()) {
            List<String> sites = userVisits.get(user);
            int m = sites.size();
            Set<String> seen = new HashSet<>(); // Count pattern once per user

            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    for (int k = j + 1; k < m; k++) {
                        String pattern = sites.get(i) + " " + sites.get(j) + " " + sites.get(k);
                        if (!seen.contains(pattern)) {
                            seen.add(pattern);
                            patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
                        }
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        // Find max
        for (Map.Entry<String, Integer> entry : patternCount.entrySet()) {
            String p = entry.getKey();
            int c = entry.getValue();
            if (c > maxCount || (c == maxCount && p.compareTo(bestPatternStr) < 0)) {
                maxCount = c;
                bestPatternStr = p;
            }
        }

        // Split string back to list?
        // Wait, "pattern" stored as string for map key.
        // Need to return List<String>.
        // Since input might have spaces? Problem doesn't say website names have spaces.
        // Standard approach is splitting, or storing List<String> as key (works in Java
        // map if list contents match).
        // Let's re-parse or store better.
        // Easier: Split by separator. Assuming websites don't contain special char like
        // space.
        // Actually website is "string". could contain anything.
        // Let's store List<String> in Map Key.

        // Re-implement with List as Key
        Map<List<String>, Integer> listCount = new HashMap<>();
        List<String> bestList = new ArrayList<>();
        maxCount = 0;

        for (String user : userVisits.keySet()) {
            List<String> sites = userVisits.get(user);
            int m = sites.size();
            Set<List<String>> seen = new HashSet<>();

            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    for (int k = j + 1; k < m; k++) {
                        List<String> p = Arrays.asList(sites.get(i), sites.get(j), sites.get(k));
                        if (!seen.contains(p)) {
                            seen.add(p);
                            listCount.put(p, listCount.getOrDefault(p, 0) + 1);
                        }
                    }
                }
            }
        }

        for (Map.Entry<List<String>, Integer> entry : listCount.entrySet()) {
            List<String> p = entry.getKey();
            int c = entry.getValue();

            if (c > maxCount) {
                maxCount = c;
                bestList = p;
            } else if (c == maxCount) {
                // Lex check
                if (bestList.isEmpty() || compareLists(p, bestList) < 0) {
                    bestList = p;
                }
            }
        }

        return bestList;
    }

    private int compareLists(List<String> a, List<String> b) {
        for (int i = 0; i < 3; i++) {
            int cmp = a.get(i).compareTo(b.get(i));
            if (cmp != 0)
                return cmp;
        }
        return 0;
    }
}

package leetcode.P811_SubdomainVisitCount;

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cd : cpdomains) {
            int spaceIdx = cd.indexOf(' ');
            int count = Integer.parseInt(cd.substring(0, spaceIdx));
            String domain = cd.substring(spaceIdx + 1);

            // Add initial full domain
            map.put(domain, map.getOrDefault(domain, 0) + count);

            // Find all subdomains
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String sub = domain.substring(i + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + count);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (String d : map.keySet()) {
            res.add(map.get(d) + " " + d);
        }
        return res;
    }
}

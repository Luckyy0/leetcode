package leetcode.P1257_SmallestCommonRegion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parent = new HashMap<>();

        for (List<String> list : regions) {
            String p = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                parent.put(list.get(i), p);
            }
        }

        Set<String> ancestors = new HashSet<>();
        String curr = region1;
        while (curr != null) {
            ancestors.add(curr);
            curr = parent.get(curr);
        }

        curr = region2;
        while (curr != null) {
            if (ancestors.contains(curr)) {
                return curr;
            }
            curr = parent.get(curr);
        }

        return null;
    }
}

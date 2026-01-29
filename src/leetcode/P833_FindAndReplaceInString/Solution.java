package leetcode.P833_FindAndReplaceInString;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // Map original index to the index in the operation arrays
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                map.put(indices[i], i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (map.containsKey(i)) {
                int idx = map.get(i);
                sb.append(targets[idx]);
                i += sources[idx].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}

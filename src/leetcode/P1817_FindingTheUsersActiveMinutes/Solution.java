package leetcode.P1817_FindingTheUsersActiveMinutes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> uamMap = new HashMap<>();
        for (int[] log : logs) {
            uamMap.computeIfAbsent(log[0], x -> new HashSet<>()).add(log[1]);
        }

        int[] result = new int[k];
        for (Set<Integer> minutes : uamMap.values()) {
            int uam = minutes.size();
            if (uam <= k) {
                result[uam - 1]++;
            }
        }
        return result;
    }
}

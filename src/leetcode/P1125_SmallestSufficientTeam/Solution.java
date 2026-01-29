package leetcode.P1125_SmallestSufficientTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int m = req_skills.length;
        Map<String, Integer> skillId = new HashMap<>();
        for (int i = 0; i < m; i++)
            skillId.put(req_skills[i], i);

        // dp[mask] stores the list of person indices
        List<Integer>[] dp = new ArrayList[1 << m];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < people.size(); i++) {
            List<String> skills = people.get(i);
            int personMask = 0;
            for (String s : skills) {
                if (skillId.containsKey(s)) {
                    personMask |= (1 << skillId.get(s));
                }
            }
            // Optimization: if personMask is 0, skip
            if (personMask == 0)
                continue;

            // Iterate over all reachable masks
            // We use a specific loop variable to avoid concurrent modification issues if
            // using map,
            // but here we use array, so we must be careful not to use newly added states in
            // same person loop?
            // Actually, usually we iterate over all existing valid 'dp' states.
            // Since we want smallest size, we iterate all and try to update.
            // Clone the valid indices to iterate

            // With N=60, 2^16=65536. Loop is 60 * 65536 ~ 4M operations. Acceptable.
            // Note: iterating 0 to 65535 is fine, but many null.
            // To speed up, iterate only valid states. But keeping track of valid states?
            // Just looping 0 to target works if we check null.

            for (int mask = 0; mask < (1 << m); mask++) {
                if (dp[mask] == null)
                    continue;

                int nextMask = mask | personMask;
                if (dp[nextMask] == null || dp[nextMask].size() > dp[mask].size() + 1) {
                    List<Integer> newTeam = new ArrayList<>(dp[mask]);
                    newTeam.add(i);
                    dp[nextMask] = newTeam;
                }
            }
        }

        List<Integer> finalTeam = dp[(1 << m) - 1];
        int[] res = new int[finalTeam.size()];
        for (int i = 0; i < finalTeam.size(); i++)
            res[i] = finalTeam.get(i);
        return res;
    }
}

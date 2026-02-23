package leet_code.Problem_527_Hard_Word_Abbreviation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_Iterative {

    /**
     * Resolves unique abbreviations.
     * Strategy: Iterative conflict resolution.
     * Time: O(N^2 * L) worst case, practically fast. Space: O(N * L).
     */
    public List<String> wordsAbbreviation(List<String> words) {
        int n = words.size();
        String[] ans = new String[n];
        int[] prefix = new int[n];

        // Initialize with shortest prefix (1)
        for (int i = 0; i < n; i++) {
            prefix[i] = 1;
            ans[i] = makeAbbr(words.get(i), 1);
        }

        for (int round = 0; round < n; round++) {
            boolean conflict = false;
            Map<String, List<Integer>> map = new HashMap<>();

            // Group indices by current abbreviation
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(ans[i], k -> new ArrayList<>()).add(i);
            }

            // Checks for conflicts
            for (List<Integer> group : map.values()) {
                if (group.size() > 1) {
                    conflict = true;
                    for (int idx : group) {
                        prefix[idx]++;
                        ans[idx] = makeAbbr(words.get(idx), prefix[idx]);
                    }
                }
            }

            if (!conflict)
                break;
        }

        return Arrays.asList(ans);
    }

    private String makeAbbr(String s, int k) {
        if (k + 2 >= s.length()) {
            return s;
        }
        // Prefix len k means s[0...k-1] (k chars).
        // Middle count = len - k - 1.
        // Last char s[len-1].
        return s.substring(0, k) + (s.length() - k - 1) + s.charAt(s.length() - 1);
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();
        List<String> words = Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face",
                "intrusion");
        // Expected:
        // ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
        System.out.println("Result: " + solution.wordsAbbreviation(words));
    }
}

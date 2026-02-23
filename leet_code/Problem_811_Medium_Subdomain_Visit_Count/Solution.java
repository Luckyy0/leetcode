package leet_code.Problem_811_Medium_Subdomain_Visit_Count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Aggregates visit counts for all subdomains.
     * Strategy: Use a HashMap to store the total counts for each subdomain found.
     * Time: O(L) where L is the total length of strings.
     * Space: O(L) for the HashMap.
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        // Map to store subdomain -> total count
        Map<String, Integer> counts = new HashMap<>();

        for (String cpdomain : cpdomains) {
            // Find the space to separate count and domain
            int spaceIdx = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, spaceIdx));
            String fullDomain = cpdomain.substring(spaceIdx + 1);

            // Start with the full domain
            String current = fullDomain;
            while (true) {
                // Add count to the current subdomain
                counts.put(current, counts.getOrDefault(current, 0) + count);

                // Find next subdomain by looking for a '.'
                int dotIdx = current.indexOf('.');
                if (dotIdx == -1) {
                    break; // No more subdomains
                }
                // Strip the leftmost part (e.g., "discuss.leetcode.com" -> "leetcode.com")
                current = current.substring(dotIdx + 1);
            }
        }

        // Convert map to required list format
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] cp1 = { "9001 discuss.leetcode.com" };
        System.out.println("Result 1: " + sol.subdomainVisits(cp1));

        String[] cp2 = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
        System.out.println("Result 2: " + sol.subdomainVisits(cp2));
    }
}

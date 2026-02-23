package leet_code.Problem_721_Medium_Accounts_Merge;

import java.util.*;

public class Solution {

    // Helper class for Disjoint Set Union
    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]); // Path compression
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }

    /**
     * Merges accounts belonging to the same person based on common emails.
     * Strategy: Disjoint Set Union (DSU) on emails.
     * Time: O(NK log(NK)), Space: O(NK).
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(10001); // Max emails roughly 1000 * 10
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToID = new HashMap<>();
        int id = 0;

        // Step 1: Assign IDs to emails and link to names
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                    emailToName.put(email, name);
                }
                // Step 2: Union all emails in the same account list
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        // Step 3: Group emails by their DSU root
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String email : emailToID.keySet()) {
            int root = dsu.find(emailToID.get(email));
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step 4: Sort emails and format the result
        List<List<String>> result = new ArrayList<>();
        for (List<String> component : groups.values()) {
            Collections.sort(component);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(emailToName.get(component.get(0))); // Add name
            mergedAccount.addAll(component); // Add sorted emails
            result.add(mergedAccount);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"));
        List<List<String>> result = sol.accountsMerge(accounts);
        for (List<String> acc : result) {
            System.out.println(acc);
        }
    }
}

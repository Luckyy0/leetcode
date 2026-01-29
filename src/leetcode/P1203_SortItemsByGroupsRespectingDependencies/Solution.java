package leetcode.P1203_SortItemsByGroupsRespectingDependencies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Handle -1 groups by assigning unique IDs starting from m
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Build graphs
        List<List<Integer>> groupAdj = new ArrayList<>();
        for (int i = 0; i < m; i++)
            groupAdj.add(new ArrayList<>());
        int[] groupDegree = new int[m];

        List<List<Integer>> itemAdj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            itemAdj.add(new ArrayList<>());
        int[] itemDegree = new int[n];

        for (int v = 0; v < n; v++) { // v must follow u in beforeItems[v]
            for (int u : beforeItems.get(v)) {
                // u -> v
                if (group[u] == group[v]) {
                    itemAdj.get(u).add(v);
                    itemDegree[v]++;
                } else {
                    groupAdj.get(group[u]).add(group[v]);
                    groupDegree[group[v]]++;
                }
            }
        }

        // Topo sort groups
        List<Integer> groupOrder = topoSort(groupAdj, groupDegree, m);
        if (groupOrder.isEmpty())
            return new int[0];

        // Topo sort items
        List<Integer> itemOrder = topoSort(itemAdj, itemDegree, n);
        if (itemOrder.isEmpty())
            return new int[0];

        // Group items by group
        Map<Integer, List<Integer>> groupItems = new HashMap<>();
        for (int item : itemOrder) {
            groupItems.putIfAbsent(group[item], new ArrayList<>());
            groupItems.get(group[item]).add(item);
        }

        int[] res = new int[n];
        int idx = 0;
        for (int g : groupOrder) {
            if (groupItems.containsKey(g)) {
                for (int item : groupItems.get(g)) {
                    res[idx++] = item;
                }
            }
        }

        return res;
    }

    private List<Integer> topoSort(List<List<Integer>> adj, int[] indegree, int count) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    q.offer(v);
            }
        }

        return res.size() == count ? res : new ArrayList<>();
    }
}

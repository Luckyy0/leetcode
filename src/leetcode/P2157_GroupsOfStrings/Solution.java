package leetcode.P2157_GroupsOfStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int[] parent;
    int[] size;

    public int[] groupStrings(String[] words) {
        Map<Integer, Integer> maskCounts = new HashMap<>();
        Map<Integer, Integer> maskToId = new HashMap<>(); // Mask -> ID (0 to unique-1)

        int uniqueId = 0;
        for (String w : words) {
            int mask = 0;
            for (char c : w.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            maskCounts.put(mask, maskCounts.getOrDefault(mask, 0) + 1);
            if (!maskToId.containsKey(mask)) {
                maskToId.put(mask, uniqueId++);
            }
        }

        int n = uniqueId;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Initialize sizes with duplicate counts
        for (Map.Entry<Integer, Integer> entry : maskToId.entrySet()) {
            size[entry.getValue()] = maskCounts.get(entry.getKey());
        }

        // For Replace logic efficiently: Map submask -> ID of first mask that generated
        // it
        Map<Integer, Integer> submaskOwner = new HashMap<>();

        for (int mask : maskToId.keySet()) {
            int u = maskToId.get(mask);

            for (int i = 0; i < 26; i++) {
                if (((mask >> i) & 1) == 0)
                    continue;

                // 1. Deletion (and implicitly Addition)
                int sub = mask ^ (1 << i);

                // If the submask itself is a valid word, connect
                if (maskToId.containsKey(sub)) {
                    union(u, maskToId.get(sub));
                }

                // 2. Replacement (via common submask)
                // If another word reduced to this same 'sub', connect them
                if (submaskOwner.containsKey(sub)) {
                    union(u, submaskOwner.get(sub));
                } else {
                    submaskOwner.put(sub, u);
                }
            }
        }

        int groups = 0;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                groups++;
                maxSize = Math.max(maxSize, size[i]);
            }
        }

        return new int[] { groups, maxSize };
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            size[rootJ] += size[rootI];
        }
    }
}

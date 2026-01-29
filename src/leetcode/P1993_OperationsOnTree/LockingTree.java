package leetcode.P1993_OperationsOnTree;

import java.util.ArrayList;
import java.util.List;

public class LockingTree {
    private int[] parent;
    private int[] lockedBy;
    private List<Integer>[] children;

    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parent = parent;
        this.lockedBy = new int[n];
        this.children = new ArrayList[n];
        for (int i = 0; i < n; i++)
            this.children[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                children[parent[i]].add(i);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (lockedBy[num] != 0)
            return false;
        lockedBy[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lockedBy[num] != user)
            return false;
        lockedBy[num] = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        // 1. Is Node Unlocked?
        if (lockedBy[num] != 0)
            return false;

        // 2. No Locked Ancestors?
        int curr = parent[num];
        while (curr != -1) {
            if (lockedBy[curr] != 0)
                return false;
            curr = parent[curr];
        }

        // 3. At least one locked descendant? And collect them.
        List<Integer> lockedDescendants = new ArrayList<>();
        checkDescendants(num, lockedDescendants);

        if (lockedDescendants.isEmpty())
            return false;

        // Execute Upgrade
        for (int desc : lockedDescendants) {
            lockedBy[desc] = 0;
        }
        lockedBy[num] = user;

        return true;
    }

    // DFS to check descendants
    private void checkDescendants(int u, List<Integer> lockedList) {
        for (int v : children[u]) {
            if (lockedBy[v] != 0) {
                lockedList.add(v);
            }
            checkDescendants(v, lockedList);
        }
    }
}

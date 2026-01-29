package leetcode.P863_AllNodesDistanceKInBinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    Map<TreeNode, TreeNode> parents = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParentMap(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int dist = 0;
        while (!queue.isEmpty() && dist < k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                TreeNode[] neighbors = { curr.left, curr.right, parents.get(curr) };
                for (TreeNode next : neighbors) {
                    if (next != null && !visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            dist++;
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty())
            res.add(queue.poll().val);
        return res;
    }

    private void buildParentMap(TreeNode child, TreeNode parent) {
        if (child == null)
            return;
        parents.put(child, parent);
        buildParentMap(child.left, child);
        buildParentMap(child.right, child);
    }
}

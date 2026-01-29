package leetcode.P545_BoundaryOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
            return result;

        result.add(root.val);
        if (root.left == null && root.right == null)
            return result;

        // Add left boundary (excluding leaves)
        // Thêm biên trái (loại trừ các lá)
        addLeftBoundary(root.left);

        // Add leaves
        // Thêm các lá
        addLeaves(root);

        // Add right boundary (excluding leaves and root, reversed)
        // Thêm biên phải (loại trừ các lá và gốc, đảo ngược)
        addRightBoundary(root.right);

        return result;
    }

    private void addLeftBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null))
            return;
        result.add(node.val);
        if (node.left != null)
            addLeftBoundary(node.left);
        else
            addLeftBoundary(node.right);
    }

    private void addLeaves(TreeNode node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null && node != null) { // node != root check handled via traversal logic
                                                                       // usually or explicitly
            // Actually `node != root` check is complex if passed original root.
            // However, if we enter `addLeaves` with root, we will add root if it is a leaf.
            // But line 34 filters root-only case.
            // For recursive calls, we just need to ensure we don't duplicate root.
            // But `root` is already added. Ideally we start recursion from children.
            // Let's refine: `addLeaves` simply adds leaves. We handle `root` separately.
        }
        // Correct logic:
        // Left boundary: root.left ...
        // Leaves: DFS from root (skipping root itself if it's not a leaf? No, root is
        // never a leaf in boundary definition context unless single node).

        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        if (node.left != null)
            addLeaves(node.left);
        if (node.right != null)
            addLeaves(node.right);
    }

    // Custom wrapper for addLeaves to skip root check confusion
    // Trình bao bọc tùy chỉnh cho addLeaves để bỏ qua sự nhầm lẫn khi kiểm tra root
    private void addLeavesWrapper(TreeNode node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            // Don't add if it's the root itself? No, `result.add(root.val)` is done.
            // But if `root` is a single node, it is added at start.
            // If `root` has children, it is NOT a leaf.
            result.add(node.val);
            return;
        }
        addLeavesWrapper(node.left);
        addLeavesWrapper(node.right);
    }

    // Retrying clean implementation logic
    // Thử lại logic triển khai sạch sẽ
    public List<Integer> boundaryOfBinaryTree_Clean(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);

        // Left Boundary
        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur != null) {
                if (cur.left != null || cur.right != null)
                    res.add(cur.val);
                if (cur.left != null)
                    cur = cur.left;
                else
                    cur = cur.right;
            }
        }

        // Leaves
        addLeaves(res, root);
        // Remove root from leaves if it was added (only happens if single node, but
        // single node handled separately or loop doesn't run)
        // If single node [1], added at start. addLeaves adds [1]. Size 2?
        // If single node, left boundary loop doesn't run. `addLeaves` adds it.
        // We need to exclude root from addLeaves.

        // Right Boundary
        if (root.right != null) {
            List<Integer> temp = new ArrayList<>();
            TreeNode cur = root.right;
            while (cur != null) {
                if (cur.left != null || cur.right != null)
                    temp.add(cur.val);
                if (cur.right != null)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
            for (int i = temp.size() - 1; i >= 0; i--) {
                res.add(temp.get(i));
            }
        }
        return res;
    }

    // Correct helper for leaves excluding root
    private void addLeaves(List<Integer> res, TreeNode root) {
        if (root.left == null && root.right == null) {
            // Only add if not the main root
            // Chỉ thêm nếu không phải là gốc chính
            // But we don't have reference to main root easily.
            // Simplified: The caller handles root. Leaves traversal starts from children.
            return;
        }
        addLeavesReal(res, root);
    }

    private void addLeavesReal(List<Integer> res, TreeNode node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        addLeavesReal(res, node.left);
        addLeavesReal(res, node.right);
    }

    // Official implementation consolidating
    public List<Integer> boundaryOfBinaryTree_Final(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        if (root.left == null && root.right == null)
            return res; // Single node case

        // Left Boundary
        TreeNode t = root.left;
        while (t != null) {
            if (t.left != null || t.right != null) {
                res.add(t.val);
            }
            if (t.left != null)
                t = t.left;
            else
                t = t.right;
        }

        // Leaves
        addLeavesInternal(res, root);

        // Right Boundary
        List<Integer> rightList = new ArrayList<>();
        t = root.right;
        while (t != null) {
            if (t.left != null || t.right != null) {
                rightList.add(t.val);
            }
            if (t.right != null)
                t = t.right;
            else
                t = t.left;
        }
        for (int i = rightList.size() - 1; i >= 0; i--) {
            res.add(rightList.get(i));
        }

        return res;
    }

    private void addLeavesInternal(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        addLeavesInternal(res, root.left);
        addLeavesInternal(res, root.right);
    }
}

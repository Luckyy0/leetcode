package leetcode.P1305_AllElementsInTwoBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        return merge(list1, list2);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        int n1 = list1.size(), n2 = list2.size();

        while (i < n1 && j < n2) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }

        while (i < n1)
            res.add(list1.get(i++));
        while (j < n2)
            res.add(list2.get(j++));

        return res;
    }
}

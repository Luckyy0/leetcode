package leet_code.Problem_366_Medium_Find_Leaves_of_Binary_Tree;

import java.util.ArrayList;
import java.util.List;

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

public class Solution_DFS {

    /**
     * Collects leaves layer by layer.
     * Uses node height (distance from bottom).
     * Time: O(N), Space: O(H).
     * 
     * Thu thập các lá theo từng lớp.
     * Sử dụng chiều cao của nút (khoảng cách từ dưới lên).
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        getHeight(root, res);
        return res;
    }

    private int getHeight(TreeNode node, List<List<Integer>> res) {
        if (node == null)
            return -1;

        int height = 1 + Math.max(getHeight(node.left, res), getHeight(node.right, res));

        // Ensure result list has a sub-list for the current height layer
        // Đảm bảo danh sách kết quả có một danh sách phụ cho lớp chiều cao hiện tại
        if (res.size() == height) {
            res.add(new ArrayList<>());
        }

        res.get(height).add(node.val);
        return height;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Leaves: " + solution.findLeaves(root)); // [[4, 5, 3], [2], [1]]
    }
}

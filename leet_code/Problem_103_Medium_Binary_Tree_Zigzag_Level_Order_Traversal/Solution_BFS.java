package leet_code.Problem_103_Medium_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.*;

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

public class Solution_BFS {

    /**
     * Traverses the binary tree in zigzag level order.
     * Alternates the insertion direction for each level.
     * Duyệt cây nhị phân theo thứ tự tầng hình zigzag.
     * Luân phiên hướng chèn cho mỗi tầng.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Use LinkedList to efficiently add at either end
            // Sử dụng LinkedList để thêm vào hai đầu một cách hiệu quả
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    currentLevel.addLast(node.val);
                } else {
                    currentLevel.addFirst(node.val);
                }

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // Toggle direction
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test Case 1: " + solution.zigzagLevelOrder(t1));
        // Expected: [[3], [20, 9], [15, 7]]

        // Test Case 2: [1]
        System.out.println("Test Case 2: " + solution.zigzagLevelOrder(new TreeNode(1)));
        // Expected: [[1]]

        // Test Case 3: []
        System.out.println("Test Case 3: " + solution.zigzagLevelOrder(null));
        // Expected: []
    }
}

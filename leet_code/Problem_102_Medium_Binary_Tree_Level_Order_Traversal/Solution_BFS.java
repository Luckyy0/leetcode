package leet_code.Problem_102_Medium_Binary_Tree_Level_Order_Traversal;

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
     * Traverses the binary tree level by level.
     * Uses a Queue for Breadth-First Search (BFS).
     * Duyệt cây nhị phân theo từng tầng.
     * Sử dụng Hàng đợi cho Tìm kiếm theo chiều rộng (BFS).
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                // Add left and right children to queue for the next level
                // Thêm con bên trái và bên phải vào hàng đợi cho tầng tiếp theo
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test Case 1: " + solution.levelOrder(t1));
        // Expected: [[3], [9, 20], [15, 7]]

        // Test Case 2: [1]
        System.out.println("Test Case 2: " + solution.levelOrder(new TreeNode(1)));
        // Expected: [[1]]

        // Test Case 3: []
        System.out.println("Test Case 3: " + solution.levelOrder(null));
        // Expected: []
    }
}

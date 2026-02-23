package leet_code.Problem_107_Medium_Binary_Tree_Level_Order_Traversal_II;

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
     * Traverses the binary tree level-by-level from bottom to top.
     * Uses a standard BFS with reverse insertion into the result list.
     * Duyệt cây nhị phân theo từng tầng từ dưới lên trên.
     * Sử dụng BFS tiêu chuẩn với việc chèn ngược vào danh sách kết quả.
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Using LinkedList because addFirst is O(1)
        // Sử dụng LinkedList vì addFirst có độ phức tạp O(1)
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                // Add children for the next level
                // Thêm các nút con cho tầng tiếp theo
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            // Insert at the beginning of the list to achieve bottom-up order
            // Chèn vào đầu danh sách để đạt được thứ tự từ dưới lên
            result.addFirst(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test Case 1: " + solution.levelOrderBottom(t1));
        // Expected: [[15, 7], [9, 20], [3]]

        // Test Case 2: [1]
        System.out.println("Test Case 2: " + solution.levelOrderBottom(new TreeNode(1)));
        // Expected: [[1]]

        // Test Case 3: []
        System.out.println("Test Case 3: " + solution.levelOrderBottom(null));
        // Expected: []
    }
}

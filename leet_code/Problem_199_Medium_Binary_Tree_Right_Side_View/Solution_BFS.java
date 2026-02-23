package leet_code.Problem_199_Medium_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
     * Returns the values of the nodes you can see from the right side.
     * Uses Level Order Traversal (BFS) to capture the last node of each level.
     * Time: O(N), Space: O(W).
     * 
     * Trả về giá trị của các nút có thể nhìn thấy từ bên phải.
     * Sử dụng Duyệt theo tầng (BFS) để lấy nút cuối cùng của mỗi tầng.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If it's the last node in the current level, add to result
                // Nếu là nút cuối cùng trong tầng hiện tại, thêm vào kết quả
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: [1,2,3,null,5,null,4] -> [1,3,4]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println("Right View 1: " + solution.rightSideView(root1));

        // Test Case 2: [1,null,3] -> [1,3]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println("Right View 2: " + solution.rightSideView(root2));
    }
}

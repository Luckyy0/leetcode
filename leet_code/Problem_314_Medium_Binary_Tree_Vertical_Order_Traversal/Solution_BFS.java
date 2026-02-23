package leet_code.Problem_314_Medium_Binary_Tree_Vertical_Order_Traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution_BFS {

    private static class NodeColumn {
        TreeNode node;
        int col;

        NodeColumn(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    /**
     * Vertical order traversal using BFS.
     * Time: O(N), Space: O(N).
     * 
     * Duyệt theo thứ tự dọc sử dụng BFS.
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;

        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<NodeColumn> queue = new LinkedList<>();
        int minCol = 0;
        int maxCol = 0;

        queue.add(new NodeColumn(root, 0));

        while (!queue.isEmpty()) {
            NodeColumn curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col;

            if (!columnTable.containsKey(col)) {
                columnTable.put(col, new ArrayList<>());
            }
            columnTable.get(col).add(node.val);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (node.left != null) {
                queue.add(new NodeColumn(node.left, col - 1));
            }
            if (node.right != null) {
                queue.add(new NodeColumn(node.right, col + 1));
            }
        }

        // Collect results from minCol to maxCol
        for (int i = minCol; i <= maxCol; i++) {
            // It's guaranteed that map contains keys in this range for continuous tree
            // (Wait, actually if tree is disjoint... but it's a single tree)
            // Cây liên thông, nhưng có thể có các cột trống nếu cây rẽ nhánh rộng?
            // Không, vì cây luôn kết nối, để đi từ col 0 đến col 2 phải qua col 1.
            if (columnTable.containsKey(i)) {
                output.add(columnTable.get(i));
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Vertical Order 1: " + solution.verticalOrder(root));
        // [[9], [3, 15], [20], [7]]
    }
}

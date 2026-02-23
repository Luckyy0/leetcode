package leet_code.Problem_257_Easy_Binary_Tree_Paths;

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
     * Finds all root-to-leaf paths.
     * Uses DFS with String concatenation.
     * Time: O(N), Space: O(H).
     * 
     * Tìm tất cả các đường dẫn từ gốc đến lá.
     * Sử dụng DFS với nối chuỗi.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            searchPaths(root, "", paths);
        }
        return paths;
    }

    private void searchPaths(TreeNode node, String path, List<String> paths) {
        path += Integer.toString(node.val);

        // If leaf node, add path to result
        // Nếu là nút lá, thêm đường dẫn vào kết quả
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            // Not a leaf, continue traversal
            // Không phải lá, tiếp tục duyệt
            path += "->";
            if (node.left != null) {
                searchPaths(node.left, path, paths);
            }
            if (node.right != null) {
                searchPaths(node.right, path, paths);
            }
        }
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Test Case 1: [1,2,3,null,5] -> ["1->2->5", "1->3"]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println("Paths 1: " + solution.binaryTreePaths(root));

        // Test Case 2: [1] -> ["1"]
        TreeNode root2 = new TreeNode(1);
        System.out.println("Paths 2: " + solution.binaryTreePaths(root2));
    }
}

package leet_code.Problem_111_Easy_Minimum_Depth_Of_Binary_Tree;

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

public class Solution_Recursive {

    /**
     * Finds the minimum depth of a binary tree.
     * The minimum depth is the number of nodes along the shortest path
     * from the root node down to the nearest leaf node.
     * 
     * Tìm chiều sâu tối thiểu của một cây nhị phân.
     * Chiều sâu tối thiểu là số lượng nút dọc theo con đường ngắn nhất
     * từ nút gốc xuống nút lá gần nhất.
     */
    public int minDepth(TreeNode root) {
        // Base case: If the tree is empty, depth is 0
        // Trường hợp cơ sở: Nếu cây trống, chiều sâu là 0
        if (root == null) {
            return 0;
        }

        // If it's a leaf node, depth is 1
        // Nếu là nút lá, chiều sâu là 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If left child is null, we must recurse into the right child
        // Nếu con bên trái null, chúng ta phải đệ quy vào con bên phải
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // If right child is null, we must recurse into the left child
        // Nếu con bên phải null, chúng ta phải đệ quy vào con bên trái
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both children exist, take the minimum of their depths plus 1
        // Nếu cả hai con đều tồn tại, lấy giá trị nhỏ nhất trong chiều sâu của chúng
        // cộng 1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: [3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test Case 1 Min Depth: " + solution.minDepth(t1));
        // Expected: 2 (Path: 3 -> 9)

        // Test Case 2: Skewed tree [2,null,3,null,4,null,5,null,6]
        TreeNode t2 = new TreeNode(2, null,
                new TreeNode(3, null,
                        new TreeNode(4, null,
                                new TreeNode(5, null,
                                        new TreeNode(6)))));
        System.out.println("Test Case 2 Min Depth: " + solution.minDepth(t2));
        // Expected: 5 (Root is not a leaf, must reach the end)
    }
}

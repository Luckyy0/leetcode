package leet_code.Problem_450_Medium_Delete_Node_in_a_BST;

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
     * Deletes a node with key from BST.
     * Strategy: Standard recursive BST deletion with successor replacement.
     * Time: O(H), Space: O(H).
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node found!
            // Case 1 & 2: 0 or 1 child
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            // Case 3: 2 children
            // Find inorder successor (min in right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            // Delete the successor
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();
        // Construct BST: 5 [3 [2, 4], 6 [null, 7]]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        root.right = new TreeNode(6, null, new TreeNode(7));

        TreeNode result = solution.deleteNode(root, 3);
        System.out.println("New root left child val (expected 4 or 2): " + result.left.val);
    }
}

package leet_code.Problem_114_Medium_Flatten_Binary_Tree_To_Linked_List;

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

public class Solution_Iterative {

    /**
     * Flattens a binary tree into a linked list in-place.
     * Uses the Morris traversal logic to achieve O(1) space.
     * 
     * Làm phẳng một cây nhị phân thành danh sách liên kết tại chỗ.
     * Sử dụng logic duyệt Morris để đạt được không gian O(1).
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            // If the current node has a left child
            // Nếu nút hiện tại có con bên trái
            if (curr.left != null) {
                // Find the rightmost node in the left subtree
                // Tìm nút ngoài cùng bên phải trong cây con bên trái
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect the original right subtree to the rightmost node of left subtree
                // Nối cây con bên phải ban đầu vào nút ngoài cùng bên phải của cây con bên trái
                prev.right = curr.right;

                // Move the left subtree to be the right child
                // Chuyển cây con bên trái sang làm con bên phải
                curr.right = curr.left;
                curr.left = null; // Set left child to null as per requirement
            }

            // Move to the next node in the right branch
            // Di chuyển đến nút tiếp theo trong nhánh bên phải
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: [1,2,5,3,4,null,6]
        TreeNode t1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));

        solution.flatten(t1);

        // Printing results
        System.out.println("Flattened Tree (Right branch):");
        TreeNode temp = t1;
        while (temp != null) {
            System.out.print(temp.val + (temp.right != null ? " -> " : ""));
            temp = temp.right;
        }
        // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    }
}

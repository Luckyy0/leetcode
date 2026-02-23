package leet_code.Problem_998_Medium_Maximum_Binary_Tree_II;

/**
 * Definition for a binary tree node.
 */
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

/**
 * Problem 998: Maximum Binary Tree II
 * https://leetcode.com/problems/maximum-binary-tree-ii/
 */
public class Solution {

    /**
     * Inserts a value into a Maximum Binary Tree.
     * Strategy: Recursion along the rightmost path.
     * 
     * @param root The root of the original tree.
     * @param val  The value to append.
     * @return The new root of the tree.
     * 
     *         Tóm tắt chiến lược:
     *         1. Nắm được logic xây dựng Cây Nhị phân Lớn nhất từ mảng gốc:
     *         - Giá trị lớn nhất trong mảng sẽ là `root`.
     *         - Các phần tử bên TRÁI mảng của `root` sẽ hình thành cây con TRÁI.
     *         - Các phần tử bên PHẢI mảng của `root` sẽ hình thành cây con PHẢI.
     *         2. Đề bài yêu cầu NỐI (appended) `val` vào CUỐI mảng gốc.
     *         Điều này có nghĩa là `val` nằm ở cực Phải của mảng. Dẫn đến việc
     *         `val` sẽ LUÔN được thêm vào đâu đó trên nhánh PHẢI CÙNG (rightmost
     *         path) của cây.
     *         3. Xét 2 trường hợp chính:
     *         - Trường hợp 1: Nếu `val > root.val`.
     *         Tại đây, `val` là phần tử lớn nhất. Nó sẽ trở thành Gốc mới.
     *         Do mảng cũ hoàn toàn nằm bên Trái của `val`, toàn bộ Cây cũ sẽ trở
     *         thành con Trái của Gốc mới. Trả về Gốc mới.
     *         - Trường hợp 2: Nếu `val < root.val`.
     *         Nút `root` hiện tại LỚN HƠN `val` nên nó vẫn giữ danh hiệu Cực lớn và
     *         không thay đổi.
     *         Tuy nhiên, nút `val` vẫn nằm ở cuối mảng (bên Phải của `root`).
     *         Vì vậy, ta phải tiếp tục thực hiện việc CHÈN `val` vào vùng cây con
     *         Phải của `root`.
     *         Ta gọi đệ quy: `root.right = insertIntoMaxTree(root.right, val)`.
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // Base case: we reached a leaf's right child (or an empty tree)
        if (root == null) {
            return new TreeNode(val);
        }

        // Scenario 1: The new value is greater than the current root
        // It becomes the new root, and the old tree goes to the left.
        if (val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        // Scenario 2: The new value is smaller than current root
        // It must be inserted into the right subtree (rightmost path).
        root.right = insertIntoMaxTree(root.right, val);

        // Return original root, knowing its right subtree is properly updated
        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Input: root = [4,1,3,null,null,2], val = 5
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(2);

        TreeNode result1 = sol.insertIntoMaxTree(root1, 5);
        System.out.println("Result 1 Root: " + result1.val); // 5 (with left child 4)
    }
}

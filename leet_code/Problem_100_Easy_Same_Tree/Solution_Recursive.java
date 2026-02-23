package leet_code.Problem_100_Easy_Same_Tree;

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
     * Checks if two binary trees are exactly the same.
     * Uses a recursive approach.
     * Kiểm tra xem hai cây nhị phân có hoàn toàn giống nhau không.
     * Sử dụng phương pháp đệ quy.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are the same
        // Nếu cả hai nút đều null, chúng giống nhau
        if (p == null && q == null) {
            return true;
        }

        // If one is null or values are different, they are not the same
        // Nếu một nút null hoặc giá trị khác nhau, chúng không giống nhau
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Recursively check left and right subtrees
        // Kiểm tra đệ quy các cây con bên trái và bên phải
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: [1,2,3], [1,2,3]
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 1: " + solution.isSameTree(p1, q1));
        // Expected: true

        // Test Case 2: [1,2], [1,null,2]
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Test Case 2: " + solution.isSameTree(p2, q2));
        // Expected: false

        // Test Case 3: [1,2,1], [1,1,2]
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println("Test Case 3: " + solution.isSameTree(p3, q3));
        // Expected: false
    }
}

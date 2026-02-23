package leet_code.Problem_988_Medium_Smallest_String_Starting_From_Leaf;

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
 * Problem 988: Smallest String Starting From Leaf
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 */
public class Solution {

    // Initialize with a character that is lexicographically larger than 'z'
    private String ans = "~";

    /**
     * Finds the lexicographically smallest string from leaf to root.
     * Strategy: DFS with backtracking and String Reverse.
     * 
     * @param root The root of the binary tree.
     * @return Lexicographically smallest string.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ta duyệt sâu (DFS) từ gốc xuống các lá. Ở mỗi bước, ta ghép ký tự
     *         hiện tại vào `StringBuilder`.
     *         2. Giá trị nút là số từ 0 đến 25, chuyển thành ký tự từ 'a' đến 'z'
     *         bằng `(char) ('a' + node.val)`.
     *         3. Khi chạm đến nút lá (cả hai con đều null), nghĩa là ta đã có 1
     *         đường đi hoàn chỉnh từ gốc xuống lá.
     *         4. Ta tạo chuỗi đảo ngược từ `StringBuilder` để có đường đi từ LÁ lên
     *         GỐC.
     *         5. So sánh chuỗi vừa tạo với kết quả nhỏ nhất hiện tại `ans`. Nếu nhỏ
     *         hơn, cập nhật `ans`.
     *         6. Sau mỗi lời gọi đệ quy trở về, xóa ký tự hiện tại khỏi
     *         `StringBuilder` (backtracking) để duyệt nhánh khác.
     */
    public String smallestFromLeaf(TreeNode root) {
        ans = "~";
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        // Base case null node
        if (node == null) {
            return;
        }

        // Add current node's character
        char c = (char) ('a' + node.val);
        sb.append(c);

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            // Reverse current path to get leaf-to-root, then compare
            String path = new StringBuilder(sb).reverse().toString();
            if (path.compareTo(ans) < 0) {
                ans = path;
            }
        } else {
            // Otherwise, keep traversing
            dfs(node.left, sb);
            dfs(node.right, sb);
        }

        // Backtrack (remove current character)
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(4);

        System.out.println("Result: " + sol.smallestFromLeaf(root1)); // "dba"
    }
}

package leet_code.Problem_1008_Medium_Construct_Binary_Search_Tree_from_Preorder_Traversal;

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
 * Problem 1008: Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class Solution {
    // Biến toàn cục (Global pointer) dùng để theo dõi vị trí hiện tại trong mảng
    // preorder
    private int i = 0;

    /**
     * Constructs a binary search tree from a preorder traversal array.
     * Strategy: Optimal Upper bound matching (O(N) time complexity).
     * 
     * @param preorder The preorder traversal array.
     * @return The root of the constructed BST.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bản chất của mảng Preorder là `[Gốc, Nhánh con Trái, Nhánh con
     *         Phải]`.
     *         2. Vì đây là "Cây tìm kiếm nhị phân" (BST), mọi phần tử thuộc nhánh
     *         con Trái phải nhỏ hơn giá trị Gốc. Ngược lại, mọi phần tử ở nhánh
     *         Phải
     *         phải lớn hơn giá trị Gốc.
     *         3. Cách ngây thơ (Naive) là dùng vòng lặp dò tìm điểm cắt chia đôi
     *         phần nhỏ hơn và lớn hơn, cắn nhai mảng. Nhưng nếu mảng đã được phân
     *         loại hoàn toàn (cây dạng danh sách liên kết), điểm lệch lặp O(N) cho
     *         từng đợt sẽ làm thuật toán thoái hóa thành O(N^2).
     *         4. Phương pháp Tối ưu (Optimal) dùng một biến `bound` (chặn trên)
     *         để hạn chế một phần tử có được thêm vào vị trí hiện tại không. Ta
     *         duy trì duy nhất một con trỏ toàn mảng `i`.
     *         5. Tạo một hàm đệ quy `buildNode(preorder, bound)`. Khi duyệt qua một
     *         phần tử:
     *         - Nếu i chạm mốc cuối hoặc giá trị tại i lớn hơn mức chặn `bound`
     *         đã thiết lập, thì không thêm node (trả về null).
     *         - Ngược lại, lấy phần tử tại i làm root và nhích i lên.
     *         - Thử gắn con trái: Giới hạn trên của con trái sẽ là `root.val`.
     *         - Thử gắn con phải: Giới hạn trên của con phải sẽ thừa kế `bound`
     *         hiện tại được truyền xuống từ lệnh gọi mẹ.
     *         6. Thuật toán "Chặn trên" duyệt trọn vẹn 1 lần (O(N)).
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        // Truyền thẳng giới hạn cực đại ban đầu (Tất cả đều nhỏ hơn giá trị này)
        return buildNode(preorder, Integer.MAX_VALUE);
    }

    private TreeNode buildNode(int[] preorder, int bound) {
        // Điều kiện dừng: Khi hết mảng, hoặc khi giá trị định chèn vượt quá chặn trên
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }

        // Tự do chèn node mới do vẫn nằm trong giới hạn và kéo con trỏ i theo
        TreeNode root = new TreeNode(preorder[i++]);

        // Đệ quy dựng nhánh trái, chặn trên bị thu hẹp bằng chính giá trị node mẹ
        root.left = buildNode(preorder, root.val);

        // Đệ quy dựng nhánh phải, chặn trên vẫn là bound cũ nhận từ trên dội xuống
        root.right = buildNode(preorder, bound);

        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] preorder1 = { 8, 5, 1, 7, 10, 12 };
        TreeNode root1 = sol.bstFromPreorder(preorder1);
        System.out.println("Result 1 Root: " + root1.val); // expected 8

        // Đặt lại i=0 trước khi chạy test case mới (nếu trong môi trường leetcode,
        // Class luôn được tạo mới object nên không cần lo, nhưng do test main nên cần)
        sol.i = 0;

        int[] preorder2 = { 1, 3 };
        TreeNode root2 = sol.bstFromPreorder(preorder2);
        System.out.println("Result 2 Root: " + root2.val); // expected 1
    }
}

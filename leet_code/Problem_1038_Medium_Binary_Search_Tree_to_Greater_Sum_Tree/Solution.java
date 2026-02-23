package leet_code.Problem_1038_Medium_Binary_Search_Tree_to_Greater_Sum_Tree;

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
 * Problem 1038: Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * Note: This question is the same as 538:
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class Solution {

    // Kho Tàng Tích Luỹ Máu Thánh - Mang sứ mệnh Góp Nhặt Tổng Của Những Kẻ Lớn Hơn
    private int globalSum = 0;

    /**
     * Converts a BST to a Greater Sum Tree.
     * Strategy: Reverse In-Order Traversal (Right -> Node -> Left) in O(N) time.
     * 
     * @param root The root of the BST.
     * @return The root of the modified Greater Tree.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Ép Sung Độ Độn Máu Cây - Nghịch Lý Kẻ Lớn Ướp Cho Kẻ Bé":
     *         - Bài toán kêu biến thể Trị Số Của Nút Hiện Tại thành TỔNG CHUNG
     *         giữa chính Nó và TẤT CẢ Những Đứa Còn Lại Lớn Hơn Nó!
     * 
     *         2. Điểm Mù Đáng Sợ Của Cây Tìm Kiếm Nhị Phân (BST):
     *         - Vốn dĩ BST đã phân chia Giai Cấp rành mạch: Nhánh Bên Phải (Right)
     *         Luôn Chứa Đựng Lũ "Khổng Lồ Trọng Lượng" Nhất Cây.
     *         - Góc Góc Trái Phải Là: Nếu bạn Duyệt (Cào Tóc) Cây theo Hướng
     *         "In-Order"
     *         (Trái -> Rốn -> Phải) thì Mảng Số sẽ Trải Ra Đều Tăm Táp Theo Từ Bé
     *         Đến Lớn [0, 1, 2, 3, 4, 10, 20...].
     * 
     *         3. TRICK TOÁN HỌC O(N) LẬT MÓC ĐẢO CUNG "REVERSE IN-ORDER":
     *         - Tội gì đi lết Từ Nhỏ Đến Lớn? Mình CHƠI HỆ ĐI LÙI MÓC NÉT TỪ RỄ CÂY
     *         PHẢI TRƯỚC! (Duyệt theo Hướng Đảo Phải -> Nút Giữa -> Đi Lùi Về
     *         Trái).
     *         - Cách này Giúp Việc: Bạn GẶP THẰNG BỰ NHẤT RỪNG (Max) ĐẦU TIÊN Cành.
     *         Xong Bọn Bự Nhì Đầu Thai Đằng Sau Lấy Lại Bao Trọn Tổng Túi Phồng Khí
     *         Của
     *         Thằng Bự Vĩ Đại Đi Trước Trút Xuống Lấy Tầm Ăn Ké.
     *         - Xài biến Thành Tường `globalSum` để lưu Tổng Tuỷ Đắp Lũy Kế Tăng
     *         Dần Đều
     *         Suốt Vòng Đệ Quy Xuôi Trái Chắn Móc Phải Này.
     */
    public TreeNode bstToGst(TreeNode root) {
        // Trớ Nước Mở Băng! Kẹp Sợi Dây Khời Độ Lùi (Vét Sạch Của Cải Thằng To Nhất Nắm
        // Trước)
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode node) {
        // Cụt Nguồn? Không Có Lá Chắn Che Gió Nữa -> Rút Chân Về Hồi Hồi
        if (node == null) {
            return;
        }

        // BƯỚC 1: CƯỚP ĐƯỜNG ĐÂM SÂU VÀO NHÁNH PHẢI (RIGHT) NHÓM KẺ TO XÁC LỚN MẶT CỘNG
        // SINH KHỦNG
        reverseInorder(node.right);

        // BƯỚC 2: RUNG LÚC DỪNG CHÂN ĐÍCH THÂN OAN TRÁI NÚT HẠT HIỆN TẠI (NODE)
        // Vét Thêm Thịt Và Nước Cốt Của Chính Bàn Thân Nút Cũ Ép Đè Chung Vô Cái Máng
        // Lợn Tổng Hợp
        globalSum += node.val;

        // Phế Hoặc Vết Khắc Nhựa Cũ - Tẩy Chài Đè Đuổi Bắt Gán Hình Tượng Trị Tổng
        // Khổng Lồ Mới
        node.val = globalSum;

        // BƯỚC 3: SAU KHI NO BỤNG MỚI CHUYỂN RẼ QUÉT SANG ĐÁM ĐẺ NHÁNH TRÁI (LEFT) NHỎ
        // BÉ ỐM NHOM BÚ MÚT SAU
        reverseInorder(node.left);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Manual Test Tree Build: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        TreeNode gstRoot = sol.bstToGst(root);

        // Verification - Should be 30 for root
        System.out.println("New Root Val: " + gstRoot.val); // expected 30

        // Verification - Should be 36 for left child
        System.out.println("Modified Left Child: " + gstRoot.left.val); // expected 36

        // Verification - Should be 21 for right child
        System.out.println("Modified Right Child: " + gstRoot.right.val); // expected 21
    }
}

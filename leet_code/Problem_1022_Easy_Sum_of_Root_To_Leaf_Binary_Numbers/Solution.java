package leet_code.Problem_1022_Easy_Sum_of_Root_To_Leaf_Binary_Numbers;

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
 * Problem 1022: Sum of Root To Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class Solution {

    /**
     * Calculates the sum of all binary numbers represented by root-to-leaf paths.
     * Strategy: Optimal DFS with Bitwise Left-Shift Accumulator.
     * 
     * @param root The root of the binary tree.
     * @return The total sum of the numbers.
     * 
     *         Tóm tắt chiến lược:
     *         1. Muốn dò từ Gốc xuống thẳng tới 1 cái Lá và ghi nhớ toàn bộ Dấu
     *         Chân
     *         đã đi qua (Thứ Tự của Dấu Chân ghép lại thành Khối Nhị Phân).
     *         2. Cách ngây thơ là Vừa đi Vừa Cộng Chuỗi String: "1" -> "10" ->
     *         "101".
     *         Gặp Lá thì xài búa tạ của Java đập vụn chuỗi Thập phân:
     *         `Integer.parseInt("101", 2)` để moi ruột ra số 5.
     *         - Tác Hại Khôn Lường: Ghép chuỗi đẻ mẻ tạo Rác Đối tượng liên tục
     *         trên
     *         bản đồ RAM. Bước dịch chuỗi ParseInt thì rùa bò, tốn kém thời gian
     *         O(N).
     *         3. Cách Tối Ưu Giải Phẫu: Giải Nhị phân Bằng Chính Hệ Nhị Phân Gốc
     *         (Bitwise).
     *         - Số Nhị Phân mang tính kế thừa (Ví dụ: 101 tức là số 5). Nếu mình
     *         ngoắc
     *         thêm thằng số 1 vào đuôi Thành 1011 (tức là 11).
     *         - Chuyện gì xảy ra với số 5? Nó bị NGƯỜI TA Nhân Đôi (* 2) Lên là
     *         Thành 10,
     *         rồi lại BUNG 1 (+ 1) thì ra đúng 11!
     *         -> QUY LUẬT THẦN THÁNH: `Số Hiện Tại = Số Cũ * 2 + Bit_Mới`.
     *         - Còn xài Phép Tinh Túy Của Cấp Bậc Cao Nhất CPU: DỊCH BIT TRÁI 1
     *         BƯỚC (<< 1)
     *         thay cho nhân đôi.
     *         `Số Hiện Tại = (Số Cũ << 1) | Bit_Mới`
     *         4. Thay vì chuyền chuỗi chữ, ta ném Độc 1 cái Cục Số Nguyên gánh Team
     *         truyền tay từ trên Đệ Quy thả tụt thẳng xuống vực sâu (Rất Nhẹ!).
     *         Gặp Tán Lá (Nút vô sinh)? Ngay tức khắc Hồi Báo Trả Ngược Giá Trị
     *         Thập Phân Đã
     *         nặn thành khối xong!
     */
    public int sumRootToLeaf(TreeNode root) {
        // Phất cờ chạy mảng Đệ quy, Nhét cho nó 1 cái bị rỗng chứa Số 0
        return dfsSum(root, 0);
    }

    private int dfsSum(TreeNode node, int currentAccumulator) {
        // Bước chân rơi vào vực thẳm do Tán Lá Cụt Đường
        if (node == null) {
            return 0;
        }

        // Tích Tụ Dấu Chân: Ép Nhị Phân Mới nhảy vào
        // << 1 bằng với việc X 2 đẩy toàn đội lên 1 Cấp.
        // | (hoặc +) chèn gọn giá trị Bit của cái Nút đứng hiện tại (0 hoặc 1) vô Đuôi
        currentAccumulator = (currentAccumulator << 1) | node.val;

        // Bắt trúng Nút Lá Thuần Khiết (Node không có rễ cành Trái, Trắng Phải)
        if (node.left == null && node.right == null) {
            // Nhả ra viên Dạ Minh Châu Thập Phân đã luyện xong !
            return currentAccumulator;
        }

        // Chưa đi đến bến bờ thì Lôi Nhánh Cành Trái cấy Cộng Sinh rịt tiếp Nhánh Cành
        // Phải
        // Hai quả cầu tuyết sẽ lăn to độc lập không chạm nhau, và hội tụ Cộng chung Mẻ
        return dfsSum(node.left, currentAccumulator) + dfsSum(node.right, currentAccumulator);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Cây: [1,0,1,0,1,0,1]
        /*
         * 1
         * / \
         * 0 1
         * / \ / \
         * 0 1 0 1
         */
        TreeNode root1 = new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        System.out.println("Result 1: " + sol.sumRootToLeaf(root1)); // expected 22

        // Cây: [0]
        TreeNode root2 = new TreeNode(0);
        System.out.println("Result 2: " + sol.sumRootToLeaf(root2)); // expected 0
    }
}

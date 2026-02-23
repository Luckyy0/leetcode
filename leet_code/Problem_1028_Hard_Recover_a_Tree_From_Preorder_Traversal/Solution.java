package leet_code.Problem_1028_Hard_Recover_a_Tree_From_Preorder_Traversal;

import java.util.Stack;

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
 * Problem 1028: Recover a Tree From Preorder Traversal
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 */
public class Solution {

    /**
     * Recovers a binary tree from a preorder traversal string with depth dashes.
     * Strategy: Optimal Iterative Monotonic Depth Stack (O(N) time).
     * 
     * @param traversal The preorder string representation of the tree.
     * @return The root of the recovered binary tree.
     * 
     *         Tóm tắt chiến lược:
     *         1. Chuỗi Preorder duyệt kham khổ theo Đạo lý Thét ra lửa từ Xưa:
     *         "Cha trước -> Cháu đích tôn bên Trái -> Con rơi rớt bên Phải".
     *         Đặc quyền số gạch ngang `-` ám chỉ Hệ Trục Sâu `Depth`. Cha ở Tầng D
     *         thì 100% hai đứa Con ruột phải cùng thụt xuống Tầng D + 1.
     *         (Lưu ý 2 Con Rút Vòi thụt hệt nhau, Phải nhìn Tấm Bản Đồ mới biết
     *         Mạch rẽ).
     *         2. Chống Chỉ Định (Kém Cỏi): Dùng Đệ quy dùng búa Tạ gọt Đẽo Cắt
     *         Chuỗi
     *         Mảng Mẹ (substring). Xé nát Chuỗi là đại họa rác rưởi O(N^2) Bộ nhớ
     *         JVM!
     *         3. Tuyệt Kỹ Đẳng Cấp Ánh Sáng (Stack Sinh Tồn):
     *         - Gác cái Cột Ống Khói Ngăn Xếp (`Stack`) lên Ngai. Cột này yểm trợ
     *         như Linh Hồn Rễ Truyền từ Gốc kéo cái Nòng sâu xuống hệt 1 tia Sét
     *         chĩa đâm xuống cắm đúng Thằng Cụ Tổ Mới Sinh Ra Ở Chóp.
     *         - Tức là Độ Sâu của thằng Chóp (số vạch `-`) Mặc định Ngang Lệ với
     *         Khối Lượng Số Thằng Ôm kẹt trong Ống Khói Cột (Kích thước
     *         `stack.size()`).
     *         4. Hành Trình Tráng Miệng: Lướt ngón tay 1 phát duy nhất (O(N))!
     *         - Đếm số gạch `-` gom lại ra được Trục Sâu Bể Đáy (`currentDepth`).
     *         - Gộp các Ký tự `Digit` lòi ra được Cục Giá trị To (`val`), Nặn ra
     *         Cây `Node`.
     *         - Phán Xử Thừa Kế:
     *         Nếu `stack.size() > currentDepth` ? Ấy dà! Ống Cột dãn thòng lọng đút
     *         sập
     *         Mái Vòm qua mấy Đời Sương Mù của một Cái Nhánh Nào Đó Xưa Cũ Đã Tuyệt
     *         Tự rồi!
     *         Lôi cổ `pop()` đá rớt những thằng cha chú Cụt Lá ở dưới Đáy Bảng, Tụt
     *         Cho Tới Khi Đội Hình Rút Gọn Cứng Chuẩn `stack.size() ==
     *         currentDepth`.
     *         => Thì Lòi Rụng Ra Đứa Nằm Đỉnh Cột Đích Thiệt LÀ CHA MẸ RUỘT CỦA CÁI
     *         `NODE` NÀY!
     *         - Nhét Vú Cho Bú: Moi Mẹ ở Đỉnh `stack.peek()`. Nếu 2 vú Mẹ rỗng? Ưu
     *         tiên
     *         Nhét Mồm Đứa Bé vào Vú Trái (`parent.left`). Lỡ Trái Bú Căng Đầy rồi?
     *         Nhét
     *         Tạm Chỗ Trống Lỗ Phải (`parent.right`). Hoàn chỉnh.
     *         - Cuối Cùng Dựng Thằng Bé Làm Trụ Cắm Cờ Lên Cột.
     */
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        int n = traversal.length();

        while (i < n) {
            // Bước 1: Trắc địa đo độ lún chôn móng bằng Cuốc Ép Vạch Ngang '-'
            int currentDepth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                currentDepth++;
                i++;
            }

            // Bước 2: Bóp cổ Nhấn Lệnh Hồn Nhập Xác thành Chữ Số Toán Học Xịn
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            // Gieo mầm Bào Thai Cây Nút Mới Keng Tinh Tuý
            TreeNode node = new TreeNode(val);

            // Bước 3: Thuật Khớp Trục Bánh Răng Chiều Sâu Stack
            // Vác Cưa Gọt Lóc Sạch Nhưng Thằng Đảo Chết Cụt Tàn Dư Xưa Cũ Đâm Sai Cột!
            while (stack.size() > currentDepth) {
                stack.pop();
            }

            // Bước 4: Khám Phả Hệ, Móc Rốn Nhận Ruột Thịt Chui Cửa Sinh Cửa Tử
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek(); // Lãnh Đạo Mẫu Hậu Tối Cao Lòi Lộ Ra

                // Luật Cha Chú: Đội Con Côi Trái Trước Nếu Vắng
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    // Cây Vú Trái no thì Kẹp Vú Phải!
                    parent.right = node;
                }
            }

            // Sinh Linh Mới Bò Trèo Lên Ngai Trụ Đỉnh Nhọn Ngồi Canh Chờ Con Phái Tiếp Theo
            // Xuất Thế
            stack.push(node);
        }

        // Tàn Buổi Thi Đấu! Đi Móc Nòng Gục Đáy: Mẹ Thiên Hạ Già Lão Ngứa Nằm Cùng Bể
        // Sâu Chính Cốt Tử ROOT!
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}

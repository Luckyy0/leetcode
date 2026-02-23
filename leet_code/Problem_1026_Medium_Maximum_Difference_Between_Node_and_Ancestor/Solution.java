package leet_code.Problem_1026_Medium_Maximum_Difference_Between_Node_and_Ancestor;

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
 * Problem 1026: Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class Solution {

    /**
     * Finds the maximum value of |a.val - b.val| where `a` is an ancestor of `b`.
     * Strategy: Optimal Top-Down Range Tracking (O(N) time & O(N) space).
     * 
     * @param root The root of the binary tree.
     * @return The maximum ancestor-descendant difference.
     * 
     *         Tóm tắt chiến lược:
     *         1. Muốn tìm độ lồi lõm chênh lệch lớn nhất giữa một Nút Chắt dưới bùn
     *         với cụ Tổ tiên tít trên cao (Trực hệ thẳng hàng).
     *         2. Cách Gà Mờ (Naive): Ở mỗi Nút đang ngự trị, nhẫn nại đi gọi đệ quy
     *         cày
     *         tất cả rễ mạng để trừ với nó. Tổn thất sức mạnh khủng khiếp O(N^2) vì
     *         cày đi xới lại hàng nghìn lần!
     *         3. Cách Bậc Thầy Truyền Kiếm (Top-Down Range):
     *         - Từ đỉnh Gốc Cây tuột dần xuống dưới Rễ, MỘT ĐỨA CHÁU chỉ LỆCH TO
     *         NHẤT
     *         khi và chỉ khi đem nó TRỪ đi Thằng Tổ Tiên CAO TO NHẤT trên cây Gia
     *         Phả,
     *         Hoặc Trừ đi Thằng Tổ Tiên LÙN TỊT NHẤT trên cây Gia Phả truyền xuống
     *         nó!
     *         4. Hành Hành:
     *         - Khoác cái Balô đeo chéo vào Đệ Quy, Bên trong nhét 2 cuốn sổ:
     *         Cuốn 1: Cụ Tổ to xác nhất (`currentMax`)
     *         Cuốn 2: Cụ Tổ lùn còi nhất (`currentMin`)
     *         - Trượt xuống Gặp bất cứ thằng Nút rễ trạm dừng nào, cập nhật 2 giá
     *         trị
     *         sổ này VÀ Nút Trạm ấy! (Thu thập gen Tổ Tiên dọn đường đi tiếp).
     *         5. Chốt Hạ Cáo Chung:
     *         - Lúc trượt dốc rớt thẳng xuống Dấu chấm Cụt Cành (Node Null = Lá
     *         rụng).
     *         Nhờ cái Balô đeo đủ nặng Mọi Thời Đại Truyền Từ Cửa Sinh Xuống Cửa
     *         Tử,
     *         Ta hùng hồn tuyên bố Độ Chênh lệch lớn nhất của nguyên cái Lộ Trình
     *         vừa
     *         đi chính là Vác cuốn sổ Max Trừ thẳng Cuốn Sổ Min: `currentMax -
     *         currentMin`.
     *         - Tổng hợp mọi đáp số ở các Cành rẽ ngã ba, nhặt Cúp Lớn Nhất Trái
     *         Đất.
     */
    public int maxAncestorDiff(TreeNode root) {
        // Tốc chiến khởi điểm đệ quy cầm chắc Cuốn Sổ gán mốc Nút Gốc Truyền Kỳ
        return dfsFindDiff(root, root.val, root.val);
    }

    private int dfsFindDiff(TreeNode node, int currentMin, int currentMax) {
        // Hết Lộ Trình rễ, sụp hầm đen! Mang Lịch Sử Gia Phả trừ cấn nhau lãnh Cúp
        if (node == null) {
            return currentMax - currentMin;
        }

        // Tích tụ Gen nạp Sổ Bìa: Bổ sung cái nút đi ngang vào bảng Mốc Kỷ Lục
        currentMax = Math.max(currentMax, node.val);
        currentMin = Math.min(currentMin, node.val);

        // Nạp Gen phóng tát xuống Rễ Cánh Trái và Rễ Cánh Phải Độc lập Tự do
        int leftDiff = dfsFindDiff(node.left, currentMin, currentMax);
        int rightDiff = dfsFindDiff(node.right, currentMin, currentMax);

        // Mở ngã Cúp Kỷ Lục Nhạn bay tìm Chim Chúa
        return Math.max(leftDiff, rightDiff);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Cây: [8,3,10,1,6,null,14,null,null,4,7,13]
        /*
         * 8
         * / \
         * 3 10
         * / \ \
         * 1 6 14
         * / \ /
         * 4 7 13
         */
        TreeNode root1 = new TreeNode(8,
                new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
        System.out.println("Result 1: " + sol.maxAncestorDiff(root1)); // expected 7 (từ |8 - 1| = 7)

        // Cây: [1,null,2,null,0,3]
        TreeNode root2 = new TreeNode(1,
                null,
                new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));
        System.out.println("Result 2: " + sol.maxAncestorDiff(root2)); // expected 3 (từ |3 - 0| = 3)
    }
}

package Problem_1059_Medium_All_Paths_from_Source_Lead_to_Destination;

import java.util.ArrayList;
import java.util.List;

/**
 * 1059. All Paths from Source Lead to Destination
 * 
 * Given the edges of a directed graph where edges[i] = [ai, bi] indicates there
 * is an edge between nodes ai and bi,
 * and two nodes source and destination of this graph, determine whether or not
 * all paths starting from source
 * eventually, end at destination, that is:
 * 
 * - At least one path exists from the source node to the destination node
 * - If a path exists from the source node to a node with no outgoing edges,
 * then that node is equal to destination.
 * - The number of possible paths from source to destination is a finite number
 * (no cycles allowed).
 */
public class Solution {

    /**
     * Thuật toán: Tìm kiếm theo chiều sâu (DFS) với mảng đánh dấu 3 màu (3-State
     * Color Marking).
     * Bài toán yêu cầu đồ thị phải thoả mãn 2 điều tối kỵ:
     * 1. Không có chu trình (vòng lặp).
     * 2. Mọi điểm dừng cuối (sink node - đỉnh không có đường đi ra) đều PHẢI LÀ
     * đích (destination).
     * 
     * Cách giải:
     * Sử dụng mảng 'states' lưu trạng thái của từng đỉnh:
     * - 0 (WHITE): Đỉnh chưa được viếng thăm.
     * - 1 (GRAY): Đỉnh đang được duyệt (đang nằm trong Call Stack của DFS). Nếu gặp
     * lại đỉnh GRAY -> Chắc chắn có Vòng Lặp! Trả về False.
     * - 2 (BLACK): Đỉnh đã duyệt xong và TOÀN BỘ các đường đi xuất phát từ đỉnh này
     * ĐỀU ĐÃ ĐẢM BẢO dẫn tới đích an toàn.
     * Nếu gặp lại BLACK -> Có thể tái sử dụng kết quả uy tín này (Tránh duyệt lại),
     * trả về True.
     * 
     * @param n           Số lượng đỉnh của đồ thị (từ 0 đến n-1)
     * @param edges       Mảng các cạnh có hướng
     * @param source      Đỉnh xuất phát
     * @param destination Đỉnh đích bắt buộc
     * @return True nếu tất cả các đường từ source đều chui lọt vào destination.
     *         Ngược lại False.
     */
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // 1. Dựng lại Đồ thị dưới dạng Danh sách Kề (Adjacency List)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Mảng trạng thái lưu trữ 3 màu: 0 (Chưa thăm), 1 (Đang thăm - nắp Vòng Lặp), 2
        // (Đã Thăm xong - An toàn)
        int[] states = new int[n];

        // 2. Kích nổ lệnh kiểm định dò mìn gọi DFS thả vào Mê cung từ 'source'
        return verifyPathsDFS(graph, source, destination, states);
    }

    private boolean verifyPathsDFS(List<List<Integer>> graph, int currentNode, int destination, int[] states) {
        // LUẬT SỐ 2: ĐỤNG MẶT ĐÁY CỤT (Sink Node)
        // Nếu Đỉnh này không chĩa nhánh ra bất kỳ đâu nữa -> Nó là ngõ cụt.
        // Ngõ cụt BẮT BUỘC phải TRÙNG với 'destination'. Nếu là cái ngõ lạ hoắc ->
        // FAIL.
        if (graph.get(currentNode).isEmpty()) {
            return currentNode == destination;
        }

        // Nếu Đỉnh này đã từng có ai đó cắm cờ trước đây
        if (states[currentNode] != 0) {
            // states == 1: Rẽ nhánh đụng phải Bãi Mìn XÁM đang dở dang (Call Stack chưa
            // rút) -> PHÁT HIỆN VÒNG LẶP (Cycle)! FAIL.
            // states == 2: Gặp Bức tường ĐEN uy tín đã bảo kê an toàn tuyệt đối -> ĐI TỰ DO
            // Nhé! TRUE.
            return states[currentNode] == 2;
        }

        // Kéo chót nhuộm Đèn Máu XÁM (Đang kẹt trong lòng thạch động, cấm ai đụm vào từ
        // hướng khác)
        states[currentNode] = 1;

        // Tung nhánh điên cuồng dò quét hết các lỗ thông con nằm dưới Nóc này
        for (int neighbor : graph.get(currentNode)) {
            // Chỉ cần 1 đường rẽ nhánh con Nào Gục Ngã (false) -> Gây Họa Sập Toàn Luồng!
            if (!verifyPathsDFS(graph, neighbor, destination, states)) {
                return false;
            }
        }

        // Khi tất cả các tuyến con đều đã bình an chạm đích thành công:
        // Cấp Giấy Chứng Nhận Tốt Nghiệp Uy Tín - Nhuộm ĐEN 100% (2) (Đường đi từ Nhánh
        // Của Tao Qua Là Bất Hoại!)
        states[currentNode] = 2;
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] edges1 = { { 0, 1 }, { 0, 2 } };
        // Đường đi 0->1 và 0->2 nhưng đích là 2 -> Đỉnh 1 trở thành "Ngõ cụt phản chủ".
        System.out.println("Test 1: " + sol.leadsToDestination(3, edges1, 0, 2)); // Expected: false

        int[][] edges2 = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 1 } };
        // Xuất hiện vòng lặp 1 <-> 2
        System.out.println("Test 2: " + sol.leadsToDestination(4, edges2, 0, 3)); // Expected: false

        int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 } };
        // Mọi nẻo (0->1->3) và (0->2->3) đều chung ngõ Đích 3.
        System.out.println("Test 3: " + sol.leadsToDestination(4, edges3, 0, 3)); // Expected: true
    }
}

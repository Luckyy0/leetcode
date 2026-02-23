# Analysis for All Paths from Source Lead to Destination
# *Phân tích bài toán Mọi Nẻo Đường Từ Nguồn Đều Dẫn Về Đích Đến*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
You must verify if ALL valid paths originating from the `source` node exclusively terminate at the `destination` node. There are two primary violations that can render the paths mathematically invalid:
1. **Cycles:** Any path possessing a loop implies an infinite count of paths.
2. **Invalid Sinks:** Any path hitting a dead-end (no outgoing edges) that is NOT the `destination` node.
*Nhiệm vụ là chứng thực TẤT CẢ mọi con đường xuất phát từ điểm `source` đều phải kết thúc và dừng lại tại duy nhất điểm `destination`. Sẽ có 2 rào cản phá hoại tính đúng đắn này:*
*1. **Vòng Lặp (Cycles):** Bất cứ đường nào đi thành vòng lặp vô tận sẽ lập tức bị báo False, do số lượng đường đi bị kéo dài đến vô cực.*
*2. **Ngõ Cụt Sai Đích:** Bất kỳ đường Nhánh nào lọt vào Ngõ Cụt (`outgoing == 0`), thì Ngõ Cụt đó Bắt Buộc PHẢI Trùng Khớp Với `destination`. Sai điểm ngõ cụt thì chương trình lập tức thất bại.*

---

## 2. Strategy: Brute Force (Standard DFS tracing all paths)
## *2. Chiến lược: Trâu Cày (Duyệt DFS Truy Vết Chay)*

### Naive Logic
### *Lý luận thô sơ*
The most direct method is to use standard Depth-First Search (DFS) or Breadth-First Search (BFS) to exhaustively trace EVERY possible path from `source` to see where it ends. We manually record nodes on the current path to detect cycles and verify each terminal node against the destination.
*Cách tiếp cận thô bạo nhất là sử dụng Thuật Toán Tìm Kiếm Theo Chiều Sâu (DFS) cơ bản. Khởi nguồn từ `source`, chương trình đi sâu vẽ ra mọi con đường có thể. Ta có thể dùng danh sách `List` hoặc bộ `Set` để đánh dấu các nút trên cung đường đang xét để phát hiện Cụm Lặp, rồi theo dõi đến nút Chặn Cuối Cùng xem có đúng tên là `destination` hay không.*

**Drawbacks (Điểm yếu):**
In a highly dense graph, traversing every single distinct path without dynamically saving previous validation states will cause an extreme combination explosion, reaching limits $O(2^V)$, resulting in a Time Limit Exceeded error.
*Đây là lối mòn tai hại! Ở những đồ thị nhiều nhánh rẽ nối nhau liên tục, tổng số tuyến đường phân rã ra sẽ bùng nổ chạm đáy $O(2^V)$ nhánh. Bắt DFS chạy quét lại từng đường một cách mù quáng, mà không hề lưu lại ký ức của các điểm gom chung đã được xác thực an toàn trước đó, chương trình sẽ nhanh chóng cạn kiệt thời gian (TLE).*

---

## 3. Strategy: Optimal (Depth-First Search with Color Array)
## *3. Chiến lược: Tối ưu (Tìm kiếm Theo Chiều Sâu DFS kèm Đèn 3 Màu)*

### Logic and Rules
### *Lý luận và Quy tắc*

We utilize Depth-First Search strictly coupled with a 3-State Color Array to confidently track node status, effectively building memoization and eliminating cycle loops in linear validation bounds.
*Sức Mạnh Giải Pháp Tối Ưu chính là đưa cơ chế Ghi Nhớ (Memoization) vào DFS. Bằng việc dựng lên một hệ thống Trạng Thái 3 Màu (Color State Array), ta có thể nhớ điểm nào đã an toàn, điểm nào đang bị kẹt để triệt tiêu mọi rẽ nhánh thừa thãi.*

*Trận Địa Mảng Trạng Thái - Gồm 3 Loại Màu Báo (`states[i]`):*
*   `0 (Trắng - White):` Điểm này còn mới tinh, chưa từng được thuật toán duyệt tới.
*   `1 (Xám - Gray):` Điểm này bắt đầu đi vào. Toàn bộ Call Stack đệ quy đang làm việc để khai phá nhánh con của nó. Chú Ý: Nếu DFS đi nhánh rẽ mà một lúc sau Vấp Lại Ngay một Đỉnh đang cắm trạng thái `Xám`, điều này TỐ CÁO sự xuất hiện của VÒNG LẶP LIÊN KHÚC. Lập tức trả `False` không cần vòng vo!
*   `2 (Đen - Black):` Đỉnh Tối Thượng An Toàn. Điểm này đã được quét xong mượt mà, rẽ nhánh 100% mọi đường con phía dưới đều đã Trúng Đích. Nếu một nhánh DFS khác đi lạc vào Điểm Đen này, không cần chạy lại DFS! Trực tiếp cấp giấy thông quan `True`!

**The DFS Verification Sequence:**
**Bộ Lệnh Kiểm Chứng Của Hàm DFS:**
1.  *Sink Verifier:* If the currently checked node possesses no outgoing edges, it must rigidly match the given `destination`.
    * *Cổng Kiểm Tra Hầm Cụt: Nếu nút hiện đang đứng không có Cạnh Hướng Ngoại nảy ra, bắt buộc so sánh ID của nó với ID `destination`. Trùng thì thả phiếu `True`, trật thì chốt `False`.*
2.  *Color Status Trap:* If the node is not colored White, meaning it was touched before, return result immediately based on Gray or Black state constraints.
    * *Lưới Báo Lỗi: Kiểm tra Bảng Màu nhớ. Đụng trạng thái `1-Xám`, rẽ báo động tạo Vòng Lặp trả False. Đụng trạng thái `2-Đen`, nhánh đó vốn đã tốt đẹp từ xa, ung dung nhả `True`.*
3.  *Execution DFS Action:* Mark current node natively Gray. Then execute recursive queries. If valid, mark Black.
    * *Thi Hành Việc Rẽ Nhánh DFS: Tại điểm khởi đầu nhánh, ném lệnh Mực `1-Xám` cho nút. Bắt đầu đẩy đệ quy thăm hỏi danh sách Vòng `Neighbors` (hàng xóm). Nếu phát sinh lệnh rớt `False` ở lứa Đệ quy con, dây chuyền mạng sập ngay lập tức. Còn Nếu mượt mà thông suốt toàn nhánh, Sơn nút thành `2-Đen` vĩnh viễn và trao cờ cứu thế `True` cho hệ thống.*

### Java Optimal Implementation
### *Triển khai giải pháp Java Tối Ưu*

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // Dựng Đồ Thị Danh Sách Kề
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pathConnector : edges) {
            graph.get(pathConnector[0]).add(pathConnector[1]);
        }
        
        // Mảng Quản Trị 3 Màu: 0 (Trắng, Chưa đi), 1 (Xám, Đang Đi - Canh Cycles), 2 (Đen, An Toàn - Thông Tuốt đến đích)
        int[] states = new int[n];
        
        return recursivelyDFSVerifyPaths(graph, source, destination, states);
    }
    
    private boolean recursivelyDFSVerifyPaths(List<List<Integer>> graph, int currentlyExploredNode, int mainDestCore, int[] states) {
        // LUẬT 2: Nếu Hết Đường Đi Ra (Cạnh Bằng Số 0), Nút Đó Buộc Lòng Phải Trùng Lỗ Đích Yêu Cầu
        if (graph.get(currentlyExploredNode).isEmpty()) {
            return currentlyExploredNode == mainDestCore;
        }
        
        // LUẬT MÀU ĐÈN SĂN CATCH KÝ ỨC VÒNG LẶP:
        if (states[currentlyExploredNode] != 0) {
            // Rơi vào bãi trạng thái 1-Xám là Toang do vướng Vòng Lặp Bất Tận (Cycle Lặp Nhau)!
            // Lọt vào bãi trạng thái 2-Đen là Được bảo đảm Tuyệt Đối Thông Thoáng từ một nhánh khác lúc trước!
            return states[currentlyExploredNode] == 2;
        }
        
        // Kéo Màu Xám chẹn Lệnh Truy Cập cho nhánh này khỏi đi lùi lại
        states[currentlyExploredNode] = 1;
        
        for (int neighboringDoor : graph.get(currentlyExploredNode)) {
            // Nổ Chập Gãy Rứt Giữa Phễu? Hạ True Chặn Dòng Rút Ống False Góp Xố Phạt!
            if (!recursivelyDFSVerifyPaths(graph, neighboringDoor, mainDestCore, states)) {
                return false;
            }
        }
        
        // Càn Quét Vượt Trạm Thần Công Toàn Diện Tốt Đẹp! Chốt Sơn Màu Đen Mã Số 2 Cho Trạm Đỉnh!
        states[currentlyExploredNode] = 2;
        return true; 
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(V + E)$. The colored state array ensures each vertex and each edge is processed optimally once mathematically without looping.
    *   **Độ phức tạp thời gian:** $O(V + E)$. Cấu trúc Đèn 3 Màu của mạng Gọi DFS ngáng lại Sự Trôi Trượt Lặp Hàm Gọi. Khung số nút `V` và Mạch Dây `E` chỉ chịu tải Càn Quét Chạm Code Đúng Một Lần Cực Độ Trong Toàn Bộ Chu Trình Code Quản Trị.*
*   **Space Complexity:** $O(V + E)$. The adjacency list takes linear overhead structure dynamically fitting graphs safely and smoothly.
    *   **Độ phức tạp không gian:** $O(V + E)$. Mảng Ma Trận Graph Kề Quây Gọn Sợi Rễ Nền Tảng Hấp Thu Liên Kết $O(V+E)$. Bộ Nhớ Chồng Đệm Đệ Quy Gánh Mạch Call Stack Tải Lưu Động Dầm Vết Không Thể Vượt Quá Nấc Trần $O(V)$.*

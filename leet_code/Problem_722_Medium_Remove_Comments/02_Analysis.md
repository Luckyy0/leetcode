# Analysis for Remove Comments
# *Phân tích cho bài toán Xóa Chú thích*

## 1. Problem Essence & State Management
## *1. Bản chất vấn đề & Quản lý Trạng thái*

### The Challenge
### *Thách thức*
We need to scan the code character by character while maintaining a "state" to determine if the current character is part of a comment or actual code. The main complexity arises from **Block Comments** (`/* ... */`) which can start and end on different lines, potentially merging fragmented lines together.
*Chúng ta cần quét mã từng ký tự một trong khi duy trì một "trạng thái" để xác định xem ký tự hiện tại là một phần của chú thích hay là mã thực tế. Độ phức tạp chính đến từ **Chú thích khối** (`/* ... */`) vốn có thể bắt đầu và kết thúc trên các dòng khác nhau, có khả năng gộp các dòng rời rạc lại với nhau.*

---

## 2. Strategy: Finite State Parser
## *2. Chiến lược: Bộ phân tích Trạng thái Hữu hạn*

We use a single variable `inBlock` (boolean) to track whether we are currently inside a block comment.
*Chúng ta sử dụng một biến duy nhất `inBlock` (boolean) để theo dõi xem hiện tại ta có đang nằm trong một chú thích khối hay không.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Global Buffer:** Maintain a `StringBuilder` that persists across multiple source lines. We only add its content to the final list when we are *not* in a block comment at the end of a line scan.
    * **Bộ đệm Toàn cục:** Duy trì một `StringBuilder` tồn tại xuyên suốt nhiều dòng nguồn. Chúng ta chỉ thêm nội dung của nó vào danh sách cuối cùng khi ta *không* ở trong một chú thích khối tại thời điểm kết thúc quét một dòng.*

2.  **Character Inspection:**
    - **Current state: NO_BLOCK**
        - If encounter `/*`: Set `inBlock = true` and skip the next 1 character.
        - If encounter `//`: This entire line is now a comment. Stop processing this line and break the inner loop.
        - Otherwise: Append the character to the buffer.
    - **Current state: IN_BLOCK**
        - If encounter `*/`: Set `inBlock = false` and skip the next 1 character.
        - Otherwise: Ignore the character.
    * **Kiểm tra Ký tự:**
        * Trạng thái hiện tại: KHÔNG_KHỐI (Gặp `/*` thì đổi trạng thái; Gặp `//` thì bỏ qua hết dòng; Ngược lại thì lưu ký tự).
        * Trạng thái hiện tại: TRONG_KHỐI (Gặp `*/` thì đổi trạng thái thoát; Ngược lại thì bỏ qua).*

3.  **Result Construction:** At the end of each source line, check if `!inBlock` and the buffer is not empty. If so, add it to results and clear for the next cohesive line.
    * **Xây dựng Kết quả:** Cuối mỗi dòng nguồn, kiểm tra nếu không ở trong khối và bộ đệm không rỗng thì lưu lại và xóa đệm.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(S)$, where $S$ is the total number of characters in the source code. We visit each character exactly once.
    * **Độ phức tạp thời gian:** $O(S)$.*
*   **Space Complexity:** $O(S)$ for the `StringBuilder` buffer and the final result list.
    * **Độ phức tạp không gian:** $O(S)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

The key is treating the entire source as a continuous stream of characters, but with a special newline marker logic. The "line-spanning" nature of block comments means you should only reset your "line-accumulator" (the `StringBuilder`) when you are safely outside a block at the end of processing a source line.
*Chìa khóa là xử lý toàn bộ nguồn như một dòng ký tự liên tục, nhưng có logic đánh dấu dòng mới đặc biệt. Bản chất "trải dài nhiều dòng" của chú thích khối có nghĩa là bạn chỉ nên đặt lại "bộ tích lũy dòng" khi bạn đã an toàn nằm ngoài khối vào cuối quá trình xử lý một dòng nguồn.*
---
*Mã nguồn thực sự ẩn giấu dưới lớp vỏ của những lời giải thích (Comments). Trong mê cung của các ký tự, nhiệm vụ của ta là sàng lọc những gì thuộc về logic và loại bỏ những gì chỉ là văn chương bên lề. Dữ liệu dạy ta rằng bằng cách giữ vững một trạng thái tỉnh táo (State tracking) và nhẫn nại ghép nối những mảnh vụn còn sót lại (Buffer), ta có thể khôi phục lại sự tinh khiết của một thuật toán đằng sau những dòng ghi chú rườm rà.*
True source code is hidden beneath the layer of explanations (Comments). In the labyrinth of characters, our task is to filter out what belongs to logic and eliminate what is just marginal literature. Data teaches us that by maintaining a sober state (State tracking) and patiently splicing the remaining fragments (Buffer), we can restore the purity of an algorithm behind verbose notes.

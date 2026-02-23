# Analysis for Surrounded Regions
# *Phân tích cho bài toán Vùng Bị Bao Vây*

## 1. Problem Insight & Reversal Logic
## *1. Thông Hiểu Vấn Đề & Logic Đảo Ngược*

### Defining "Surrounded"
### *Định Nghĩa "Bị Bao Vây"*
*   An `'O'` is surrounded if it has no path to the boundary of the matrix through other `'O'`s.
    *Một ký tự `'O'` bị bao vây nếu nó không có đường dẫn nào đến ranh giới của ma trận thông qua các ký tự `'O'` khác.*
*   If an `'O'` is on the border, it is definitely **not** surrounded.
    *Nếu một ký tự `'O'` nằm trên ranh giới, nó chắc chắn **không** bị bao vây.*
*   If an `'O'` is connected to a border `'O'`, it is also **not** surrounded.
    *Nếu một ký tự `'O'` được kết nối với một ký tự `'O'` ở biên, nó cũng **không** bị bao vây.*

### Correct Strategy
### *Chiến Lược Đúng Đắn*
Instead of trying to determine if each internal `'O'` is surrounded (which is difficult), we should use a "reversal" approach:
*Thay vì cố gắng xác định xem mỗi ký tự `'O'` bên trong có bị bao vây hay không (việc này rất khó), chúng ta nên sử dụng phương pháp "đảo ngược":*
1.  Find all `'O'`s on the four borders of the grid.
    *Tìm tất cả các ký tự `'O'` trên bốn biên của lưới.*
2.  Perform a traversal (BFS or DFS) starting from these border `'O'`s to mark all connected `'O'`s. These are the "safe" nodes that should **never** be flipped.
    *Thực hiện một phép duyệt (BFS hoặc DFS) bắt đầu từ các ký tự `'O'` ở biên này để đánh dấu tất cả các ký tự `'O'` được kết nối. Đây là những nút "an toàn" **không bao giờ** được lật.*
3.  After marking all safe nodes, iterate through the entire board:
    -   If an `'O'` is marked as safe, restore it to `'O'`.
    -   If an `'O'` is **not** marked as safe, flip it to `'X'`.
    -   Keep `'X'` as original.

---

## 2. Approach: DFS Marking
## *2. Hướng Tiếp Cận: Đánh Dấu Bằng DFS*

### Logic
### *Logic*
1.  **Phase 1 (Border Traversal):**
    -   Loop through the first and last columns.
    -   Loop through the first and last rows.
    -   Whenever an `'O'` is found, call `DFS(r, c)` to change it and all connected `'O'`s to a temporary marker like `'#'`.
        *Mỗi khi tìm thấy một ký tự `'O'`, gọi `DFS(r, c)` để thay đổi nó và tất cả các ký tự `'O'` được kết nối thành một dấu hiệu tạm thời như `'#'`.*
2.  **Phase 2 (Cleanup):**
    -   Iterate through every cell `(r, c)` in the board:
        -   If `board[r][c] == 'O'`, change it to `'X'` (because it wasn't connected to any border).
        -   If `board[r][c] == '#'`, change it back to `'O'` (because it's safe).

---

## 3. Structural Advantages
## *3. Ưu Điểm Cấu Trúc*

*   **Boundary First:** By processing the edges first, we leverage the most constrained part of the problem to simplify the interior.
    *Ưu Tiên Biên: Bằng cách xử lý các cạnh trước, chúng ta tận dụng phần bị ràng buộc nhất của bài toán để đơn giản hóa phần bên trong.*
*   **In-Place Modification:** We use the board itself to store temporary state (`'#'`), which avoids extra boolean matrices for tracking visited nodes.
    *Sửa Đổi Tại Chỗ: Chúng ta sử dụng chính bảng để lưu trữ trạng thái tạm thời (`'#'`), điều này tránh được việc sử dụng các ma trận boolean bổ sung để theo dõi các nút đã truy cập.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M \times N$ is the size of the board. Each cell is visited at most twice (one in Phase 1, once in Phase 2).
    *Độ phức tạp thời gian: $O(M \times N)$, trong đó $M \times N$ là kích thước của bảng. Mỗi ô được truy cập tối đa hai lần.*
*   **Space Complexity:** $O(M \times N)$ in the worst case for the recursion stack (if the entire board is filled with `'O'`s in a snake-like pattern). Average case for balanced growth is much lower, but technically $O(\text{Area})$.
    *Độ phức tạp không gian: $O(M \times N)$ trong trường hợp xấu nhất cho ngăn xếp đệ quy. Trong kỹ thuật là $O(\text{Diện tích})$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

```
X X X X       X X X X       X X X X
X O O X  -->  X O O X  -->  X X X X
X X O X       X X O X       X X X X
X O X X       X # X X       X O X X
```
-   Phase 1 marks bottom-border `'O'` as `'#'`.
-   Internal `'O'`s remain `'O'` because they don't touch the borders.
-   Phase 2 flips `'O'` to `'X'` and `'#'` back to `'O'`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The "Mark border-connected components" strategy is a fundamental technique for grid problems where boundaries define the behavior of the interior. It is much more robust than checking each node's "surroundedness" individually. Using a placeholder character like `'#'` is a clean way to manage state without extra memory.
*Chiến lược "Đánh dấu các thành phần được kết nối với biên" là một kỹ thuật cơ bản cho các bài toán lưới nơi ranh giới xác định hành vi của phần bên trong. Nó mạnh mẽ hơn nhiều so với việc kiểm tra riêng lẻ "tính bị bao vây" của từng nút. Sử dụng một ký tự giữ chỗ như `'#'` là một cách sạch sẽ để quản lý trạng thái mà không cần thêm bộ nhớ.*
---
*Đôi khi cách tốt nhất để bảo vệ mình là luôn giữ một sợi dây kết nối với thế giới bên ngoài.*
Sometimes the best way to protect yourself is to always keep a tether connecting you to the outside world.

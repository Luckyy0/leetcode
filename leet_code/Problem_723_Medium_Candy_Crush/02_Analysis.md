# Analysis for Candy Crush
# *Phân tích cho bài toán Xếp kẹo (Candy Crush)*

## 1. Problem Essence & Multi-Stage Simulation
## *1. Bản chất vấn đề & Mô phỏng Đa giai đoạn*

### The Challenge
### *Thách thức*
We need to simulate the "stable" state of a Candy Crush board. This requires repeating two main phases: **Crushing** and **Dropping**. The crucial part is that all possible crushes must be identified *before* any candy actually disappears, ensuring the "simultaneous" rule.
*Chúng ta cần mô phỏng trạng thái "ổn định" của lưới kẹo. Điều này yêu cầu lặp lại hai giai đoạn chính: **Loại bỏ** và **Rơi**. Phần quan trọng là tất cả các vị trí có thể loại bỏ phải được xác định *trước khi* bất kỳ viên kẹo nào thực sự biến mất, nhằm đảm bảo quy tắc "đồng thời".*

---

## 2. Strategy: Mark-Clear-Drop Loop
## *2. Chiến lược: Vòng lặp Đánh dấu-Xóa-Rơi*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Marking Phase (Identification):**
    - Iterate through every row and column.
    - If three adjacent cells horizontally have the same value `v > 0`, mark them by setting their values to `-v`. Note that we use the absolute value `Math.abs(v)` to continue checking even if a cell was already marked.
    - Do the same for vertical sequences of three or more.
    * **Giai đoạn Đánh dấu:** Duyệt qua từng hàng và cột. Nếu ba ô cạnh nhau có giá trị bằng nhau, đặt chúng thành giá trị âm để đánh dấu xóa mà không làm mất thông tin về loại kẹo.*

2.  **Clearing Phase:**
    - Scan the board. Any cell with a negative value becomes `0`.
    * **Giai đoạn Xóa:** Chuyển tất cả các ô có giá trị âm thành `0`.*

3.  **Gravity Phase (Drop):**
    - For each column, move all non-zero values to the bottom using a "write pointer" starting from the last row upwards. Fill the empty top spaces with `0`.
    * **Giai đoạn Rơi:** Với mỗi cột, dồn toàn bộ các giá trị khác 0 xuống dưới cùng, sau đó lấp đầy các ô trống ở trên bằng số 0.*

4.  **Convergence:** Continue the process as long as the Marking Phase identifies at least one sequence to crush.
    * **Hội tụ:** Tiếp tục quá trình chừng nào Giai đoạn Đánh dấu còn tìm thấy ít nhất một dãy để xóa.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O((R \cdot C)^2)$, where $R$ and $C$ are the board dimensions. In each iteration, we scan $R \cdot C$ cells. The number of iterations is limited because each crush reduces the total "potential energy" (non-zero cells) of the board. In practice, for a $50 \times 50$ board, this is very fast.
    * **Độ phức tạp thời gian:** $O((R \cdot C)^2)$.*
*   **Space Complexity:** $O(1)$ if we modify the board in place (except for transient marking).
    * **Độ phức tạp không gian:** $O(1)$ (nếu thay đổi trực tiếp trên lưới).*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

Using negative markers is a clever trick to perform "simultaneous" updates without an extra auxiliary board. This keeps the space complexity at a minimum while ensuring the logic correctly handles overlapping horizontal and vertical crushes.
*Sử dụng đánh dấu bằng số âm là một mẹo thông minh để thực hiện các cập nhật "đồng thời" mà không cần dùng thêm lưới phụ. Điều này giúp tối thiểu hóa độ phức tạp không gian.*
---
*Sự cân bằng (Stability) trong một hệ thống động là kết quả của việc loại bỏ những xung đột (Crush) và tái định vị các thành phần (Drop). Trong cấu trúc của lưới kẹo, mỗi bước biến đổi là một bước tiến tới sự tĩnh lặng. Dữ liệu dạy ta rằng bằng cách xác định tất cả các điểm yếu cùng lúc (Simultaneous marking) và để trọng lực của quy luật tự nhiên sắp xếp lại trật tự (Gravity), ta có thể tìm thấy trạng thái cuối cùng nơi mọi thứ đều thuộc về đúng vị trí của nó.*
Balance (Stability) in a dynamic system is the result of eliminating conflicts (Crush) and repositioning components (Drop). In the structure of the candy grid, each transformation step is a step toward stillness. Data teaches us that by identifying all weak points at the same time (Simultaneous marking) and letting the gravity of natural laws rearrange the order (Gravity), we can find the final state where everything belongs in its right place.

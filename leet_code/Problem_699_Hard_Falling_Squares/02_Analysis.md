# Analysis for Falling Squares
# *Phân tích cho bài toán Các khối vuông rơi*

## 1. Problem Essence & Stacked Geometry
## *1. Bản chất vấn đề & Hình học Xếp chồng*

### The Challenge
### *Thách thức*
We are simulating squares falling onto a line. Each square has a width and a height (equal to side length). If a square's X-interval $[L, R)$ overlaps with any squares already on the ground, it will sit on top of the highest point within that interval.
*Chúng ta đang mô phỏng các khối vuông rơi xuống một trục số. Mỗi khối vuông có chiều rộng và chiều cao bằng nhau. Nếu khoảng X $[L, R)$ của một khối vuông chồng lấp với bất kỳ khối vuông nào đã có, nó sẽ nằm trên đỉnh của điểm cao nhất trong khoảng đó.*

---

## 2. Strategy: $O(N^2)$ Simulation with Intervals
## *2. Chiến lược: Mô phỏng $O(N^2)$ với các Khoảng*

Given the constraint $N \le 1000$, a quadratic solution is efficient enough and simpler than complex structures like Segment Trees.
*Với ràng buộc $N \le 1000$, một giải pháp bậc hai là đủ hiệu quả và đơn giản hơn.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Maintain Square History:** Keep a list of all dropped squares, storing their `left`, `right`, and `height` (the top edge's Y-coordinate).
    * **Duy trì Lịch sử:** Lưu trữ danh sách các khối đã rơi, bao gồm tọa độ trái, phải và chiều cao của đỉnh.*

2.  **Process Drop by Drop:** For each new square `[left, left + side)`:
    - **Find Base Height:** Initialize `baseHeight = 0`.
    - Iterate through all previously dropped squares.
    - If a previous square `[pLeft, pRight)` overlaps with the current `[left, right)`:
        - `overlap` is true if `pLeft < right && pRight > left`.
        - If they overlap, update `baseHeight = max(baseHeight, pTopHeight)`.
    - **Calculate Current Top:** `currentTopHeight = baseHeight + side`.
    - Store this square as `[left, left + side, currentTopHeight]`.
    * **Xử lý từng khối:** Với mỗi khối mới, tìm chiều cao nền bằng cách kiểm tra sự chồng lấp với tất cả các khối cũ. Chiều cao mới = chiều cao nền cao nhất + độ dài cạnh.*

3.  **Track Global Maximum:** After each drop, the answer for that step is the maximum `currentTopHeight` seen across the entire history so far.
    * **Theo dõi Cực đại:** Sau mỗi lần thả, kết quả là chiều cao đỉnh lớn nhất trong lịch sử.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Precision:** By defining intervals as $[left, right)$, we avoid boundary confusion. Two squares that just touch at a single point (e.g., [1, 2] and [2, 3]) do not overlap.
    * **Độ chính xác:** Bằng cách định nghĩa khoảng nửa mở, chúng ta tránh nhầm lẫn tại biên.*
*   **Segment Tree Alternative:** For much larger $N$ (e.g., $10^5$), we would need a Segment Tree with dynamic nodes or coordinate compression. Here, $O(N^2)$ is optimal for implementation simplicity.
    * **Lựa chọn thay thế:** Với $N$ lớn hơn, ta cần Cây phân đoạn (Segment Tree). Ở đây, $O(N^2)$ là tối ưu cho sự đơn giản.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the number of squares. For each square, we scan all $i$ previous squares.
    * **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N)$ to store the history of $N$ squares.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**positions = [[1,2], [2,3], [6,1]]**
1. Drop [1, 3): Base = 0, Top = 2. History: `{[1, 3, 2]}`. MaxHeight = 2.
2. Drop [2, 5): 
   - Overlaps with [1, 3) because `1 < 5` and `3 > 2`.
   - Base = 2. Top = 2 + 3 = 5. History: `{[1, 3, 2], [2, 5, 5]}`. MaxHeight = 5.
3. Drop [6, 7):
   - No overlap with history. Base = 0, Top = 1.
   - MaxHeight remains 5.
**Result:** [2, 5, 5].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

In geometry problems, always start by checking if a simple simulation covers the constraints. $O(N^2)$ for $N=1000$ is perfectly acceptable. The core logic remains finding the maximum value in a range and updating it, which is the heart of range-max problems.
*Trong các bài toán hình học, hãy luôn kiểm tra xem mô phỏng đơn giản có đáp ứng được ràng buộc không. $O(N^2)$ cho $N=1000$ là hoàn toàn chấp nhận được.*
---
*Mỗi khối vuông (Square) rơi xuống là một mảnh ghép thêm vào bức tranh của sự tích lũy (Accumulation). Trong sự chồng chéo của các khoảng không (Intervals), đỉnh cao nhất không chỉ được định hình bởi hình hài của chính nó, mà còn bởi nền tảng của quá khứ (History). Dữ liệu dạy ta rằng bằng cách đo lường sự giao thoa (Overlap) và đứng trên vai của những kẻ đi trước (Base height), ta có thể vươn tới những tầm cao mới.*
Every square (Square) that falls is a piece added to the picture of accumulation (Accumulation). In the overlapping of spaces (Intervals), the highest peak is shaped not only by its own form, but also by the foundation of the past (History). Data teaches us that by measuring interference (Overlap) and standing on the shoulders of those who came before (Base height), we can reach new heights.

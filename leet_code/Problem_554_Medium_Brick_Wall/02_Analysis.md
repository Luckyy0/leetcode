# Analysis for Brick Wall
# *Phân tích cho bài toán Bức tường Gạch*

## 1. Problem Essence & The Strategy of Avoidance
## *1. Bản chất vấn đề & Chiến lược của sự Né tránh*

### The Challenge
### *Thách thức*
Imagine a wall made of rows of bricks. We want to draw a vertical line from top to bottom that passes through the **minimum** number of bricks.
*Hãy tưởng tượng một bức tường được làm từ các hàng gạch. Chúng ta muốn kẻ một đường thẳng đứng từ trên xuống dưới sao cho đi qua **ít nhất** các viên gạch.*

A brick is "crossed" only if the line passes through its body. If the line passes through the vertical edge (gap) between two bricks, it doesn't count as crossing a brick.
*Một viên gạch bị "cắt qua" chỉ khi đường thẳng đi qua thân của nó. Nếu đường thẳng đi qua cạnh đứng (khe hở) giữa hai viên gạch, nó không được tính là cắt qua viên gạch.*

Since we want to minimize crossed bricks, the problem is equivalent to **maximizing the number of gaps (edges)** the line passes through.
*Vì chúng ta muốn giảm thiểu số gạch bị cắt qua, bài toán tương đương với việc **tối đa hóa số lượng kẽ hở (cạnh)** mà đường thẳng đi qua.*

---

## 2. Strategy: Prefix Sums and Edge Frequency Mapping
## *2. Chiến lược: Tổng Tiền tố và Ánh xạ Tần suất Cạnh*

We can't just check every possible horizontal coordinate because the wall width can be very large (up to 2 billion). However, gaps only occur at the end of each brick.
*Chúng ta không thể kiểm tra mọi tọa độ ngang khả dĩ vì chiều rộng bức tường có thể rất lớn (lên đến 2 tỷ). Tuy nhiên, các kẽ hở chỉ xuất hiện ở điểm cuối của mỗi viên gạch.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate through each row:** For each row, calculate the cumulative width of the bricks. Each cumulative width represents the position of an edge.
    * **Duyệt qua từng hàng:** Đối với mỗi hàng, hãy tính chiều rộng tích lũy của các viên gạch. Mỗi chiều rộng tích lũy đại diện cho vị trí của một cạnh.*
    - Row: `[1, 2, 2, 1]` -> Edges at: `1, (1+2)=3, (3+2)=5`.
    - (We ignore the last edge at `1+2+2+1=6` because we cannot draw a line at the wall's boundary).
    - *(Chúng ta bỏ qua cạnh cuối cùng tại `1+2+2+1=6` vì không được phép kẻ đường thẳng tại ranh giới của bức tường).*

2.  **Frequency Map:** Use a `HashMap<Integer, Integer>` to store how many rows have an edge at a particular position $x$.
    * **Bản đồ Tần suất:** Sử dụng một `HashMap<Integer, Integer>` để lưu trữ xem có bao nhiêu hàng có cạnh tại một vị trí $x$ cụ thể.*

3.  **Find Maximum Edges:** Find the maximum value in the HashMap. This value, `maxEdges`, is the greatest number of gaps a single vertical line can touch.
    * **Tìm số Cạnh tối đa:** Tìm giá trị lớn nhất trong HashMap. Giá trị này, `maxEdges`, là số lượng kẽ hở lớn nhất mà một đường thẳng đứng duy nhất có thể chạm tới.*

4.  **Calculate Result:** The minimum number of bricks crossed is `TotalRows - maxEdges`.
    * **Tính toán Kết quả:** Số lượng gạch bị cắt qua ít nhất là `TotalRows - maxEdges`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Sparse Representation:** Instead of modeling the whole 2D wall, we only store active gap positions. This handles high wall width efficiently.
    * **Biểu diễn thưa thớt:** Thay vì lập mô hình toàn bộ bức tường 2D, chúng ta chỉ lưu trữ các vị trí kẽ hở đang hoạt động. Điều này giúp xử lý chiều rộng tường lớn một cách hiệu quả.*
*   **Coordinate Independence:** The logic works regardless of the total width, as only relative positions of brick ends matter.
    * **Độc lập tọa độ:** Logic hoạt động bất kể tổng chiều rộng, vì chỉ có vị trí tương đối của các điểm cuối viên gạch mới quan trọng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the total number of bricks in the entire wall. We process each brick once to update the map.
    * **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là tổng số viên gạch trong toàn bộ bức tường. Chúng ta xử lý mỗi viên gạch một lần để cập nhật bản đồ.*
*   **Space Complexity:** $O(E)$, where $E$ is the number of distinct edge positions across the wall. In the worst case, $E \le N$.
    * **Độ phức tạp không gian:** $O(E)$, trong đó $E$ là số lượng vị trí cạnh phân biệt trên toàn bộ bức tường. Trong trường hợp xấu nhất, $E \le N$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Wall:**
Row 1: `[1, 2, 2, 1]` -> Edges: {1, 3, 5}
Row 2: `[3, 1, 2]` -> Edges: {3, 4}
Row 3: `[1, 3, 2]` -> Edges: {1, 4}

- **Map accumulation:**
  - Pos 1: count=2 (Rows 1, 3)
  - Pos 3: count=2 (Rows 1, 2)
  - Pos 4: count=2 (Rows 2, 3)
  - Pos 5: count=1 (Row 1)
- `maxEdges` = 2.
- `TotalRows` = 3.
- `Result` = 3 - 2 = 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always focus on the "gaps" instead of the "solids" when trying to minimize intersections.
*Luôn tập trung vào các "kẽ hở" thay vì các "vật thể rắn" khi cố gắng giảm thiểu giao điểm.*
---
*Trong cuộc sống, ranh giới (Edge) thường là nơi ít xung đột nhất. Bằng cách tìm ra nơi mà những ranh giới này giao nhau nhiều nhất (Maximize edges), ta có thể đi xuyên qua bức tường (Wall) với sự kháng cự tối thiểu (Minimum bricks). Hãy tập trung vào những kẽ hở thay vì cố gắng đâm đầu vào gạch.*
In life, boundaries (Edge) are often the place of least conflict. By finding where these boundaries intersect most (Maximize edges), we can pass through the wall (Wall) with minimum resistance (Minimum bricks). Focus on the gaps instead of trying to hit the bricks.

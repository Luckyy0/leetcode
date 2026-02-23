# Analysis for Largest Plus Sign
# *Phân tích cho bài toán Dấu Cộng Lớn nhất*

## 1. Problem Essence & Dynamic Programming
## *1. Bản chất vấn đề & Quy hoạch động*

### The Challenge
### *Thách thức*
For each cell `(r, c)`, we want to find the largest `k` such that it can be the center of a plus sign. `k` is determined by the shortest arm among the 4 directions (Left, Right, Up, Down).
*Với mỗi ô `(r, c)`, ta muốn tìm `k` lớn nhất sao cho nó có thể là tâm của dấu cộng. `k` bị giới hạn bởi nhánh ngắn nhất trong 4 hướng (Trái, Phải, Lên, Xuống).*

Formally: `order[r][c] = min(left[r][c], right[r][c], up[r][c], down[r][c])`.
Where `left[r][c]` is the number of continuous 1s ending at `(r, c)` extending leftwards.
*Về mặt hình thức: `order[r][c]` bằng giá trị nhỏ nhất của độ dài nhánh liên tục theo 4 hướng.*

---

## 2. Strategy: 4-Pass DP
## *2. Chiến lược: DP 4 Lượt*

### Steps
### *Các bước*

1.  **Grid Initialization:** Create an $N \times N$ grid initialized to $N$ (or effectively infinity, representing max possible arm length). Mark mined cells as $0$. The non-mined cells are candidates.
    *   **Khởi tạo Lưới:** Tạo lưới $N \times N$ với giá trị lớn (vô cùng), trừ các ô có mìn là $0$.*

2.  **Four Passes:**
    - For each cell, we need to minimize (`min`) the arm lengths from 4 directions.
    - We can do this with multiple passes or iterate smartly.
    - **Row Pass:** For each row `i`:
        - Scan Left->Right: Count consecutive 1s (`l`). Update `grid[i][j] = min(grid[i][j], l)`.
        - Scan Right->Left: Count consecutive 1s (`r`). Update `grid[i][j] = min(grid[i][j], r)`.
    - **Col Pass:** For each col `j`:
        - Scan Up->Down: Count consecutive 1s (`u`). Update `grid[i][j] = min(grid[i][j], u)`.
        - Scan Down->Up: Count consecutive 1s (`d`). Update `grid[i][j] = min(grid[i][j], d)`.
    *   **Bốn Lượt:** Với mỗi hàng, quét Trái-Phải và Phải-Trái. Với mỗi cột, quét Lên-Xuống và Xuống-Lên. Mỗi lần quét duy trì biến đếm `consecutive`. Cập nhật giá trị ô bằng `min` của giá trị hiện tại và biến đếm.*

3.  **Result:** The answer is the maximum value in the final grid.
    *   **Kết quả:** Giá trị lớn nhất trong lưới cuối cùng.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
int[][] dp = new int[n][n]; // Init to 0 or N?
// Better: Init to 1 if not mine, else 0.
// Then run passes.
// Actually, initialize all to N. 
// Set mines to 0.

// Left-Right, Right-Left
for (int i = 0; i < n; i++) {
    // L -> R
    int count = 0;
    for (int j = 0; j < n; j++) {
        count = (grid[i][j] == 0) ? 0 : count + 1;
        dp[i][j] = Math.min(dp[i][j], count);
    }
    // R -> L
    count = 0;
    for (int j = n - 1; j >= 0; j--) {
        count = (grid[i][j] == 0) ? 0 : count + 1;
        dp[i][j] = Math.min(dp[i][j], count);
    }
}
// Up-Down loops similarly...
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. We visit each cell constant times (4 passes).
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N^2)$ for the DP grid.
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**N=5, Mine at (4, 2)**
Init: All 5, except (4,2)=0.
Row 4 (index 4): `1 1 0 1 1` (conceptually)
- L->R count: `1 2 0 1 2`. DP updates to `min(5, val)`.
- R->L count: `2 1 0 2 1`. DP updates to `min`.
Result Row 4: `1 1 0 1 1`.

Col 2: `1 1 1 1 0`.
- U->D: `1 2 3 4 0`.
- D->U: `4 3 2 1 0`.
min(`RowRes`, `U`, `D`)...
Center (2, 2):
- L-R would be large (say 3).
- U-D: `min(3, 2)` -> 2? (From row pass min was likely 3, from col pass counts are 3 and 2. So 2).
Example Output 2 is correct.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Using a single DP matrix initialized to a high value allows us to simply apply `Math.min` incrementally for all 4 directions.
*Sử dụng một ma trận DP khởi tạo với giá trị lớn cho phép ta đơn giản áp dụng `Math.min` dần dần cho cả 4 hướng.*

# Analysis for Lonely Pixel I
# *Phân tích cho bài toán Điểm ảnh Cô đơn I*

## 1. Problem Essence & Row/Col Counting
## *1. Bản chất vấn đề & Đếm Hàng/Cột*

### The Challenge
### *Thách thức*
Identifying cells `(r, c)` where `picture[r][c] == 'B'` and it is the *only* 'B' in row `r` and col `c`.

### Strategy: Precomputation
### *Chiến lược: Tính toán trước*

1.  **Count:** Iterate through the grid to count 'B's in each row and column. Store in `rowCount[m]` and `colCount[n]`.
2.  **Verify:** Iterate through the grid again. If `picture[r][c] == 'B'` AND `rowCount[r] == 1` AND `colCount[c] == 1`, increment result.

---

## 2. Approach: Two-Pass
## *2. Hướng tiếp cận: Hai lần duyệt*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(MN) Time:** Need to examine each cell.
    *Thời gian O(MN): Cần kiểm tra từng ô.*
*   **O(M+N) Space:** Minimal extra space.
    *Không gian O(M+N): Không gian phụ tối thiểu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(M + N)$.
    *Độ phức tạp không gian: $O(M + N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:**
```
W W B
W B W
B W W
```
1. Rows: `[1, 1, 1]`. Cols: `[1, 1, 1]`.
2. `(0, 2)`: 'B', Rows[0]=1, Cols[2]=1. Valid.
3. `(1, 1)`: 'B', Rows[1]=1, Cols[1]=1. Valid.
4. `(2, 0)`: 'B', Rows[2]=1, Cols[0]=1. Valid.
Result: 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Count row/col frequencies first, then validate.
*Đếm tần suất hàng/cột trước, sau đó xác thực.*
---
*Cô đơn (Lonely) là khi bạn là duy nhất trong cả hai thế giới: thế giới phương ngang (row) và thế giới phương dọc (column). Sự độc nhất này đòi hỏi sự đồng thuận từ cả hai phía, không chỉ là bạn đứng một mình, mà cả hàng và cột đều tôn vinh sự tồn tại duy nhất đó.*
Loneliness is when you are unique in both worlds: horizontal (Row) and vertical (Column). This uniqueness requires consensus from both sides, not only you stand alone, but both rows and columns honor that unique existence.

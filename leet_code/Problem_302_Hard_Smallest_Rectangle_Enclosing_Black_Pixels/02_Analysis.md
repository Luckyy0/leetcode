# Analysis for Smallest Rectangle Enclosing Black Pixels
# *Phân tích cho bài toán Hình chữ nhật Nhỏ nhất Bao quanh Điểm ảnh Đen*

## 1. Problem Essence & Projection
## *1. Bản chất vấn đề & Phép chiếu*

### The Connectivity Property
### *Tính chất Kết nối*
"Black pixels are connected".
This implies that if we project the 2D grid onto 1D x-axis (checking if a row has ANY 1), the result will look like `000011111000`.
It will be a single contiguous block of 1s.
Same for y-axis (columns).

### Strategy: Binary Search on Boundaries
### *Chiến lược: Tìm kiếm Nhị phân trên các Biên*
We need finding: `top`, `bottom`, `left`, `right`.
We are given aseed `(x, y)` inside the black region.
- `Top`: Find first row in `[0, x]` that has a black pixel.
    - Check function: `hasBlack(row)` iterates columns.
- `Bottom`: Find first row in `[x+1, m]` that has NO black pixel (exclusive boundary), then subtract 1? Or find last row with black.
    - Convention: `[top, bottom)`. Find first non-black row after x.
- `Left`: Find first col in `[0, y]` that has black.
- `Right`: Find first col in `[y+1, n]` that has NO black.

### Complexity
### *Độ phức tạp*
Row checks take $O(N)$ (scan columns). BS takes $O(\log M)$. Total $O(N \log M)$.
Col checks take $O(M)$ (scan rows). BS takes $O(\log N)$. Total $O(M \log N)$.
Overall: $O(N \log M + M \log N)$. This is much better than $O(MN)$ which is equivalent to visiting every pixel.

---

## 2. Approach: Binary Search Helper
## *2. Hướng tiếp cận: Trình trợ giúp Tìm kiếm Nhị phân*

### Logic
### *Logic*
`searchRows(i, j, hasBlackLimit)`
`searchCols(i, j, hasBlackLimit)`
Actually, generalize: `search(low, high, checkFunc)`.
- `Top`: Find first `i` in `[0, x]` s.t. `hasOne(i) == true`.
- `Bottom`: Find first `i` in `[x+1, m]` s.t. `hasOne(i) == false`.
- `Left`: Find first `j` in `[0, y]` s.t. `hasOne(col j) == true`.
- `Right`: Find first `j` in `[y+1, n]` s.t. `hasOne(col j) == false`.

Then Area = `(Bottom - Top) * (Right - Left)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Dimensionality Reduction:** Reducing 2D search to 1D search via projection.
*   **Logarithmic Search:** Exploiting sorted/clustered property.
    *Giảm chiều: Giảm tìm kiếm 2D xuống 1D thông qua phép chiếu. Tìm kiếm logarit: Khai thác tính chất đã sắp xếp/cụm.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \log N + N \log M)$.
    *Độ phức tạp thời gian: $O(M \log N + N \log M)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `(x=0, y=2)`. Grid 3x4.
Rows: `0010` (yes), `0110` (yes), `0100` (yes).
Projected Rows: `1, 1, 1`.
`Top`: Search `[0, 0]`. Row 0 has 1. Top = 0.
`Bottom`: Search `[1, 3]`. Row 1 yes. Row 2 yes. Row 3 (out) no. Bottom = 3.

Cols:
Col 0: `000` (No).
Col 1: `011` (Yes).
Col 2: `110` (Yes).
Col 3: `000` (No).
Projected Cols: `0, 1, 1, 0`. `y=2` (Col index 2, is 1).
`Left`: Search `[0, 2]`. Col 0 no. Col 1 yes. Left = 1.
`Right`: Search `[3, 4]`. Col 3 no. Right = 3.

Area: `(3-0) * (3-1) = 3 * 2 = 6`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Binary Search on boundaries is the only sub-linear way.
*Tìm kiếm Nhị phân trên các biên là cách duy nhất dưới tuyến tính.*
---
*Đôi khi để nhìn thấy bức tranh toàn cảnh (rectangle), ta không cần soi từng điểm một, mà chỉ cần tìm những giới hạn (limitations) của nó. Biết điểm dừng cũng quan trọng như biết điểm bắt đầu.*
Sometimes to see the big picture (rectangle), we don't need to examine every point, but just find its limitations. Knowing where to stop is as important as knowing where to start.

# Analysis for Range Sum Query 2D - Mutable
# *Phân tích cho bài toán Truy vấn Tổng trong Phạm vi 2D - Có thể thay đổi*

## 1. Problem Essence & 2D BIT
## *1. Bản chất vấn đề & BIT 2D*

### The Challenge
### *Thách thức*
2D Point updates + 2D Range sums.
Static 2D Prefix Sum (O(MN) update) is too slow.
2D BIT generalizes 1D BIT.
`tree[i][j]` covers range in both abstract dimensions.

### Strategy: 2D Fenwick Tree
### *Chiến lược: Cây Fenwick 2D*
Update logic:
Nested loops.
`update(row, col, delta)`:
`for i = row+1; i <= m; i += i&-i`
  `for j = col+1; j <= n; j += j&-j`
    `tree[i][j] += delta`

Query logic:
`query(row, col)`: sum `(0,0)` to `(row,col)`.
`for i = row+1; i > 0; i -= i&-i`
  `for j = col+1; j > 0; j -= j&-j`
    `sum += tree[i][j]`

Range Sum `(r1, c1, r2, c2)`:
`query(r2, c2) - query(r1-1, c2) - query(r2, c1-1) + query(r1-1, c1-1)`. (Inclusion-Exclusion).

---

## 2. Approach: 2D Fenwick Tree
## *2. Hướng tiếp cận: Cây Fenwick 2D*

### Logic
### *Logic*
1.  Map `matrix[i][j]` to `tree[i+1][j+1]`.
2.  Store `matrix` values to compute `delta`.
3.  Implement update and query.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Orthogonal Updates:** The dimensions work independently in the nested loops logic.
    *Cập nhật trực giao: Các chiều hoạt động độc lập trong logic vòng lặp lồng nhau.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Update $O(\log M \log N)$, Query $O(\log M \log N)$.
    *Độ phức tạp thời gian: O(log M log N).*
*   **Space Complexity:** $O(MN)$.
    *Độ phức tạp không gian: O(MN).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

Similar to 1D but propagating in grid.
`update(0,0)` affects `tree[1][1], tree[1][2]..., tree[2][1]...`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Generalize BIT to 2D. Very concise compared to 2D Segment Tree (Quadtree).
*Tổng quát hóa BIT lên 2D. Rất ngắn gọn so với Cây phân đoạn 2D (Quadtree).*
---
*Đôi khi ta cần nhìn thế giới theo nhiều chiều (2D). Sự thay đổi ở một điểm nhỏ có thể lan tỏa (propagate) ra toàn bộ khu vực chịu ảnh hưởng.*
Sometimes we need to see the world in multiple dimensions (2D). A change at a small point can propagate to the entire affected area.

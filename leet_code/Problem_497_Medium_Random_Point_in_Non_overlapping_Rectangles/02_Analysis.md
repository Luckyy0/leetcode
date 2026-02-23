# Analysis for Random Point in Non-overlapping Rectangles
# *Phân tích cho bài toán Điểm Ngẫu nhiên trong các Hình chữ nhật Không chồng lấn*

## 1. Problem Essence & Weighted Random Sampling
## *1. Bản chất vấn đề & Lấy mẫu Ngẫu nhiên có Trọng số*

### The Challenge
### *Thách thức*
Uniformly picking an integer point across multiple rectangles.
- Total points in a rectangle: $(x_i - a_i + 1) \times (y_i - b_i + 1)$. (Note the +1 because it's integer points, inclusive boundary).
- Probability of picking a rectangle should be proportional to its number of points (area/weight).
- Once a rectangle is picked, pick a point uniformly within it.

### Strategy: Prefix Sums + Binary Search
### *Chiến lược: Tổng Tiền tố + Tìm kiếm Nhị phân*

1.  **Preprocessing:**
    - Calculate number of points $w_i$ for each rectangle.
    - Build a prefix sum array `sums`, where `sums[i]` is the cumulative weight of rectangles `0..i`.
    - Total weight $W = sums[last]$.
2.  **Pick:**
    - Generate random integer $r$ in range $[0, W-1]$.
    - Find the rectangle index `idx` such that `sums[idx]` is the smallest value $> r$. Use `TreeMap` or Binary Search.
    - Inside rectangle `idx`, pick random $x$ offset and $y$ offset.

---

## 2. Approach: TreeMap or Arrays.binarySearch
## *2. Hướng tiếp cận: TreeMap hoặc Arrays.binarySearch*

### Logic
### *Logic*
(See above). The `sums` array is strictly increasing. `sums[i]` stores the upper bound (exclusive) of indices belonging to rectangle `i`.
E.g., weights [2, 3]. Sums [2, 5].
Random $r \in [0, 4]$.
If $r < 2$ (0, 1) -> Rect 0.
If $r \ge 2$ (2, 3, 4) -> Rect 1.
Use `binarySearch` on `sums` to finding insertion point.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Uniformity:** Weighted selection ensures global uniformity.
    *Tính đồng nhất: Lựa chọn có trọng số đảm bảo tính đồng nhất toàn cục.*
*   **Efficiency:** $O(N)$ init, $O(\log N)$ pick.
    *Hiệu quả: Khởi tạo O(N), chọn O(log N).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Init $O(N)$, Pick $O(\log N)$.
    *Độ phức tạp thời gian: O(log N).*
*   **Space Complexity:** $O(N)$ for prefix sums.
    *Độ phức tạp không gian: O(N).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[-2, -2, 1, 1], [2, 2, 4, 6]]`
1. Rect 0: $x: -2..1$ (width 4), $y: -2..1$ (height 4). Points $4 \times 4 = 16$.
2. Rect 1: $x: 2..4$ (width 3), $y: 2..6$ (height 5). Points $3 \times 5 = 15$.
3. Total 31. Sums `[16, 31]`.
4. Pick: $r = 20$.
   - $20 \ge 16$. Pick Rect 1.
   - Offset from start of Rect 1 range (16): $20 - 16 = 4$.
   - Pick 4th point in Rect 1.
   - Width 3. $x_{off} = 4 \% 3 = 1$. $y_{off} = 4 / 3 = 1$.
   - Point: $(2+1, 2+1) = (3, 3)$.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Weighted random selection using prefix sums of point counts.
*Lựa chọn ngẫu nhiên có trọng số sử dụng tổng tiền tố của số lượng điểm.*
---
*Công bằng (equally likely) không có nghĩa là chia đều cho mỗi nhóm (rectangles), mà là chia đều cho mỗi cá nhân (integer points). Một tập thể lớn (large area) xứng đáng có tiếng nói lớn hơn một tập thể nhỏ. Bằng cách dùng tổng tiền tố (prefix sums), ta trao quyền cho mỗi điểm số một cơ hội ngang nhau để được lựa chọn.*
Fairness (equally likely) does not mean dividing equally for each group (Rectangles), but divides equally for each individual (Integer Points). A large collective (Large Area) deserves a bigger voice than a small collective. By using Prefix Sums, we empower each point with an equal chance of being selected.

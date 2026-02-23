# Analysis for Line Reflection
# *Phân tích cho bài toán Đối xứng qua Đường thẳng*

## 1. Problem Essence & Midpoint Property
## *1. Bản chất vấn đề & Tính chất Trung điểm*

### The Challenge
### *Thách thức*
Given a set of points, find a vertical line $x = k$ such that for every point $(x, y)$, its reflection $(\text{sum} - x, y)$ is also in the set.

### Strategy: Math + Hash Set
### *Chiến lược: Toán học + Tập hợp*
1.  **Find the reflection sum:** The vertical line $x=k$ must be exactly in the center of the extreme points.
    - Let $minX$ and $maxX$ be the minimum and maximum x-coordinates.
    - $k = (minX + maxX) / 2$.
    - The reflection sum $S = minX + maxX$.
2.  **Unique Points:** Store all points in a `HashSet<String>` to handle duplicates and allow $O(1)$ lookup. Use a string format like `"x,y"` or `Objects.hash`.
3.  **Verification:** For every point $[x, y]$ in the set, check if $[S - x, y]$ also exists in the set.

### Edge Case
### *Trường hợp Góc*
- Duplicate points: Handled naturally by `Set`.
- Points on the line: Reflections of points on the line are themselves.

---

## 2. Approach: Hash Set Lookup
## *2. Hướng tiếp cận: Tra cứu Tập hợp*

### Logic
### *Logic*
(See above). The $S = minX + maxX$ trick avoids floating point issues with $k$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Linear time for one pass to find $min/max$ and one pass to verify.
    *Độ phức tạp O(N): Thời gian tuyến tính.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ to store the set of points.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[1,1], [-1,1], [0,0]]`
1. $minX = -1, maxX = 1$.
2. Sum $S = -1 + 1 = 0$.
3. Points in Set: `{"1,1", "-1,1", "0,0"}`.
4. Check:
   - `1,1` -> search `0 - 1, 1` = `-1,1` (Found).
   - `-1,1` -> search `0 - (-1), 1` = `1,1` (Found).
   - `0,0` -> search `0 - 0, 0` = `0,0` (Found).
Result: True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Set + Min/Max trick is the most efficient.
*Sử dụng Set + mẹo Min/Max là cách hiệu quả nhất.*
---
*Sự đối xứng (reflection) trong cuộc đời không chỉ là một quy luật toán học, nó còn là cách chúng ta tìm thấy sự cân bằng (midpoint) giữa những thái cực (min/max) khác nhau.*
Symmetry (reflection) in life is not just a mathematical rule, it is also how we find balance (midpoint) between different extremes (min/max).

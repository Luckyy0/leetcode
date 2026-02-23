# Analysis for Convex Polygon
# *Phân tích cho bài toán Đa giác Lồi*

## 1. Problem Essence & Cross Product
## *1. Bản chất vấn đề & Tích có hướng*

### The Challenge
### *Thách thức*
Determining if a sequence of points forms a convex polygon. A polygon is convex if traversing its edges involves turning in the same direction at every vertex (either all One way left or all right).

### Strategy: Cross Product Sign Check
### *Chiến lược: Kiểm tra Dấu của Tích có hướng*

1.  **Cross Product:** Given three points $A, B, C$, the cross product of vectors $\vec{AB}$ and $\vec{BC}$ tells us the orientation of the turn at $B$.
    - $\vec{AB} = (x_2 - x_1, y_2 - y_1)$
    - $\vec{BC} = (x_3 - x_2, y_3 - y_2)$
    - $CrossProduct = AB_x \cdot BC_y - AB_y \cdot BC_x$.
    - If $> 0$: Left turn (Counter-clockwise).
    - If $< 0$: Right turn (Clockwise).
    - If $= 0$: Collinear (Straight line).
2.  **Algorithm:**
    - Iterate through all vertices triplets $(i, i+1, i+2)$ modulo $N$.
    - Calculate the cross product for each turn.
    - Track the **first non-zero** cross product sign seen.
    - If we encounter a cross product with a **different sign** than the established direction, the polygon is concave. Return `false`.
    - If we finish the loop, it's convex.

---

## 2. Approach: Geometric Iteration
## *2. Hướng tiếp cận: Duyệt Hình học*

### Logic
### *Logic*
(See above). The key is to ignore collinear points (cross product 0) because they don't break convexity (they just lie on the straight edge between simpler vertices), unless they reverse direction which would be caught by a sign change later.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Single pass through the vertices.
    *Hiệu quả O(N): Duyệt qua các đỉnh một lần.*
*   **Space Efficient:** $O(1)$ extra space.
    *Hiệu quả không gian: O(1) không gian bổ sung.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of vertices.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[0,0],[0,10],[10,10],[10,0],[5,5]]`
1. `(0,0) -> (0,10) -> (10,10)`: Left turn (Positive).
   - Current direction: Positive.
2. `(0,10) -> (10,10) -> (10,0)`: Left turn (Positive).
   - Sign matches.
3. `(10,10) -> (10,0) -> (5,5)`: Left turn (Positive).
   - Sign matches.
4. `(10,0) -> (5,5) -> (0,0)`: **Right turn** (Negative).
   - Sign mismatch! (Positive vs Negative).
Result: `false`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sequential cross product sign verification.
*Xác minh dấu tích có hướng theo tuần tự.*
---
*Đa giác lồi (convex polygon) là hình ảnh của sự nhất quán (consistency). Khi bước đi trên hành trình bao quanh nó, ta không bao giờ phải đổi hướng nhìn (turn direction). Nếu một bước đi nào đó khiến ta phải ngoảnh lại (sign change) hay đi vào lòng bản thân (concavity), sự toàn vẹn của cấu trúc sẽ bị phá vỡ. Sự kiên định trong định hướng chính là yếu tố tạo nên sự vững chãi của hình hài.*
A convex polygon (convex polygon) is an image of consistency (consistency). When walking on the journey surrounding it, we never have to turn direction (Turn Direction). If a certain step makes us look back (Sign Change) or go into the heart (concavity), the integrity of the structure will be broken. The consistency in orientation is the factor creating the solidity of the shape.

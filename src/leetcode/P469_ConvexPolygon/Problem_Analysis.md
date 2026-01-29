# 469. Convex Polygon / Đa Giác Lồi

## Problem Description / Mô tả bài toán
Given a list of points that form a polygon when joined sequentially, find if this polygon is **convex**.
Cho một danh sách các điểm tạo thành một đa giác khi được nối theo thứ tự, hãy xác định xem đa giác này có phải là **lồi** hay không.

### Example 1:
```text
Input: points = [[0,0],[0,1],[1,1],[1,0]]
Output: true
```

### Example 2:
```text
Input: points = [[0,0],[0,10],[10,10],[10,0],[5,5]]
Output: false
```

## Constraints / Ràng buộc
- `3 <= points.length <= 10^4`
- `points[i].length == 2`
- `-10^4 <= xi, yi <= 10^4`
- All points are distinct.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Cross Product and Orientation / Tích có hướng và Hướng xoay
A polygon is convex if it always turns in the same direction (either clockwise or counter-clockwise) at every vertex.
The direction of the turn at vertex `B` (between segments `AB` and `BC`) can be determined by the **cross product** of vectors `AB` and `BC`.

For `A(x1, y1)`, `B(x2, y2)`, `C(x3, y3)`:
Vector $\vec{AB} = (x2-x1, y2-y1)$
Vector $\vec{BC} = (x3-x2, y3-y2)$
Cross product $CP = (x2-x1)(y3-y2) - (y2-y1)(x3-x2)$.

Rule:
1. For every consecutive triplet of points, calculate the cross product.
2. If `CP > 0`, it's a left turn.
3. If `CP < 0`, it's a right turn.
4. If `CP == 0`, the points are collinear (doesn't contribute to convexity).
5. For the polygon to be convex, all non-zero cross products must have the **same sign**.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of points.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Consecutive Cross Product Checking

**Algorithm**:
1.  Iterate through all triplets (including the wrap-around ones).
2.  Calculate cross products.
3.  Establish first non-zero sign.
4.  Ensure subsequent signs match.

---

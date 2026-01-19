# 223. Rectangle Area / Diện Tích Hình Chữ Nhật

## Problem Description / Mô tả bài toán
Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
Cho tọa độ của hai hình chữ nhật thẳng góc trong mặt phẳng 2D, hãy trả về tổng diện tích được bao phủ bởi hai hình chữ nhật.

The first rectangle is defined by its bottom-left corner `(ax1, ay1)` and its top-right corner `(ax2, ay2)`.
Hình chữ nhật đầu tiên được xác định bởi góc dưới bên trái `(ax1, ay1)` và góc trên bên phải `(ax2, ay2)`.

The second rectangle is defined by its bottom-left corner `(bx1, by1)` and its top-right corner `(bx2, by2)`.
Hình chữ nhật thứ hai được xác định bởi góc dưới bên trái `(bx1, by1)` và góc trên bên phải `(bx2, by2)`.

### Example 1:
```text
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45
```

### Example 2:
```text
Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
Output: 16
```

## Constraints / Ràng buộc
- `-10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Area of Union / Diện Tích Hợp
The total area covered by two geometric shapes is:
`Area(Union) = Area(A) + Area(B) - Area(Intersection)`
Tổng diện tích được bao phủ bởi hai hình học là:
`Diện tích(Hợp) = Diện tích(A) + Diện tích(B) - Diện tích(Giao)`

**Calculating Intersection**:
The intersection of two rectangles is also a rectangle (or empty).
- The width of the overlap is determined by the max of the left edges and the min of the right edges.
  `overlapWidth = min(ax2, bx2) - max(ax1, bx1)`
- The height of the overlap is determined by the max of the bottom edges and the min of the top edges.
  `overlapHeight = min(ay2, by2) - max(ay1, by1)`

If `overlapWidth <= 0` or `overlapHeight <= 0`, there is no intersection.

---

## Analysis / Phân tích

### Approach: Geometric Overlap Logic

**Algorithm**:
1.  Calculate `areaA = (ax2 - ax1) * (ay2 - ay1)`.
2.  Calculate `areaB = (bx2 - bx1) * (by2 - by1)`.
3.  Calculate `xOverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1)`.
4.  Calculate `yOverlap = Math.min(ay2, by2) - Math.max(ay1, by1)`.
5.  If `xOverlap > 0` and `yOverlap > 0`, `areaOverlap = xOverlap * yOverlap`. Else `areaOverlap = 0`.
6.  Return `areaA + areaB - areaOverlap`.

### Complexity / Độ phức tạp
- **Time**: O(1) - Simple arithmetic operations.
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **No Overlap**: Formula handles this (overlap area 0).
2.  **Complete Containment**: One rectangle inside another.
3.  **Identical Rectangles**: Area A + Area B - Area A = Area A.
4.  **Points/Lines**: Problem implies rectangles have area (corners distinct usually), but formula works for 0 area too.

# Analysis for Rectangle Area
# *Phân tích cho bài toán Diện tích hình chữ nhật*

## 1. Problem Essence & Geometry
## *1. Bản chất vấn đề & Hình học*

### The Idea
### *Ý tưởng*
Total Area = (Area of Rectangle A) + (Area of Rectangle B) - (Overlapping Area).
*Tổng diện tích = (Diện tích A) + (Diện tích B) - (Diện tích phần chồng lấn).*
This is basic set theory (Principle of Inclusion-Exclusion).
*Đây là lý thuyết tập hợp cơ bản (Nguyên lý Bao hàm - Loại trừ).*

### Calculating Overlap
### *Tính phần chồng lấn*
The overlap is also a rectangle (possibly with area 0).
Its boundaries are determined by:
- `left = max(ax1, bx1)`
- `right = min(ax2, bx2)`
- `bottom = max(ay1, by1)`
- `top = min(ay2, by2)`

If `right > left` AND `top > bottom`, then there is an overlap.
Overlap Area = `(right - left) * (top - bottom)`.
Otherwise, Overlap Area = 0.
*Ranh giới phần chồng lấn: trái = max(các trái), phải = min(các phải), v.v. Nếu phải > trái và trên > dưới thì có chồng lấn.*

---

## 2. Approach: Math
## *2. Hướng tiếp cận: Toán học*

### Logic
### *Logic*
1.  Calculate `areaA = (ax2 - ax1) * (ay2 - ay1)`.
2.  Calculate `areaB = (bx2 - bx1) * (by2 - by1)`.
3.  Calculate overlap dimensions:
    - `overlapWidth = min(ax2, bx2) - max(ax1, bx1)`.
    - `overlapHeight = min(ay2, by2) - max(ay1, by1)`.
4.  Overlap Area = `max(0, overlapWidth) * max(0, overlapHeight)`.
5.  Result = `areaA + areaB - overlapArea`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simplicity:** No complex data structures needed. Just primitive math.
    *Đơn giản: Không cần cấu trúc dữ liệu phức tạp. Chỉ cần toán học cơ bản.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. Just a few arithmetic operations.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** A: `[-3, 0], [3, 4]`. B: `[0, -1], [9, 2]`.

1.  Area A: `(3 - (-3)) * (4 - 0) = 6 * 4 = 24`.
2.  Area B: `(9 - 0) * (2 - (-1)) = 9 * 3 = 27`.
3.  Overlap:
    - Left: `max(-3, 0) = 0`.
    - Right: `min(3, 9) = 3`.
    - Bottom: `max(0, -1) = 0`.
    - Top: `min(4, 2) = 2`.
    - Width: `3 - 0 = 3`. Height: `2 - 0 = 2`.
    - Area: `3 * 2 = 6`.
4.  Total: `24 + 27 - 6 = 45`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Be careful with integer overflow if the coordinates are large, but here constraints say $10^4$, so total area fits in standard integer ($10^4 \times 10^4 = 10^8 < 2 \cdot 10^9$). Java `int` is fine.
*Cẩn thận với tràn số nguyên nếu tọa độ lớn. Ở đây $10^4$ là an toàn cho `int`.*
---
*Toán học đơn giản là vẻ đẹp của sự giao thoa: cái chung bị trừ đi để cái riêng được tỏa sáng đúng mực.*
Simple math is the beauty of intersection: the common is subtracted so the distinct can shine properly.

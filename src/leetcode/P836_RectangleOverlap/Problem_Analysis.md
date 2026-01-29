# 836. Rectangle Overlap / Sự Trùng lặp Hình chữ nhật

## Problem Description / Mô tả bài toán
An axis-aligned rectangle is represented as a list `[x1, y1, x2, y2]`.
Một hình chữ nhật căn chỉnh theo trục được đại diện bởi một danh sách `[x1, y1, x2, y2]`.

Given two rectangles `rec1` and `rec2`, return `true` if they overlap.
Cho hai hình chữ nhật `rec1` và `rec2`, trả về `true` nếu chúng trùng lặp.

Two rectangles overlap if the area of their intersection is positive. Two rectangles that only touch at the corner or edges do not overlap.
Hai hình chữ nhật trùng lặp nếu diện tích phần giao của chúng là số dương. Hai hình chữ nhật chỉ chạm nhau ở góc hoặc cạnh thì không trùng lặp.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Intersection of Intervals / Giao của các Khoảng
Two rectangles overlap if their X-projections overlap **and** their Y-projections overlap.
Hai hình chữ nhật trùng lặp nếu hình chiếu X của chúng trùng lặp **và** hình chiếu Y của chúng trùng lặp.

Algorithm:
1. Projection of `rec1` on X-axis: `(rec1[0], rec1[2])`.
2. Projection of `rec2` on X-axis: `(rec2[0], rec2[2])`.
3. Overlap on X if `max(rec1[0], rec2[0]) < min(rec1[2], rec2[2])`.
4. Overlap on Y if `max(rec1[1], rec2[1]) < min(rec1[3], rec2[3])`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Boundary Inequality
A simpler way to check is finding if one rectangle is completely to the left, right, top, or bottom of the other. If none of these are true, they must overlap.
Một cách đơn giản hơn để kiểm tra là xem một hình chữ nhật có nằm hoàn toàn ở bên trái, bên phải, phía trên hoặc phía dưới hình kia hay không. Nếu không có điều nào đúng, chúng phải trùng lặp.

---

# 963. Minimum Area Rectangle II / Diện tích Hình chữ nhật Nhỏ nhất II

## Problem Description / Mô tả bài toán
Given a set of points in the XY plane, find the minimum area of any rectangle formed from these points. The rectangle does NOT have to be parallel to the X and Y axes.
Cho một tập hợp các điểm trong mặt phẳng XY, hãy tìm diện tích nhỏ nhất của bất kỳ hình chữ nhật nào được tạo thành từ các điểm này. Hình chữ nhật KHÔNG nhất thiết phải song song với các trục X và Y.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Midpoint and Distance (Diagonal Property) / Điểm giữa và Khoảng cách (Thuộc tính Đường chéo)
A rectangle's diagonals are equal in length and bisect each other.
Đường chéo của hình chữ nhật có độ dài bằng nhau và cắt nhau tại trung điểm của mỗi đường.

Algorithm:
1. Iterate through all pairs of points `(p1, p2)`. Each pair is a potential diagonal.
2. Characterize each diagonal by its length squared and its midpoint `(x0, y0)`.
3. Store diagonals in a map: `(lengthSq, midpoint) -> list of diagonals`.
4. If two diagonals share the same length and midpoint, they form a rectangle.
5. Area = distance(p1, p3) * distance(p1, p4).

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Geometric Signature Matching
Model potential rectangles using their diagonal properties. By grouping pairs of points that share the same center and span the same distance, we identify all quadruplets forming a rectangle (even tilted ones) and calculate their area using the extracted geometry.
Mô hình hóa các hình chữ nhật tiềm năng bằng cách sử dụng các thuộc tính đường chéo của chúng. Bằng cách nhóm các cặp điểm có cùng tâm và cùng khoảng cách, chúng ta xác định được tất cả các bộ bốn tạo thành hình chữ nhật (kể cả những hình chữ nhật bị nghiêng) và tính diện tích của chúng bằng cách sử dụng thông tin hình học đã trích xuất.

---

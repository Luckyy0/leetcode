# 593. Valid Square / Hình Vuông Hợp Lệ

## Problem Description / Mô tả bài toán
Given the coordinates of four points in 2D space `p1`, `p2`, `p3` and `p4`, return `true` if the four points construct a square.
Cho tọa độ của bốn điểm trong không gian 2D `p1`, `p2`, `p3` và `p4`, hãy trả về `true` nếu bốn điểm tạo thành một hình vuông.

The coordinate of a point `pi` is represented as `[xi, yi]`. The input is not given in any order.
Tọa độ của một điểm `pi` được biểu diễn dưới dạng `[xi, yi]`. Đầu vào không được đưa ra theo bất kỳ thứ tự nào.

A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Một hình vuông hợp lệ có bốn cạnh bằng nhau với độ dài dương và bốn góc bằng nhau (góc 90 độ).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Distance Calculation / Tính Khoảng Cách
A square consists of 4 equal sides and 2 equal diagonals.
Total 6 distances between pairs of points.
- 4 distances should be equal to `side_len`.
- 2 distances should be equal to `sqrt(2) * side_len`.
- `side_len > 0`.

Algorithm:
1. Calculate squared distances between all pairs (p1-p2, p1-p3, p1-p4, p2-p3, p2-p4, p3-p4).
2. Store counts of distances in a map/frequency array.
3. Check if there are exactly 2 unique non-zero distance values.
4. If map size == 2:
   - Smaller val count should be 4 (sides).
   - Larger val count should be 2 (diagonals).
   - Larger val should be `2 * smaller val` (in squared distance).

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Distance Frequency Check

**Algorithm**:
1.  Compute all 6 pairwise squared distances.
2.  Store in Frequency Map.
3.  Validate structure (0 distances disallowed, exactly 2 unique positive distances).
4.  Optionally verify pythagorean relation between side and diagonal.

---

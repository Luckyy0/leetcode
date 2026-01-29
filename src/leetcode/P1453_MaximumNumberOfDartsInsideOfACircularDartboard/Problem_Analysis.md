# 1453. Maximum Number of Darts Inside of a Circular Dartboard / Số lượng Phi tiêu Tối đa Bên trong Bảng phi tiêu Tròn

## Problem Description / Mô tả bài toán
Points `darts` (x, y). Integers `r`.
Find max number of points inside a circle of radius `r`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Angular Sweep or Circle from 2 Points
Optimal circle either passes through 2 points as chord, or has 1 point on boundary, or determined by 2 points and radius.
Standard geometry problem: Smallest Enclosing Circle is different (min radius). Here Fixed Radius Max Points.
Approach:
Iterate pairs of points `(p1, p2)`.
If `dist(p1, p2) > 2r`, impossible to cover both.
Else, there are at most 2 circles of radius `r` passing through `p1` and `p2`. The centers can be calculated explicitly.
For each candidate center, count points inside.
Also check circles centered at each point (though 2-points covers this if we consider `p1=p2`? Or strictly 2 distinct points?
Wait. Is it possible optimal circle touches only 1 point? Yes, shift it until it hits another. So optimal circle always has at least 2 points on boundary (or we can rotate until it does), unless N=1.
Algorithm:
Max = 1.
For each pair `(i, j)`:
  Find 2 centers `c1, c2` for circle passing through `p_i, p_j` with radius `r`.
  Count points for `c1` and `c2`.
  Update max.
Be careful with `dist > 2r`.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Iterate Pairs
Iterate all pairs of points `i` and `j`.
If distance between them `<= 2*r`, calculate two possible centers for circle of radius `r` passing through `p[i]` and `p[j]`.
Scan all points `k` to see how many lie within circle. Update answer.
Handle `N=1` case.
Lặp lại tất cả các cặp điểm `i` và `j`.
Nếu khoảng cách giữa chúng `<= 2*r`, hãy tính toán hai tâm có thể cho vòng tròn có bán kính `r` đi qua `p[i]` và `p[j]`.
Quét tất cả các điểm `k` để xem có bao nhiêu điểm nằm trong vòng tròn. Cập nhật câu trả lời.

---

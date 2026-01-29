# 1515. Best Position for a Service Centre / Vị trí Tốt nhất cho Trung tâm Dịch vụ

## Problem Description / Mô tả bài toán
Points `positions`. Find point (x, y) minimizing sum of Euclidean distances to all points.
This is the Geometric Median problem.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Weiszfeld's Algorithm or Gradient Descent
Gradient Descent / Simulated Annealing.
Function $f(x, y) = \sum \sqrt{(x-x_i)^2 + (y-y_i)^2}$.
Convex function.
Gradient Descent works well.
Start at centroid (mean x, mean y).
Iterate updates. Adjust step size.
Or "Coordinate Descent": Fix y, optimize x. Fix x, optimize y.
Or Simple adaptive step search:
Start `curr`, step `1.0`.
Check 4 neighbors. If better, move there.
Else reduce step.
Until step very small.

### Complexity / Độ phức tạp
- **Time**: depends on iterations.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Adaptive Step Search (Gradient-like)
Start at centroid. Initial step size 100 (covers range).
While step > epsilon:
  Try moving `curr + step` in 4 directions.
  If improvement found, move there, don't reduce step.
  If no improvement in any direction, reduce step size (`step /= 2`).
Bắt đầu ở trọng tâm. Kích thước bước ban đầu 100.
Trong khi bước > epsilon:
  Thử di chuyển `curr + step` theo 4 hướng.
  Nếu tìm thấy sự cải thiện, hãy di chuyển đến đó, không giảm bước.
  Nếu không có sự cải thiện theo bất kỳ hướng nào, hãy giảm kích thước bước.

---

# 1496. Path Crossing / Đường dẫn Cắt nhau

## Problem Description / Mô tả bài toán
String `path` (N, S, E, W). Start (0, 0).
Return true if path crosses itself (visits same point twice).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hash Set of Coordinates
Track visited points. `(x, y)`.
Use `Set<String>` "x,y" or `Set<Long>` with encoding or `Set<Point>`.
Check if current point already in set.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Set Tracking
Add (0,0) to set.
Iterate directions. Update x, y.
Check existence.
Sử dụng Thẻ băm để theo dõi các điểm đã ghé thăm.

---

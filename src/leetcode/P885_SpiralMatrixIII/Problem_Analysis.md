# 885. Spiral Matrix III / Ma trận Xoắn ốc III

## Problem Description / Mô tả bài toán
You start at `(rStart, cStart)` in an `rows x cols` grid. You move in a clockwise spiral shape, starting by moving East.
Bạn bắt đầu tại `(rStart, cStart)` trong một lưới `rows x cols`. Bạn di chuyển theo hình xoắn ốc theo chiều kim đồng hồ, bắt đầu bằng cách di chuyển về phía Đông.

Whenever you move outside the grid, you continue walking outside (but you don't record the position until you re-enter).
Bất cứ khi nào bạn di chuyển ra ngoài lưới, bạn vẫn tiếp tục đi bên ngoài (nhưng bạn không ghi lại vị trí cho đến khi bạn quay trở lại).

Return the sequence of coordinates for every cell in the grid in the order you visit them.
Trả về chuỗi tọa độ cho mọi ô trong lưới theo thứ tự bạn truy cập chúng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation with Increasing Step Sizes / Mô phỏng với Kích thước Bước tăng dần
Algorithm:
1. Directions: `East, South, West, North`.
2. Initial `stepLength = 1`.
3. In each loop (two directions per `stepLength` update):
   - Move in first direction `stepLength` times.
   - Change direction.
   - Move in second direction `stepLength` times.
   - Change direction.
   - `stepLength++`.
4. At each step, if `(r, c)` is inside the grid, add it to result.
5. Stop when result has `rows * cols` entries.

### Complexity / Độ phức tạp
- **Time**: O(max(R, C)^2).
- **Space**: O(R * C) for result.

---

## Analysis / Phân tích

### Approach: Expanding Spiral Simulation
Model the growth of the spiral strictly. The pattern of movements (1,1, 2,2, 3,3...) ensures an even expansion. We filter the coordinates on-the-fly, only accepting those that lie within the valid grid boundaries until the grid is exhausted.
Mô hình hóa sự phát triển của vòng xoắn ốc một cách nghiêm ngặt. Mô hình các chuyển dời (1,1, 2,2, 3,3...) đảm bảo một sự mở rộng đồng đều. Chúng ta lọc các tọa độ ngay lập tức, chỉ chấp nhận những tọa độ nằm trong ranh giới lưới hợp lệ cho đến khi lưới cạn kiệt.

---

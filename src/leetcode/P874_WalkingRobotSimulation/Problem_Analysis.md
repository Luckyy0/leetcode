# 874. Walking Robot Simulation / Mô phỏng Robot Di chuyển

## Problem Description / Mô tả bài toán
A robot starts at `(0, 0)` facing North. It receives a list of commands:
Robot bắt đầu tại `(0, 0)` hướng về phía Bắc. Nó nhận được một danh sách các lệnh:
- `-2`: Turn left 90 degrees.
- `-1`: Turn right 90 degrees.
- `1 <= x <= 9`: Move forward `x` units.

There are `obstacles` at given coordinates. If the robot hits an obstacle, it stops at the last valid position.
Có các `obstacles` (vật cản) tại các tọa độ cho trước. Nếu robot chạm vật cản, nó sẽ dừng lại ở vị trí hợp lệ cuối cùng.

Return the maximum Euclidean distance squared the robot ever gets from the origin.
Trả về bình phương khoảng cách Euclidean lớn nhất mà robot từng đạt được so với gốc tọa độ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation with Obstacle Lookup / Mô phỏng với Tra cứu Vật cản
Algorithm:
1. Store obstacles in a `HashSet<String>` as `"x,y"` for O(1) lookup.
2. Maintain `(x, y)` and current `direction` (0: N, 1: E, 2: S, 3: W).
3. For each command:
   - Update direction if needed.
   - For move commands, step by step:
     - Check if next `(nx, ny)` is an obstacle.
     - Advance if clear.
   - Update `maxDistSq = max(maxDistSq, x*x + y*y)`.

### Complexity / Độ phức tạp
- **Time**: O(N + K*S) where N is commands, K is obstacles, and S is total steps.
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Step-wise Collision Detection
Implement the robot's movement incrementally. Before each single-unit step, verify the absence of an obstacle in the target cell to correctly handle the stopping behavior.
Triển khai chuyển động của robot theo từng bước nhỏ. Trước mỗi bước đơn vị, hãy xác minh sự vắng mặt của vật cản trong ô mục tiêu để xử lý chính xác hành vi dừng lại.

---

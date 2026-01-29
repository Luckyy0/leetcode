# 1041. Robot Bounded In Circle / Robot Bị Giới hạn trong Vòng tròn

## Problem Description / Mô tả bài toán
On an infinite plane, a robot initially stands at `(0, 0)` and faces north. The robot can receive one of three instructions:
Trên một mặt phẳng vô hạn, một robot ban đầu đứng tại `(0, 0)` và hướng về phía bắc. Robot có thể nhận một trong ba hướng dẫn:
- "G": go straight 1 unit.
- "L": turn 90 degrees to the left.
- "R": turn 90 degrees to the right.

The robot performs the instructions given in order, and repeats them forever. Return `true` if and only if there exists a circle in the plane such that the robot never leaves the circle.
Robot thực hiện các hướng dẫn được đưa ra theo thứ tự và lặp lại chúng mãi mãi. Trả về `true` nếu và chỉ nếu tồn tại một vòng tròn trong mặt phẳng sao cho robot không bao giờ rời khỏi vòng tròn đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Vector Simulation / Mô phỏng Vector
After one cycle of instructions, the robot is at `(x, y)` facing direction `d`.
Sau một chu kỳ hướng dẫn, robot ở tại `(x, y)` và hướng về phía `d`.
- If `(x, y) == (0, 0)`, it enters a cycle immediately. (Returns to start).
- If `(x, y) != (0, 0)`:
  - If `d` is North (original direction), the robot will continue to move by vector `(x, y)` in each cycle, drifting away to infinity.
  - If `d` is NOT North (South, East, West), the trajectory will form a closed loop (limit cycle of 4 or 2 iterations).

Algorithm:
1. Simulate one pass of the string.
2. Check final position `(x, y)` and direction.
3. Return `(x == 0 && y == 0) || (direction != North)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Vector Trajectory Analysis
Simulate a single iteration of the command sequence. Analyze the final state (position and orientation) relative to the start. If the robot returns to the origin or changes its orientation (ensuring a bounded loop over subsequent iterations), the trajectory is bounded. Only if it maintains the same orientation while displaced will it drift indefinitely.
Mô phỏng một lần lặp lại duy nhất của chuỗi lệnh. Phân tích trạng thái cuối cùng (vị trí và hướng) so với điểm bắt đầu. Nếu robot quay trở lại gốc tọa độ hoặc thay đổi hướng của nó (đảm bảo một vòng lặp giới hạn qua các lần lặp tiếp theo), quỹ đạo sẽ bị giới hạn. Chỉ khi nó duy trì cùng một hướng trong khi bị dịch chuyển thì nó mới trôi đi vô tận.

---

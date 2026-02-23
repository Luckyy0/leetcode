# Result for Walking Robot Simulation
# *Kết quả cho bài toán Mô phỏng Robot Di chuyển*

## Description
## *Mô tả*

A robot on an infinite XY-plane starts at point `(0, 0)` facing north. The robot can receive a sequence of these three possible types of commands:
*Một robot trên mặt phẳng XY vô hạn bắt đầu tại điểm `(0, 0)` hướng về phía bắc. Robot có thể nhận một chuỗi ba loại lệnh sau:*

- `-2`: Turn left 90 degrees.
- `-1`: Turn right 90 degrees.
- `1 <= k <= 9`: Move forward `k` units, one unit at a time.

Some of the grid squares are obstacles. The `i`-th obstacle is at grid point `obstacles[i] = [x_i, y_i]`. If the robot runs into an obstacle, then it should stay in its current location and move on to the next command.
*Một số ô lưới là chướng ngại vật. Chướng ngại vật thứ `i` nằm tại điểm lưới `obstacles[i] = [x_i, y_i]`. Nếu robot va vào chướng ngại vật, nó sẽ ở lại vị trí hiện tại và chuyển sang lệnh tiếp theo.*

Return *the **maximum Euclidean distance squared** that the robot ever gets from the origin*.
*Trả về *bình phương khoảng cách Euclidean **tối đa** mà robot từng đạt được so với gốc tọa độ*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** commands = [4,-1,3], obstacles = []
**Output:** 25
**Explanation:** The robot starts at (0, 0):
1. Move north 4 units to (0, 4).
2. Turn right.
3. Move east 3 units to (3, 4).
The furthest point the robot ever gets from the origin is (3, 4), and squared distance is 3^2 + 4^2 = 25.

## Example 2:
## *Ví dụ 2:*

**Input:** commands = [4,-1,4,-2,4], obstacles = [[2,4]]
**Output:** 65
**Explanation:** The robot starts at (0, 0):
1. Move north 4 units to (0, 4).
2. Turn right.
3. Move east 1 unit and hit an obstacle at (2, 4). Staying at (1, 4).
4. Turn left.
5. Move north 4 units to (1, 8).
The furthest point the robot ever gets from the origin is (1, 8), and squared distance is 1^2 + 8^2 = 65.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= commands.length <= 10^4`
*   `commands[i]` is either `-2`, `-1`, or an integer in the range `[1, 9]`.
*   `0 <= obstacles.length <= 10^4`
*   `-3 * 10^4 <= x_i, y_i <= 3 * 10^4`
*   The answer is guaranteed to be less than `2^31`.

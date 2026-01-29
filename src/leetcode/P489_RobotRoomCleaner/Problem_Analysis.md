# 489. Robot Room Cleaner / Robot Dọn Phòng

## Problem Description / Mô tả bài toán
You are controlling a robot in a room of `n x m` grid cells where some cells are walls and others are empty. The robot's goal is to clean all available cells.
Bạn đang điều khiển một robot trong một căn phòng gồm các ô lưới `n x m`, trong đó một số ô là tường và những ô khác là trống. Mục tiêu của robot là làm sạch tất cả các ô có thể tiếp cận.

The robot has 4 functions:
- `move()`: Moves forward if possible. Returns `true` if successful, `false` otherwise.
- `turnLeft()` / `turnRight()`: Turns 90 degrees.
- `clean()`: Cleans the current cell.

You don't know the room dimensions or your starting position. Design an algorithm to clean the whole room.
Bạn không biết kích thước phòng hoặc vị trí bắt đầu của mình. Hãy thiết kế một thuật toán để làm sạch toàn bộ căn phòng.

### Constraints / Ràng buộc
- The room is a grid.
- Robot can only move in 4 directions.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search (DFS) with Backtracking / DFS kết hợp Quay lui
Since we don't know the map, we must explore it like a maze. We use a `HashSet` to keep track of visited coordinates `(relative_x, relative_y)`.

Algorithm:
1. `dfs(x, y, d)`: (x, y are relative coordinates, d is current direction 0-3).
2. Mark `(x, y)` as visited and call `robot.clean()`.
3. For each direction `i` starting from current `d` to `d + 3`:
   - Calculate potential next coordinates `(nx, ny)` based on direction `i % 4`.
   - If `(nx, ny)` is not visited and `robot.move()` is successful:
     - Recurse: `dfs(nx, ny, i % 4)`.
     - **Backtrack**: Move the robot back to `(x, y)` and restore its original direction.
       - `turnRight()`, `turnRight()`, `move()`, `turnRight()`, `turnRight()`.
   - Always `robot.turnRight()` to transition to the next potential direction.

### Complexity / Độ phức tạp
- **Time**: O(N - W) where N is total cells and W is number of walls. We visit each empty cell once.
- **Space**: O(N - W) to store visited coordinates.

---

## Analysis / Phân tích

### Approach: Recursive Exploration with Virtual Coordinates

**Algorithm**:
1.  Relative (0,0) starting point.
2.  Directional array for coordinate updates.
3.  Full 4-way turn at each cell.
4.  Strict backtracking sequence.

---

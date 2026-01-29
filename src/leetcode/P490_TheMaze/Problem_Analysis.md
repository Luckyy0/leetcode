# 490. The Maze / Mê Cung

## Problem Description / Mô tả bài toán
There is a ball in a `maze` with empty spaces and walls. The ball can go through empty spaces by rolling **up, down, left or right**, but it won't stop rolling until it hits a wall. When the ball stops, it could choose the next direction.
Có một quả bóng trong một `mê cung` với các không gian trống và tường. Quả bóng có thể đi qua không gian trống bằng cách lăn **lên, xuống, sang trái hoặc sang phải**, nhưng nó sẽ không dừng lăn cho đến khi đập vào tường. Khi quả bóng dừng lại, nó có thể chọn hướng tiếp theo.

Given the ball's `start` position, the `destination` and the `maze`, determine whether the ball could stop at the destination.
Cho vị trí `start` của quả bóng, `destination` và `maze`, hãy xác định xem quả bóng có thể dừng lại tại điểm đến hay không.

The maze is represented by a binary 2D array. `1` means the wall and `0` means the empty space.
Mê cung được biểu diễn bằng mảng nhị phân 2 chiều. `1` là tường và `0` là không gian trống.

### Example 1:
```text
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: true
```

## Constraints / Ràng buộc
- `maze.length, maze[i].length <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / DFS with Rolling Logic / BFS / DFS với Logic Lăn bóng
The key difference between this and a standard maze is the movement. Instead of moving one cell at a time, the ball moves until it hits a wall.

Algorithm:
1. Use a Queue for BFS. Add the `start` position.
2. Maintain a `visited` boolean array.
3. While the queue is not empty:
   - Poll `curr`.
   - If `curr == destination`, return `true`.
   - For each of 4 directions:
     - Roll the ball in that direction: `while (next is within bounds and not a wall) { move next }`.
     - After hitting a wall, the ball stops at `(next_x - dir_x, next_y - dir_y)`.
     - If this stop position is not `visited`:
       - Mark as `visited`.
       - Add to queue.
4. Return `false`.

### Complexity / Độ phức tạp
- **Time**: O(M * N) as each cell is visited as a stop point at most once.
- **Space**: O(M * N) for the visited array.

---

## Analysis / Phân tích

### Approach: Stopping-Point BFS

**Algorithm**:
1.  Initialize Queue.
2.  Iterate 4 directions.
3.  Nested while loop for rolling.
4.  Track only stopping positions.

---

# 505. The Maze II / Mê Cung II

## Problem Description / Mô tả bài toán
There is a ball in a `maze` with empty spaces and walls. The ball can go through empty spaces by rolling **up, down, left or right**, but it won't stop rolling until it hits a wall. When the ball stops, it could choose the next direction.
Có một quả bóng trong một `mê cung` với các không gian trống và tường. Quả bóng có thể đi qua không gian trống bằng cách lăn **lên, xuống, sang trái hoặc sang phải**, nhưng nó sẽ không dừng lăn cho đến khi đập vào tường. Khi quả bóng dừng lại, nó có thể chọn hướng tiếp theo.

Given the ball's `start` position, the `destination` and the `maze`, return the **shortest distance** for the ball to stop at the destination. If the ball cannot stop at the destination, return `-1`.
Cho vị trí `start` của quả bóng, `destination` và `maze`, hãy trả về **khoảng cách ngắn nhất** để quả bóng dừng lại tại điểm đến. Nếu quả bóng không thể dừng lại tại điểm đến, hãy trả về `-1`.

The distance is defined by the number of empty spaces passed by the ball from the start position (excluding the start position) to the destination.
Khoảng cách được định nghĩa là số lượng không gian trống mà quả bóng đã đi qua từ vị trí bắt đầu đến khi dừng lại tại điểm đến.

### Example 1:
```text
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: 12
```

## Constraints / Ràng buộc
- `maze.length, maze[i].length <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dijkstra's Algorithm / Thuật toán Dijkstra
This is a shortest path problem on a graph where nodes are valid "stop points". The distance between two stop points is the number of steps rolled.

Algorithm:
1. Initialize a `distance[m][n]` array filled with infinity. Set `distance[start] = 0`.
2. Use a `PriorityQueue` to store `[x, y, dist]`, ordered by `dist` ascending.
3. While the queue is not empty:
   - Poll `[currX, currY, currDist]`.
   - If `currDist > distance[currX][currY]`, continue.
   - For each of 4 directions:
     - Roll until hits a wall.
     - Calculate number of steps `s`.
     - The new position is `(nx, ny)`.
     - New distance is `currDist + s`.
     - If `currDist + s < distance[nx][ny]`:
       - `distance[nx][ny] = currDist + s`.
       - Offer `[nx, ny, distance[nx][ny]]` to PQ.
4. Return `distance[destination]` if it's not infinity, else -1.

### Complexity / Độ phức tạp
- **Time**: O(M * N * log(M * N)).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Shortest Stopping-Point Search

**Algorithm**:
1.  Dijkstra with PQ.
2.  Rolling logic within neighbor expansion.
3.  Update distance matrix.

---

# 499. The Maze III / Mê Cung III

## Problem Description / Mô tả bài toán
There is a ball in a `maze` with empty spaces and walls. The ball can go through empty spaces by rolling **up (u), down (d), left (l) or right (r)**, but it won't stop rolling until it hits a wall or **falls into a hole**. When the ball stops, it could choose the next direction. There is also a `hole` in the maze, and the ball will stop rolling if it falls into the hole.
Có một quả bóng trong một `mê cung` với các không gian trống và tường. Quả bóng có thể đi qua không gian trống bằng cách lăn **lên (u), xuống (d), sang trái (l) hoặc sang phải (r)**, nhưng nó sẽ không dừng lăn cho đến khi đập vào tường hoặc **rơi xuống một cái hố**. Khi quả bóng dừng lại, nó có thể chọn hướng tiếp theo. Ngoài ra còn có một cái `hố` trong mê cung, và quả bóng sẽ dừng lăn nếu rơi xuống đó.

Given the ball's `start` position, the `hole` position and the `maze`, find out how the ball could fall into the hole by moving the **shortest distance**. The distance is defined by the number of empty spaces passed by the ball. If there are multiple valid paths, return the **lexicographically smallest** way. If the ball cannot fall into the hole, return "impossible".
Cho vị trí `start` của quả bóng, vị trí `hole` và `maze`, hãy tìm cách để quả bóng rơi xuống hố với **khoảng cách ngắn nhất**. Nếu có nhiều đường đi hợp lệ, hãy trả về cách có **thứ tự từ điển nhỏ nhất**. Nếu quả bóng không thể rơi xuống hố, hãy trả về "impossible".

## Constraints / Ràng buộc
- `maze.length, maze[i].length <= 30`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dijkstra's Algorithm / Thuật toán Dijkstra
To find the shortest path while considering lexicographical order, we use Dijkstra where each state is a node `(x, y)` and the priority is `(distance, pathString)`.

Algorithm:
1. State Node: `class Point { int x, y, dist; String path; }`.
2. PriorityQueue for Dijkstra: Order by `dist` ascending, then by `path` string lexicographically.
3. `dist[m][n]` and `path[m][n]` to store minimum distance and smallest path string to each cell.
4. From current point `(x, y)`:
   - For each direction `d, l, r, u`:
     - Roll until hits wall OR hole.
     - While rolling:
       - Keep track of distance.
       - If current position is `hole`, break rolling.
     - The new distance is `currDist + rollDist`.
     - The new path is `currPath + directionChar`.
     - Update and offer to PQ if `(newDist < dist[x][y])` or `(newDist == dist[x][y] && newPath.compareTo(path[x][y]) < 0)`.

### Complexity / Độ phức tạp
- **Time**: O(M * N * log(M * N) * L) where L is path length.
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Shortest Path with String Comparison

**Algorithm**:
1.  Dijkstra with custom state.
2.  Rolling detection with Hole priority.
3.  Secondary priority: Lexicographical path comparison.

---

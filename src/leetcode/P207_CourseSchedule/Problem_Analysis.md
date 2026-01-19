# 207. Course Schedule / Lịch Trình Khóa Học

## Problem Description / Mô tả bài toán
There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you **must** take course `bi` first if you want to take course `ai`.
Có tổng cộng `numCourses` khóa học bạn phải tham gia, được đánh số từ `0` đến `numCourses - 1`. Bạn được cung cấp một mảng `prerequisites` trong đó `prerequisites[i] = [ai, bi]` chỉ ra rằng bạn **phải** tham gia khóa học `bi` trước nếu bạn muốn tham gia khóa học `ai`.

- For example, the pair `[0, 1]`, indicates that to take course 0 you have to first take course 1.
- Ví dụ, cặp `[0, 1]` chỉ ra rằng để tham gia khóa học 0, bạn phải tham gia khóa học 1 trước.

Return `true` if you can finish all courses. Otherwise, return `false`.
Trả về `true` nếu bạn có thể hoàn thành tất cả các khóa học. Nếu không, trả về `false`.

### Example 1:
```text
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
```

### Example 2:
```text
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
```

## Constraints / Ràng buộc
- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= 5000`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`
- All the pairs prerequisites[i] are **unique**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Topological Sort & Cycle Detection / Sắp xếp Topo & Phát hiện Chu trình
This problem is equivalent to determining if a directed graph has a **cycle**.
Bài toán này tương đương với việc xác định xem một đồ thị có hướng có **chu trình** hay không.

- Each course is a node.
- `[a, b]` (b implies a) is a directed edge `b -> a`.
- If there is a cycle (e.g., 0->1->0), we cannot complete the courses.

There are two main algorithms:
1.  **Kahn's Algorithm (BFS)**: Uses in-degree counting.
    - Calculate in-degrees for all nodes.
    - Add nodes with in-degree 0 to a queue.
    - While queue is not empty, remove node `u`, decrease in-degree of neighbors. If neighbor's in-degree becomes 0, add to queue.
    - If count of processed nodes == numCourses, no cycle.

2.  **DFS with Coloring**:
    - Use states: `0` (Unvisited), `1` (Visiting), `2` (Visited).
    - If we encounter a node with state `1` during DFS, a cycle exists.

---

## Analysis / Phân tích

### Approach: Kahn's Algorithm (BFS)

**Algorithm**:
1.  Build Adjacency List `adj` and `indegree` array.
2.  Populate `adj` and `indegree` from `prerequisites`.
3.  Queue `q` initialized with nodes where `indegree[i] == 0`.
4.  Loop:
    - Poll `curr`. Count++.
    - For each `next` in `adj[curr]`:
        - `indegree[next]--`.
        - If `indegree[next] == 0`, add to `q`.
5.  Return `count == numCourses`.

**Complexity / Độ phức tạp**:
- **Time**: O(V + E) - Build graph and traverse.
- **Space**: O(V + E) - Adjacency list and arrays.

---

## Edge Cases / Các trường hợp biên
1.  **No prerequisites**: Possible (return true).
2.  **Self loop**: e.g., `[0, 0]` -> Cycle (return false).
3.  **Disconnected graph**: Valid as long as no cycles in any component.
4.  **Complex cycle**: 0->1->2->0.

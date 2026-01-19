# 210. Course Schedule II / Lịch Trình Khóa Học II

## Problem Description / Mô tả bài toán
There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you **must** take course `bi` first if you want to take course `ai`.
Có tổng cộng `numCourses` khóa học bạn phải tham gia, được đánh số từ `0` đến `numCourses - 1`. Bạn được cung cấp một mảng `prerequisites` trong đó `prerequisites[i] = [ai, bi]` chỉ ra rằng bạn **phải** tham gia khóa học `bi` trước nếu bạn muốn tham gia khóa học `ai`.

Return **the ordering of courses** you should take to finish all courses. If there are many valid answers, return **any** of them. If it is impossible to finish all courses, return **an empty array**.
Trả về **thứ tự các khóa học** bạn nên tham gia để hoàn thành tất cả các khóa học. Nếu có nhiều câu trả lời hợp lệ, hãy trả về **bất kỳ** câu trả lời nào trong số đó. Nếu không thể hoàn thành tất cả các khóa học, hãy trả về **một mảng rỗng**.

### Example 1:
```text
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: To take course 1 you should have finished course 0. So the correct course order is [0,1].
```

### Example 2:
```text
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: Test case [0,1,2,3] is also valid.
```

## Constraints / Ràng buộc
- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= numCourses * (numCourses - 1)`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Topological Sort / Sắp xếp Topo
Unlike Problem 207 (detection), this problem asks for the actual sort order.
Khác với Bài 207 (phát hiện), bài toán này yêu cầu thứ tự sắp xếp thực tế.

**Kahn's Algorithm (BFS)** is perfect here:
1.  As we poll node `u` from the queue (meaning all its prerequisites are met), add `u` to the `result` list.
2.  If the size of `result` equals `numCourses`, return the array.
3.  Otherwise, return empty array (cycle detected).

**DFS Approach**:
1.  Post-order traversal: Visit children, then add node to stack.
2.  Reverse the stack to get topological order.
3.  Must handle cycle detection during DFS using 3-color states.

---

## Analysis / Phân tích

### Approach: Kahn's Algorithm (BFS)

**Algorithm**:
1. Build `adj` and `indegree`.
2. Queue `q` gets nodes with indegree 0.
3. While `q` not empty:
    - `curr = q.poll()`
    - `result[idx++] = curr`
    - Decrease indegree of neighbors, add to `q` if 0.
4. If `idx == numCourses`, return `result`. Else return `[]`.

**Complexity / Độ phức tạp**:
- **Time**: O(V + E).
- **Space**: O(V + E).

---

## Edge Cases / Các trường hợp biên
1.  **Cycle**: Return `[]`.
2.  **Disconnected components**: Handled correctly.
3.  **No prerequisites**: e.g., `numCourses=2, []`. Returns `[0, 1]` or `[1, 0]`.

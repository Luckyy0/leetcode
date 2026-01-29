# 1136. Parallel Courses / Các Khóa học Song song

## Problem Description / Mô tả bài toán
There are `n` courses, labeled from 1 to `n`. You are given an array `relations` where `relations[i] = [prevCourse, nextCourse]`.
In one semester, you can take any number of courses as long as you have taken all the prerequisites for the courses you are taking.
Return the minimum number of semesters to take all courses. If there is no way to take all courses, return -1.
Có `n` khóa học, được đánh số từ 1 đến `n`. Bạn được cho một mảng `relations` trong đó `relations[i] = [prevCourse, nextCourse]`.
Trong một học kỳ, bạn có thể tham gia bất kỳ số lượng khóa học nào miễn là bạn đã hoàn thành tất cả các khóa học tiên quyết cho các khóa học bạn đang tham gia.
Trả về số lượng học kỳ tối thiểu để hoàn thành tất cả các khóa học. Nếu không có cách nào để hoàn thành tất cả các khóa học, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Topological Sort (Kahn's Algorithm) / Sắp xếp Tô pô (Thuật toán Kahn)
We need to find the longest path in the dependency DAG.
Algorithm:
1. Build adjacency list and in-degree array.
2. Queue for courses with 0 in-degree.
3. BFS level by level.
   - `semesters = 0`.
   - `count = 0`.
   - Loop while queue not empty:
     - `semesters++`.
     - Process all nodes currently in queue (this level).
     - For each node, decrement neighbor in-degrees.
     - If neighbor in-degree becomes 0, add to next level.
4. If `count == n`, return `semesters`. Else return -1 (cycle).

### Complexity / Độ phức tạp
- **Time**: O(V + E).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: Level-Based Topological Sort
Model the courses and prerequisites as a directed graph. The minimum number of semesters corresponds to the number of levels (or the height) of the dependency graph. Use Kahn's algorithm (BFS-based topological sort) to process nodes level-by-level. A valid topological sort confirms no cycles exist; if fewer than $N$ nodes are processed, a cycle prevents completion.
Mô hình hóa các khóa học và các điều kiện tiên quyết dưới dạng đồ thị có hướng. Số lượng học kỳ tối thiểu tương ứng với số cấp độ (hoặc chiều cao) của đồ thị phụ thuộc. Sử dụng thuật toán Kahn (sắp xếp tô pô dựa trên BFS) để xử lý các nút theo từng cấp độ. Thực hiện sắp xếp tô pô hợp lệ xác nhận không tồn tại chu kỳ; nếu xử lý ít hơn $N$ nút, một chu kỳ sẽ ngăn cản quá trình hoàn thành.

---

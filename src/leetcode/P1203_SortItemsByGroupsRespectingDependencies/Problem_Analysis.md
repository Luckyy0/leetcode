# 1203. Sort Items by Groups Respecting Dependencies / Sắp xếp các Mặt hàng theo Nhóm Tôn trọng Sự Phụ thuộc

## Problem Description / Mô tả bài toán
`n` items, `m` groups. `group[i]` is the group of i-th item (-1 if none).
`beforeItems[i]` is list of items that must come before item `i`.
Return a sorted list of items such that:
- Items in the same group are adjacent.
- `beforeItems` dependencies are respected.
Return empty if impossible.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Topological Sort (Double Layer) / Sắp xếp Tô pô (Hai Lớp)
This is a hierarchical topological sort problem.
1. Items dependencies:
   - If `u -> v` (u comes before v):
     - If `group[u] == group[v]`: Add dependency `u -> v` within group.
     - If `group[u] != group[v]`: Add dependency `group[u] -> group[v]` between groups.
2. Sort Groups:
   - Use group dependencies to topologically sort the groups.
3. Sort Items within Groups:
   - For each group, use intra-group dependencies to sort items.
4. Assemble result:
   - Iterate sorted groups. For each group, append sorted items.
   - Handle `-1` groups: Convert each `-1` item to a unique new group ID (e.g., `m, m+1...`) to simplify logic.

### Complexity / Độ phức tạp
- **Time**: O(N + E).
- **Space**: O(N + E).

---

## Analysis / Phân tích

### Approach: Two-Level Topological Sort
Treat this as two topological sorting problems: one for the relative order of groups and one for the relative order of items within each group.
1. Assign unique group IDs to items with `group[i] == -1` to simplify handling.
2. Build two graphs: `groupGraph` representing dependencies between groups, and `itemGraph` representing dependencies between items within the same group.
3. If item `u` must precede item `v`:
   - If they share the same group, add edge `u -> v` to `itemGraph`.
   - If they belong to different groups, add edge `group[u] -> group[v]` to `groupGraph`.
4. Perform topological sort on `groupGraph`. If a cycle exists, return empty.
5. Perform topological sort on items within each group. If cycle, return empty.
6. Concatenate the sorted items according to the sorted group order.

Coi đây là hai bài toán sắp xếp tô pô: một cho thứ tự tương đối của các nhóm và một cho thứ tự tương đối của các mục trong mỗi nhóm.
1. Gán ID nhóm duy nhất cho các mục có `group[i] == -1` để đơn giản hóa việc xử lý.
2. Xây dựng hai đồ thị: `groupGraph` đại diện cho sự phụ thuộc giữa các nhóm và `itemGraph` đại diện cho sự phụ thuộc giữa các mục trong cùng một nhóm.
3. Nếu mục `u` phải đứng trước mục `v`:
   - Nếu chúng có chung nhóm, thêm cạnh `u -> v` vào `itemGraph`.
   - Nếu chúng thuộc các nhóm khác nhau, thêm cạnh `group[u] -> group[v]` vào `groupGraph`.
4. Thực hiện sắp xếp tô pô trên `groupGraph`. Nếu tồn tại chu trình, trả về rỗng.
5. Thực hiện sắp xếp tô pô trên các mục trong mỗi nhóm. Nếu có chu trình, trả về rỗng.
6. Nối các mục đã sắp xếp theo thứ tự nhóm đã sắp xếp.

---

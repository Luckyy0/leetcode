# 1443. Minimum Time to Collect All Apples in a Tree / Thời gian Tối thiểu để Thu thập Tất cả Táo trong Cây

## Problem Description / Mô tả bài toán
Tree `n` nodes. Edge list `edges`. `hasApple` list.
Start at node 0. Collect all apples return to 0.
Time = 2 * number of edges traversed.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS
`dfs(node)` returns time spent in subtree of `node`.
For each child `v` of `u`:
  `subtreeTime = dfs(v)`.
  If `subtreeTime > 0` OR `hasApple[v]`:
    Total time += `subtreeTime + 2` (2 for edge u-v back and forth).
Return Total time.
Root logic: if return > 0, result is return.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Bottom-Up DFS
Build adjacency list. DFS from 0.
For each child, if it (or its descendants) has apples, we must traverse the edge to it. Cost is 2 + cost of child.
If child returns 0 and child itself has NO apple, cost 0 (prune branch).
Recursive step: `res += dfs(child)`. If result changed (or logic), add 2?
Actually: `time = dfs(child)`.
If `time > 0` OR `hasApple[child]`: `total += time + 2`.
Return `total`.
Root call returns total.
Xây dựng danh sách kề. DFS từ 0.
Đối với mỗi con, nếu nó (hoặc hậu duệ của nó) có táo, chúng ta phải duyệt cạnh đến nó. Chi phí là 2 + chi phí của con.
Nếu con trả về 0 và bản thân con KHÔNG có táo, chi phí 0.
Bước đệ quy: `res += dfs(child)`. Nếu kết quả thay đổi, cộng 2?
Thực ra: `time = dfs(child)`.
Nếu `time > 0` HOẶC `hasApple[child]`: `total += time + 2`.
Trả về `total`.

---

# 1376. Time Needed to Inform All Employees / Thời gian Cần thiết để Thông báo cho Tất cả Nhân viên

## Problem Description / Mô tả bài toán
`n` employees. Tree structure. `headID` is root.
`manager[i]` is manager of `i`.
`informTime[i]` is time for `i` to inform direct subordinates.
Time to inform all?
It's Max Path Sum in a tree from root to leaf (considering sum of inform times along path).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS / BFS
Build adjacency list (manager -> employees).
DFS from `headID`.
`maxTime = max(dfs(child) + informTime[root])`.
Or simple BFS/DFS tracking `currentTime`.
Start: `(headID, 0)`.
For each subordinate: `time + informTime[head]`.
Max time seen is answer.
Wait, inform happens in parallel for all subordinates.
So from manager `u` to subordinates `v1, v2...`:
`v1` gets news at `arrival[u] + informTime[u]`.
`v2` gets news at `arrival[u] + informTime[u]`.
Recursive: `Time(u) = informTime[u] + max(Time(v) for all children v)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive DFS
Build the tree using an adjacency list. Perform a DFS starting from the `headID`. For each node `u`, the time required is `informTime[u]` plus the maximum time required by any of its subordinates (since notifications happen in parallel branches, the bottleneck is the longest branch). Base case: leaf node returns 0.
Xây dựng cây bằng danh sách kề. Thực hiện DFS bắt đầu từ `headID`. Đối với mỗi nút `u`, thời gian cần thiết là `informTime[u]` cộng với thời gian tối đa mà bất kỳ cấp dưới nào của nó yêu cầu (vì thông báo xảy ra trong các nhánh song song, nút thắt cổ chai là nhánh dài nhất). Trường hợp cơ sở: nút lá trả về 0.

---

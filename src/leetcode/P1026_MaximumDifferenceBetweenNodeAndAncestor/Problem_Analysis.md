# 1026. Maximum Difference Between Node and Ancestor / Sự khác biệt Lớn nhất giữa Nút và Tổ tiên

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, find the maximum value `v` for which there exist different nodes `a` and `b` where `v = |a.val - b.val|` and `a` is an ancestor of `b`.
Cho `root` của một cây nhị phân, hãy tìm giá trị lớn nhất `v` sao cho tồn tại các nút khác nhau `a` và `b` trong đó `v = |a.val - b.val|` và `a` là tổ tiên của `b`.

A node `a` is an ancestor of `b` if either: any child of `a` is equal to `b` or any child of `a` is an ancestor of `b`.
Nút `a` là tổ tiên của `b` nếu: bất kỳ con nào của `a` bằng `b` hoặc bất kỳ con nào của `a` là tổ tiên của `b`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search (DFS) with Range Tracking / DFS với theo dõi phạm vi
For any node, the maximum difference with any ancestor is determined by the minimum and maximum values encountered `from the root down to that node`.
Đối với bất kỳ nút nào, sự khác biệt lớn nhất với bất kỳ tổ tiên nào được xác định bởi các giá trị tối thiểu và tối đa gặp phải `từ gốc xuống nút đó`.

Algorithm:
1. `dfs(node, minVal, maxVal)`
2. Update `maxDiff` with `max(|node.val - minVal|, |node.val - maxVal|)`.
3. Update `minVal = min(minVal, node.val)`, `maxVal = max(maxVal, node.val)`.
4. Recurse left and right.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Ancestral Min-Max Propagation
Traverse the tree while carrying the minimum and maximum values seen so far along the current path. At each node, calculate the difference between the current value and these path extremes to find the local maximum difference, updating the global result accordingly.
Duyệt cây trong khi mang theo các giá trị tối thiểu và tối đa đã thấy cho đến nay dọc theo đường dẫn hiện tại. Tại mỗi nút, hãy tính chênh lệch giữa giá trị hiện tại và các cực trị đường dẫn này để tìm chênh lệch tối đa cục bộ, cập nhật kết quả toàn cục tương ứng.

---

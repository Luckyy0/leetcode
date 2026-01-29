# 965. Univalued Binary Tree / Cây Nhị phân Đơn trị

## Problem Description / Mô tả bài toán
A binary tree is **univalued** if every node in the tree has the same value.
Một cây nhị phân được gọi là **đơn trị** nếu mọi nút trong cây đều có cùng một giá trị.

Given `root`, return `true` if the tree is univalued.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Value Comparison / So sánh Giá trị Đệ quy
Algorithm:
1. If node is null, return `true`.
2. Check if children have the same value as current node.
3. Recursively check `isUnivalued(left)` and `isUnivalued(right)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive Uniformity check
Verify that the current node matches the expected global value (starting with the root's value). Propagate this requirement down all branches; if any node deviates or a child subtree fails the check, the entire tree is invalidated.
Xác minh rằng nút hiện tại khớp với giá trị toàn cục mong đợi (bắt đầu bằng giá trị của gốc). Lan truyền yêu cầu này xuống tất cả các nhánh; nếu bất kỳ nút nào lệch hướng hoặc một cây con bị lỗi khi kiểm tra, toàn bộ cây sẽ không hợp lệ.

---

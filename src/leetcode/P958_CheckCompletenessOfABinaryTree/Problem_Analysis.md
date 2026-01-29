# 958. Check Completeness of a Binary Tree / Kiểm tra tính Đầy đủ của Cây Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, determine if it is a **complete** binary tree.
Cho gốc `root` của một cây nhị phân, hãy xác định xem nó có phải là một cây nhị phân **đầy đủ** hay không.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
Trong một cây nhị phân đầy đủ, mọi cấp độ, ngoại trừ có thể là cấp độ cuối cùng, đều được lấp đầy hoàn toàn và tất cả các nút ở cấp độ cuối cùng đều nằm ở phía bên trái nhất có thể.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Level-order Traversal (BFS) / Duyệt theo cấp độ (BFS)
Algorithm:
1. Perform BFS. Add `null` children to the queue as well.
2. Once we encounter the first `null` node:
   - Every subsequent node in the BFS must also be `null`.
3. If we find a non-null node after a `null` node, the tree is NOT complete.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Continuity Check
Use level-order traversal to "flatten" the tree. In a complete binary tree, there should be no gaps (nulls) between active nodes. Encountering any real data after the first void indicates a structural fragmentation that violates the "as far left as possible" rule.
Sử dụng duyệt theo cấp độ để "làm phẳng" cây. Trong một cây nhị phân đầy đủ, không nên có khoảng trống (null) giữa các nút đang hoạt động. Việc gặp bất kỳ dữ liệu thực nào sau khoảng trống đầu tiên cho thấy sự phân mảnh cấu trúc vi phạm quy tắc "về phía trái nhất có thể".

---

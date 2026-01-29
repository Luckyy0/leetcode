# 1506. Find Root of N-Ary Tree / Tìm Gốc của Cây N-Ary

## Problem Description / Mô tả bài toán
List of all `Node` objects. Each node has list of children.
Find root (node with no parent).
O(1) space complexity required (ignoring recursion/input). Note value property is unique? "Each node has a unique value".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sum / XOR Trick
Sum of all node values - Sum of all children node values = Root value.
Because every node except root is a child of exactly 1 node.
So every non-root node appears once as `node` and once as `child`.
Root appears only as `node`.
Alternatively, XOR sum. `TotalXOR ^ ChildXOR = RootVal`.
Then find node with `val == RootVal`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Logic Sum / XOR
Iterate all nodes. `sum += node.val`.
For each child of node, `sum -= child.val`.
Or XOR.
Resulting sum is root's value.
Find node with that value.
Lặp lại tất cả các nút. `sum += node.val`.
Đối với mỗi con của nút, `sum -= child.val`.
Tổng kết quả là giá trị của gốc.
Tìm nút có giá trị đó.

---

# 1273. Delete Tree Nodes / Xóa Nút Cây

## Problem Description / Mô tả bài toán
Tree `nodes` and `parent` array. `value` array.
Delete nodes if subtree sum is 0.
"Delete node" means delete it and all its children.
Return number of remaining nodes.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Post-Order Traversal (DFS) / Duyệt Hậu thứ tự (DFS)
We need subtree sum. Compute from leaves up.
State for each node: `(sum, count)`.
DFS(u):
- Init `sum = value[u]`, `count = 1`.
- For each child v:
  - `(s, c) = DFS(v)`.
  - `sum += s`, `count += c`.
- If `sum == 0`, return `(0, 0)` (meaning whole subtree deleted, count contributes 0 to parent).
  - Note: parent also needs to ignore this node's weight in sum?
  - Problem: "Delete nodes if subtree sum is 0". If sum 0, whole subtree gone.
  - So `count` becomes 0 for this node relative to global answer, AND its sum contribution to parent becomes 0? "Delete ... and its children". Yes, physically removed. So its value doesn't add to parent.
  - Actually, "Tree structure doesn't reform". Just nodes gone.
  - If node u deleted, parent doesn't receive its sum.
  - Correct. Return `(0, 0)`.
- If `sum != 0`, return `(sum, count)`.
Global answer is `count` of root.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Post-Order DFS
Build adjacency list from `parent` array. Perform DFS from root (usually node 0).
DFS function returns `{subtreeSum, nodeCount}`.
For a node `u`:
1. Initialize `currentSum = value[u]`, `currentCount = 1`.
2. Iterate through children. Recursively call DFS. Add child's returned sum and count to current.
3. Check `currentSum`.
   - If `0`, effectively delete this subtree. Return `{0, 0}` to parent (so parent doesn't count these nodes or sum).
   - If non-zero, return `{currentSum, currentCount}`.
Result is the `nodeCount` returned by the root call.
Xây dựng danh sách kề từ mảng `parent`. Thực hiện DFS từ gốc (thường là nút 0).
Hàm DFS trả về `{subtreeSum, nodeCount}`.
Đối với một nút `u`:
1. Khởi tạo `currentSum = value[u]`, `currentCount = 1`.
2. Lặp lại qua các con. Gọi đệ quy DFS. Thêm tổng và số lượng trả về của con vào hiện tại.
3. Kiểm tra `currentSum`.
   - Nếu `0`, xóa hiệu quả cây con này. Trả về `{0, 0}` cho cha (để cha không đếm các nút hoặc tổng này).
   - Nếu khác không, trả về `{currentSum, currentCount}`.
Kết quả là `nodeCount` được trả về bởi cuộc gọi gốc.

---

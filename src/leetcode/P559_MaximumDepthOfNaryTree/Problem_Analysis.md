# 559. Maximum Depth of N-ary Tree / Độ Sâu Lớn Nhất Của Cây N-ary

## Problem Description / Mô tả bài toán
Given a n-ary tree, find its maximum depth.
Cho một cây n-ary, hãy tìm độ sâu lớn nhất của nó.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Độ sâu lớn nhất là số lượng nút dọc theo đường đi dài nhất từ nút gốc xuống nút lá xa nhất.

### Node Structure:
```java
class Node {
    public int val;
    public List<Node> children;
}
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search / Tìm Kiếm Theo Chiều Sâu
Algorithm:
1. If `root` is null, depth is 0.
2. Initialize `maxChildDepth = 0`.
3. For each `child` in `root.children`:
   - `maxChildDepth = max(maxChildDepth, maxDepth(child))`.
4. Return `maxChildDepth + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive Depth Calculation

**Algorithm**:
1.  Recursively find depth of all children.
2.  Take maximum of child depths.
3.  Add 1 for current node.

---

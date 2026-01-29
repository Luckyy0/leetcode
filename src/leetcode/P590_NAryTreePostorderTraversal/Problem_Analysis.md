# 590. N-ary Tree Postorder Traversal / Duyệt Hậu Thứ Tự Cây N-ary

## Problem Description / Mô tả bài toán
Given the `root` of an n-ary tree, return the postorder traversal of its nodes' values.
Cho `root` của một cây n-ary, hãy trả về phép duyệt hậu thứ tự của các giá trị nút của nó.

### Example 1:
```text
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS (Recursive / Iterative) / DFS (Đệ quy / Lặp)
Postorder: `Children (Left to Right) -> Root`.

Recursive:
1. For each `child` in `children`: `traverse(child)`.
2. Add `root.val`.

Iterative:
1. Trick: Preorder is `Root -> Left -> Right`.
   Modified Preorder `Root -> Right -> Left`.
   Reverse result -> `Left -> Right -> Root` (Postorder).
2. Use Stack. Push `root`.
3. Pop `curr`, add to result (or temp list).
4. Push children (Left to Right -> so Right comes out last? No).
   If we want `Root -> Right -> Left`, we push Left then Right (Right on top).
   Then reverse list.
   
Alternatively, use explicit stack managing index state (harder).
Reverse method is standard iterative approach.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Algorithm**:
1.  Iterate children.
2.  Recursively visit each child.
3.  Visit Root.

---

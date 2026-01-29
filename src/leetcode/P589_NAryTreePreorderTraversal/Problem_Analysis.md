# 589. N-ary Tree Preorder Traversal / Duyệt Tiền Thứ Tự Cây N-ary

## Problem Description / Mô tả bài toán
Given the `root` of an n-ary tree, return the preorder traversal of its nodes' values.
Cho `root` của một cây n-ary, hãy trả về phép duyệt tiền thứ tự của các giá trị nút của nó.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value.
Việc tuần tự hóa đầu vào Cây Nary được thể hiện trong phép duyệt theo thứ tự mức của chúng. Mỗi nhóm con được phân tách bằng giá trị null.

### Example 1:
```text
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS (Recursive / Iterative) / DFS (Đệ quy / Lặp)
Preorder: `Root -> Children (Left to Right)`.

Recursive:
1. Add `root.val`.
2. For each `child` in `children`: `traverse(child)`.

Iterative:
1. Stack. Push `root`.
2. While stack not empty:
   - Pop `curr`. Add to result.
   - Push children in **reverse order** (so that leftmost is popped first).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (recursion stack or explicit stack).

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Algorithm**:
1.  Visit Root.
2.  Iterate children.
3.  Recursively visit each child.

---

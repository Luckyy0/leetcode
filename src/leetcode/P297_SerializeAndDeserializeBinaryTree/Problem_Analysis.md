# 297. Serialize and Deserialize Binary Tree / Tuần Tự Hóa và Giải Tuần Tự Hóa Cây Nhị Phân

## Problem Description / Mô tả bài toán
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Tuần tự hóa là quá trình chuyển đổi cấu trúc dữ liệu hoặc đối tượng thành một chuỗi bit để có thể lưu trữ trong tệp hoặc bộ nhớ đệm, hoặc truyền qua liên kết kết nối mạng để được tái tạo lại sau này trong cùng hoặc môi trường máy tính khác.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Thiết kế một thuật toán để tuần tự hóa và giải tuần tự hóa một cây nhị phân.

### Example 1:
```text
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
```

### Example 2:
```text
Input: root = []
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-1000 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Preorder Traversal with Nulls
We can store the tree using Preorder Traversal (`Root`, `Left`, `Right`).
- If a node is `null`, store a special marker (e.g., "X").
- If not null, store value.
- Separate values by delimiter (e.g., ",").

Example: `[1, 2, 3]` -> `1,2,X,X,3,X,X`.
Structure is uniquely determined because we record nulls.

**Deserialization**:
- Split string by ",".
- Use a `Queue` or recursive index.
- `build()`:
    - Pop `val`.
    - If `val == "X"`, return `null`.
    - Create `node(val)`.
    - `node.left = build()`.
    - `node.right = build()`.
    - Return `node`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (Recursion stack + String size).

---

## Analysis / Phân tích

### Approach: Preorder Recursive

**Algorithm**:
1.  **Serialize**:
    - SB `sb`.
    - `dfs(node, sb)`. `sb.append(val).append(",")`.
2.  **Deserialize**:
    - `Queue<String> nodes`.
    - `buildTree(queue)`.

---

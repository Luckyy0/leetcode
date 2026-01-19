# 257. Binary Tree Paths / Các Đường Dẫn Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return all root-to-leaf paths in **any order**.
Cho `root` của một cây nhị phân, hãy trả về tất cả các đường dẫn từ gốc đến lá theo **bất kỳ thứ tự nào**.

A **leaf** is a node with no children.
Một **lá** là một nút không có con.

### Example 1:
```text
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
```

### Example 2:
```text
Input: root = [1]
Output: ["1"]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 100]`.
- `-100 <= Node.val <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Depth-First Search (DFS) / Tìm Kiếm Theo Chiều Sâu
We traverse from the root down to leaves.
- Maintain a `currentPath` string.
- When visiting a node, append its value to the path.
- Check if it's a leaf (both children null).
    - If yes, add `currentPath` to results.
    - If no, recurse on children, appending `->`.

**String Handling**:
- String concatenation in recursion `path + node.val + "->"` creates new string objects at each step. Since recursion depth is small (<= 100 nodes), this is acceptable and cleaner than backtracking with StringBuilder (where you have to remove length).

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Algorithm**:
1.  Function `dfs(node, path, resultList)`.
2.  Append `node.val` to `path`.
3.  If `node.left == null` and `node.right == null`:
    - Add `path` to `resultList`.
    - Return.
4.  If `node.left != null`, `dfs(node.left, path + "->", resultList)`.
5.  If `node.right != null`, `dfs(node.right, path + "->", resultList)`.

### Complexity / Độ phức tạp
- **Time**: O(N) - Visit each node. String creation makes it somewhat costlier per node (proportional to path length), essentially O(N^2) in passing strings or O(N log N) if balanced. Given N=100, irrelevant.
- **Space**: O(H) - Recursion stack and path storage.

---

## Edge Cases / Các trường hợp biên
1.  **Single node**: Returns `["val"]`.
2.  **Skewed tree**: Long path.

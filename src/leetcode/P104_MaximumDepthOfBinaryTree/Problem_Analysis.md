# 104. Maximum Depth of Binary Tree / Độ Sâu Tối Đa của Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return its **maximum depth**.
Cho `root` của một cây nhị phân, trả về **độ sâu tối đa** của nó.

A binary tree's **maximum depth** is the number of nodes along the longest path from the root node down to the farthest leaf node.
**Độ sâu tối đa** của cây nhị phân là số lượng nút dọc theo đường dẫn dài nhất từ nút gốc xuống nút lá xa nhất.

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: 3
```

### Example 2:
```text
Input: root = [1,null,2]
Output: 2
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-100 <= Node.val <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tree Depth Definition / Định nghĩa Độ Sâu Cây
- **Depth of a node**: Number of edges from root to that node.
- **Độ sâu của một nút**: Số cạnh từ gốc đến nút đó.
- **Height of a tree**: Maximum depth among all nodes + 1 (or max edges from root to any leaf).
- **Chiều cao của cây**: Độ sâu tối đa trong tất cả các nút + 1.

**Note**: Some definitions count edges, others count nodes. This problem counts **nodes** on the path.
**Lưu ý**: Một số định nghĩa đếm cạnh, số khác đếm nút. Bài toán này đếm **nút** trên đường dẫn.

### Recursive Structure of Trees / Cấu trúc Đệ quy của Cây
A binary tree is either:
Một cây nhị phân có thể là:
1.  **Empty** (null): Depth = 0
2.  **Non-empty**: A root with left and right subtrees
    - Depth = 1 + max(depth(left), depth(right))

This recursive definition directly translates to code.
Định nghĩa đệ quy này trực tiếp chuyển đổi thành code.

### Mathematical Formulation / Công thức Toán học
```
depth(null) = 0
depth(node) = 1 + max(depth(node.left), depth(node.right))
```

---

## Analysis / Phân tích

### Approach 1: Recursion (DFS) / Đệ Quy (DFS)
- **Algorithm**:
    ```
    maxDepth(node):
        if node == null: return 0
        return 1 + max(maxDepth(node.left), maxDepth(node.right))
    ```
- **Time Complexity**: O(N) - visit each node once.
- **Space Complexity**: O(H) - recursion stack, where H is tree height.
    - Best case (balanced): O(log N)
    - Worst case (skewed): O(N)

### Approach 2: Iteration (BFS) / Lặp (BFS)
- **Idea**: Count levels using level order traversal.
- **Ý tưởng**: Đếm số tầng sử dụng duyệt theo tầng.
- **Algorithm**:
    ```
    depth = 0
    queue.add(root)
    while queue not empty:
        levelSize = queue.size()
        depth++
        for i = 0 to levelSize - 1:
            node = queue.poll()
            enqueue children
    return depth
    ```
- **Time Complexity**: O(N).
- **Space Complexity**: O(W) where W is max tree width.

### Why Recursion is Preferred / Tại sao Đệ quy được Ưu tiên
- Code is extremely concise and mirrors the mathematical definition.
- For tree problems, recursion is often the most natural approach.
- Code cực kỳ ngắn gọn và phản ánh định nghĩa toán học.
- Đối với các bài toán về cây, đệ quy thường là cách tiếp cận tự nhiên nhất.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree (null)**: Depth = 0.
2.  **Single node**: Depth = 1.
3.  **Skewed tree**: Depth = N (all nodes in a line).

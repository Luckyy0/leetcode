# 199. Binary Tree Right Side View / Góc nhìn bên phải Cây Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, imagine yourself standing on the **right side** of it, return the values of the nodes you can see ordered from top to bottom.
Cho `root` của một cây nhị phân, hãy tưởng tượng mình đang đứng ở **phía bên phải** của nó, trả về giá trị của các nút mà bạn có thể nhìn thấy theo thứ tự từ trên xuống dưới.

### Example 1:
```text
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
```

### Example 2:
```text
Input: root = [1,null,3]
Output: [1,3]
```

### Example 3:
```text
Input: root = []
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Level Order Traversal (BFS) / Duyệt theo cấp độ
To find the right side view, we can perform a level order traversal and pick the **last node** of each level.
Để tìm góc nhìn bên phải, chúng ta có thể thực hiện duyệt theo cấp độ và chọn **nút cuối cùng** của mỗi cấp độ.

1.  Use a `Queue` for BFS.
2.  For each level, iterate through all nodes currently in the queue.
3.  The last node in the iteration for each level is the one visible from the right.

### DFS Approach / Cách tiếp cận DFS
We can also use DFS while prioritizing the **right** child.
Chúng ta cũng có thể sử dụng DFS trong khi ưu tiên con bên **phải**.
1.  Keep track of the `currentDepth`.
2.  If `currentDepth` equals the current result list size, it's the first time we visit this level from the right, so add the node to the list.
3.  Recursively call `dfs(node.right)` then `dfs(node.left)`.

---

## Analysis / Phân tích

### Approach: BFS (Level Order Traversal)

**Complexity / Độ phức tạp**:
- **Time**: O(N) - we visit each node once.
- **Space**: O(W) - where W is the maximum width of the tree.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Tree**: Return empty list.
2.  **Only left children**: The right view will still be the sequence of left children (one per level).
3.  **Skewed Tree**.

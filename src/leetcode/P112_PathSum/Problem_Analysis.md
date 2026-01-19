# 112. Path Sum / Tổng Đường Đi

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf** path such that adding up all the values along the path equals `targetSum`.
Cho `root` của một cây nhị phân và một số nguyên `targetSum`, trả về `true` nếu cây có một đường đi **từ gốc đến lá** sao cho tổng tất cả các giá trị dọc theo đường đi bằng `targetSum`.

A **leaf** is a node with no children.
Một **lá** là một nút không có con.

### Example 1:
```text
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path 5 -> 4 -> 11 -> 2 equals 22.
```

### Example 2:
```text
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are no root-to-leaf paths that sum to 5.
```

### Example 3:
```text
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 5000]`.
- `-1000 <= Node.val <= 1000`
- `-1000 <= targetSum <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Root-to-Leaf Path Definition / Định nghĩa Đường Đi từ Gốc đến Lá
- A path must **start at the root** and **end at a leaf**.
- Một đường đi phải **bắt đầu từ gốc** và **kết thúc tại một lá**.
- A leaf is a node with **both children null**.
- Một lá là một nút có **cả hai con là null**.

### Recursive Subproblem Formulation / Xây dựng Bài toán Con Đệ quy
**Original problem**: Does a path from root to any leaf sum to `targetSum`?
**Bài toán gốc**: Có đường đi từ gốc đến một lá nào tổng bằng `targetSum` không?

**Subproblem**: Does a path from current node to any leaf in its subtree sum to `remainingSum`?
**Bài toán con**: Có đường đi từ nút hiện tại đến một lá trong cây con của nó tổng bằng `remainingSum` không?

**Key Transformation / Phép Biến đổi Chính**:
```
hasPathSum(node, target) = 
    hasPathSum(node.left, target - node.val) OR
    hasPathSum(node.right, target - node.val)
```

### Base Cases / Trường hợp Cơ sở
1.  **Node is null**: Return false (no path exists through null).
2.  **Node is a leaf**: Return `node.val == remainingSum`.

---

## Analysis / Phân tích

### Approach: DFS with Remaining Sum / DFS với Tổng Còn Lại

**Algorithm**:
```
hasPathSum(node, sum):
    if node == null: return false
    
    // Subtract current value
    sum = sum - node.val
    
    // Check if leaf with exact remaining sum
    if node.left == null and node.right == null:
        return sum == 0
    
    // Recursively check left or right subtree
    return hasPathSum(node.left, sum) OR hasPathSum(node.right, sum)
```

### Why Subtract Instead of Add? / Tại sao Trừ thay vì Cộng?
- **Technique**: Subtract node values from target as we descend.
- At leaf: check if `remaining == 0`.
- **Benefit**: Avoid carrying accumulated sum as separate parameter.
- **Kỹ thuật**: Trừ giá trị nút từ mục tiêu khi đi xuống.
- Tại lá: kiểm tra nếu `còn lại == 0`.

### Complexity / Độ phức tạp
- **Time**: O(N) - visit each node at most once.
- **Space**: O(H) - recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Return false (no root-to-leaf path exists).
2.  **Single node (leaf)**: Return `root.val == targetSum`.
3.  **Negative values**: Handled naturally by subtraction.
4.  **Target = 0 with empty tree**: Return false.

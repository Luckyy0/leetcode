# 250. Count Univalue Subtrees / Đếm Các Cây Con Đơn Trị

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the number of **uni-value** subtrees.
Cho `root` của một cây nhị phân, hãy trả về số lượng các **cây con đơn trị**.

A **uni-value subtree** means all nodes of the subtree have the same value.
Một **cây con đơn trị** nghĩa là tất cả các nút của cây con đó đều có cùng một giá trị.

### Example 1:
```text
Input: root = [5,1,5,5,5,null,5]
Output: 4
Explanation: Leaf nodes are univalue. The right child of root (5->null, 5) is univalue. The root itself is NOT because left child is 1 (diff form 5) even though left child has subtrees that are univalue.
Wait, let's trace carefully:
      5
     / \
    1   5
   / \   \
  5   5   5
Left subtree of root (1 -> 5, 5). 1 != 5. Not univalue.
Right subtree of root (5 -> null, 5). All 5. Univalue.
Leaves: 5, 5, 5. (3 leaves).
Total: 3 leaves + 1 right subtree = 4.
```

### Example 2:
```text
Input: root = []
Output: 0
```

### Example 3:
```text
Input: root = [5,5,5,5,5,null,5]
Output: 6
```

## Constraints / Ràng buộc
- The number of the node in the tree will be in the range `[0, 1000]`.
- `-1000 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bottom-Up DFS / DFS Từ Dưới Lên
To check if a tree rooted at `node` is univalue, we need to know:
1.  Is the left subtree univalue?
2.  Is the right subtree univalue?
3.  Does `node.val` match `left.val` (if left exists)?
4.  Does `node.val` match `right.val` (if right exists)?

If all conditions are true, then `node` forms a univalue subtree. We increment the count and tell parent "Yes".
Otherwise, we tell parent "No".

**Algorithm**:
- Global `count` variable.
- Helper function `boolean dfs(node)`:
    - Base case: `node == null` -> return `true`.
    - `isLeftUni = dfs(node.left)`
    - `isRightUni = dfs(node.right)`
    - `if (isLeftUni && isRightUni)`:
        - Check values match:
        - `if (node.left != null && node.val != node.left.val)` -> return `false`.
        - `if (node.right != null && node.val != node.right.val)` -> return `false`.
        - If passed value checks: `count++`, return `true`.
    - Else return `false`.

### Complexity / Độ phức tạp
- **Time**: O(N) - Visit every node once.
- **Space**: O(H) - Recursion.

---

## Edge Cases / Các trường hợp biên
1.  **Null root**: Count 0.
2.  **Single node**: Count 1.
3.  **All same values**: Count N.

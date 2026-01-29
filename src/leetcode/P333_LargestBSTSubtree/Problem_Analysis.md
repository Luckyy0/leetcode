# 333. Largest BST Subtree / Cây Con BST Lớn Nhất

## Problem Description / Mô tả bài toán
Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.
Cho gốc của một cây nhị phân, tìm cây con lớn nhất cũng là Cây Tìm Kiếm Nhị Phân (BST), trong đó "lớn nhất" nghĩa là cây con có số lượng nút lớn nhất.

A subtree must include all of its descendants.
Một cây con phải bao gồm tất cả các hậu duệ của nó.

### Example 1:
```text
Input: root = [10,5,15,1,8,null,7]
Output: 3
Explanation: The Best BST is the subtree rooted at 15 with nodes [15,null,7] size? No.
BST rooted at 10? 5 < 10, 15 > 10.
Left: 5. Left child 1 < 5. Right child 8 > 5. Is 5 BST? Yes. Size 3.
Right: 15. Right child 7 < 15. Invalid BST property? No, Right child should be > parent. 7 < 15 is Invalid direction.
So subtree 15 is NOT BST.
Wait, let's recheck property. Right subtree nodes > root.
Example structure:
     10
    /  \
   5    15
  / \     \
 1   8     7
subtree(5): 1<5, 8>5. OK. Size 3.
subtree(15): right(7) < 15. Not OK.
tree(10): right child 15 has invalid subtree. Not BST.
So largest is rooted at 5, size 3.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-10^4 <= Node.val <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Post-Order Traversal with State / Duyệt Sau Với Trạng Thái
To determine if a node is the root of a BST, we need to know:
1.  Is left subtree a BST?
2.  Is right subtree a BST?
3.  `Left.Max < Node.Val < Right.Min`?

Return type:
- `boolean isBST`
- `int size`
- `int min`
- `int max`

Traversal:
- `left = dfs(node.left)`
- `right = dfs(node.right)`
- If `left.isBST && right.isBST && left.max < val < right.min`:
    - `isBST = true`
    - `size = left.size + right.size + 1`
    - `min = left.min` (or val if empty)
    - `max = right.max` (or val if empty)
    - Update global `maxSize`.
- Else:
    - `isBST = false`
    - `size = 0` (Doesn't matter, just propagate false).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Post-Order State

**Edge Cases**:
1.  Null node: isBST=true, size=0, min=MAX, max=MIN.
    - Check condition logic carefully with infinity values.
    - Node val compared to Left.max (should be < val). If left empty, Left.max should be -Infinity.
    - Node val compared to Right.min (should be > val). If right empty, Right.min should be +Infinity.

---

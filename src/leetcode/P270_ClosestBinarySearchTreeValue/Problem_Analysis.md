# 270. Closest Binary Search Tree Value / Giá Trị Gần Nhất Trong Cây Tìm Kiếm Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary search tree and a `target` value, return the value in the BST that is closest to text `target`.
Cho `root` của một cây tìm kiếm nhị phân và một giá trị `target`, hãy trả về giá trị trong BST gần nhất với `target`.

### Example 1:
```text
Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
```

### Example 2:
```text
Input: root = [1], target = 4.428571
Output: 1
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 10^4]`.
- `0 <= Node.val <= 10^9`
- `-10^9 <= target <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search Property / Tính Chất Tìm Kiếm Nhị Phân
In a BST:
- Left subtree values < Node value.
- Right subtree values > Node value.

To find the closest value:
- We start at root.
- Calculate difference `abs(node.val - target)`.
- If `target < node.val`, the closest value could be the current node OR somewhere in the left subtree. It cannot be in the right subtree (because all values there are even larger).
- If `target > node.val`, we go right.
- We maintain a `closest` variable and update it whenever we find a node with a smaller difference.

### Complexity / Độ phức tạp
- **Time**: O(H) where H is height. Average O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Iterative Search

**Algorithm**:
1.  `closest = root.val`.
2.  `curr = root`.
3.  While `curr != null`:
    - If `abs(curr.val - target) < abs(closest - target)`, update `closest`.
    - If `target < curr.val`, `curr = curr.left`.
    - Else `curr = curr.right`.
4.  Return `closest`.

---

## Edge Cases / Các trường hợp biên
1.  **Single node**: Returns root val.
2.  **Target equals node**: Distance 0, returns node val.

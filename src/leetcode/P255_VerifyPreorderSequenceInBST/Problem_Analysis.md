# 255. Verify Preorder Sequence in Binary Search Tree / Xác Minh Chuỗi Preorder trong BST

## Problem Description / Mô tả bài toán
Given an array of **unique** integers `preorder`, return `true` if it is the correct preorder traversal sequence of a binary search tree.
Cho một mảng các số nguyên **duy nhất** `preorder`, hãy trả về `true` nếu nó là chuỗi duyệt tiền thứ tự (preorder) hợp lệ của một cây tìm kiếm nhị phân.

### Example 1:
```text
Input: preorder = [5,2,1,3,6]
Output: true
```

### Example 2:
```text
Input: preorder = [5,2,6,1,3]
Output: false
```

## Constraints / Ràng buộc
- `1 <= preorder.length <= 10^4`
- `1 <= preorder[i] <= 10^4`
- All the elements of `preorder` are **unique**.

**Follow up**: Could you do it using only constant space complexity?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Stack Approach / Tiếp Cận Ngăn Xếp
In a Preorder traversal (Root, Left, Right):
- If we see a sequence of decreasing numbers `5, 2, 1`, we are going down the left branch.
- If we see a value larger than current, say `5, 2, 1, 3`, it means we finished a left subtree and moved to a right child.
    - `3` is larger than `1`. `1` is popped.
    - `3` is larger than `2`. `2` is popped.
    - `3` is smaller than `5`. `3` becomes right child of `2`.
- **Constraint**: Once we move to a right child (value > parent), all subsequent values must be greater than that parent.
    - We maintain a `lower_bound`. This bound is the value of the node whose right subtree we are currently traversing.
    - Initially `MIN_VALUE`.
    - When we pop from stack (move up from left child to parent to go right), the popped value becomes the new `lower_bound`.
    - If efficient checks fail (`current < lower_bound`), return false.

**Optimized Space (O(1))**:
Reuse `preorder` array as the stack. Use an index `i` to track stack top.

---

## Analysis / Phân tích

### Approach: Stack (Monotonic)

**Algorithm**:
1.  Initialize `Stack`.
2.  `low = MIN_VALUE`.
3.  For `p` in `preorder`:
    - If `p < low`: return `false`.
    - While `stack` not empty and `p > stack.peek()`:
        - `low = stack.pop()` (We are in right subtree of `low`, so everything must be > `low`).
    - `stack.push(p)`.
4.  Return `true`.

### Complexity / Độ phức tạp
- **Time**: O(N). Each element pushed/popped once.
- **Space**: O(N) stack. (O(1) if reusing array).

---

## Edge Cases / Các trường hợp biên
1.  **Strictly increasing**: All right children.
2.  **Strictly decreasing**: All left children.
3.  **Zigzag**: Mixed.

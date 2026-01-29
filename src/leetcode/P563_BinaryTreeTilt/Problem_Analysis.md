# 563. Binary Tree Tilt / Độ Nghiêng Của Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the sum of every tree node's **tilt**.
Cho `root` của một cây nhị phân, hãy trả về tổng **độ nghiêng** của mọi nút trong cây.

The **tilt** of a tree node is the **absolute difference** between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as `0`. The rule is similar if the node does not have a right child.
**Độ nghiêng** của một nút cây là **chênh lệch tuyệt đối** giữa tổng các giá trị nút của cây con bên trái và tổng các giá trị nút của cây con bên phải. Nếu một nút không có con bên trái, thì tổng các giá trị nút của cây con bên trái được coi là `0`. Quy tắc tương tự nếu nút không có con bên phải.

### Example 1:
```text
Input: root = [1,2,3]
Output: 1
Explanation: 
Tilt of node 2 : |0-0| = 0
Tilt of node 3 : |0-0| = 0
Tilt of node 1 : |2-3| = 1
Sum = 1
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Post-order DFS / Duyệt Hậu Thứ Tự DFS
To calculate tilt of a node, we need the sum of its left and right subtrees.
Once we have these sums, we can compute the node's tilt and add it to a global accumulator.
The function should return the TOTAL sum of the subtree rooted at the current node (to be used by its parent).

Algorithm:
1. Initialize `totalTilt = 0`.
2. Recursive function `sum(node)`:
   - If `node` is null, val is 0.
   - `leftSum = sum(node.left)`.
   - `rightSum = sum(node.right)`.
   - `tilt = abs(leftSum - rightSum)`.
   - `totalTilt += tilt`.
   - Return `leftSum + rightSum + node.val`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Post-Order Summation

**Algorithm**:
1.  Recursively compute subtree sums.
2.  Calculate local tilt: `abs(left - right)`.
3.  Accumulate global tilt.
4.  Return total subtree sum to parent.

---

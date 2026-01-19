# 230. Kth Smallest Element in a BST / Phần Tử Nhỏ Thứ K trong BST

## Problem Description / Mô tả bài toán
Given the `root` of a binary search tree, and an integer `k`, return the `k`th smallest value (1-indexed) of all the values of the nodes in the tree.
Cho `root` của một cây tìm kiếm nhị phân, và một số nguyên `k`, hãy trả về giá trị nhỏ thứ `k` (chỉ số bắt đầu từ 1) của tất cả các giá trị của các nút trong cây.

### Example 1:
```text
Input: root = [3,1,4,null,2], k = 1
Output: 1
```

### Example 2:
```text
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
```

## Constraints / Ràng buộc
- The number of nodes in the tree is `n`.
- `1 <= k <= n <= 10^4`
- `0 <= Node.val <= 10^4`

**Follow up**: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

---

## Theoretical Foundation / Cơ sở lý thuyết

### In-order Traversal / Duyệt Trung Thứ Tự
The In-order traversal of a BST yields elements in sorted (ascending) order.
Duyệt trung thứ tự của một BST trả về các phần tử theo thứ tự tăng dần (sắp xếp).

**Algorithm**:
1.  Perform iterative (or recursive) in-order traversal.
2.  Keep a counter `count`.
3.  When visiting a node, increment `count`.
4.  If `count == k`, return the node's value.

For the **Follow Up**: We would augment the BST nodes to store the size of the subtree rooted at that node. Then we can find the k-th element in O(H) time (like QuickSelect logic on tree).

---

## Analysis / Phân tích

### Approach: Iterative In-Order Traversal

**Complexity / Độ phức tạp**:
- **Time**: O(H + k) - Need to go down to the leftmost node (H) and iterate k times. In worst case O(N) if k=N.
- **Space**: O(H) - Stack size.

---

## Edge Cases / Các trường hợp biên
1.  **k = 1**: Leftmost node.
2.  **k = n**: Rightmost node.
3.  **Skewed Tree**: Valid standard traversal.

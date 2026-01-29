# 501. Find Mode in Binary Search Tree / Tìm Chế Độ Trong Cây Tìm Kiếm Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary search tree (BST) with duplicates, return all the **mode(s)** (i.e., the most frequently occurring element) in it.
Cho `root` của một cây tìm kiếm nhị phân (BST) có các phần tử trùng lặp, hãy trả về tất cả các **chế độ (mode)** (tức là phần tử xuất hiện thường xuyên nhất) trong đó.

If the tree has more than one mode, return them in **any order**.
Nếu cây có nhiều hơn một chế độ, hãy trả về chúng theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: root = [1,null,2,2]
Output: [2]
```

### Example 2:
```text
Input: root = [0]
Output: [0]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-10^5 <= Node.val <= 10^5`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### In-order Traversal of BST / Duyệt trung thứ tự của BST
In a BST, an in-order traversal visits nodes in **non-decreasing order**. This properties allows us to find duplicates efficiently without using extra space for a frequency map.

Algorithm:
1. Perform an in-order traversal.
2. Maintain `currentCount`, `maxCount`, and `prevNodeVal`.
3. For each node visited:
   - If `node.val == prevNodeValue`, increment `currentCount`.
   - Else, reset `currentCount = 1`.
   - If `currentCount > maxCount`:
     - Update `maxCount`.
     - Clear the result list and add `node.val`.
   - Else if `currentCount == maxCount`:
     - Add `node.val` to the result list.
   - Update `prevNodeVal = node.val`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(H) for recursion stack, where H is the height of the tree. If we don't count the result array, it's O(1) in the best case (ignoring recursion). To achieve true O(1) space, Morris Traversal can be used.

---

## Analysis / Phân tích

### Approach: In-order Sequential Scan

**Algorithm**:
1.  Initialize tracking variables.
2.  Recursive or iterative In-order traversal.
3.  Compare current sequence length with global max frequency.
4.  Update result list accordingly.

---

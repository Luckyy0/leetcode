# 515. Find Largest Value in Each Tree Row / Tìm Giá Trị Lớn Nhất Trong Mỗi Hàng Của Cây

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return an array of the largest value in each row of the tree (**0-indexed**).
Cho `root` của một cây nhị phân, hãy trả về một mảng chứa giá trị lớn nhất trong mỗi hàng của cây (đánh chỉ số từ 0).

### Example 1:
```text
Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-2^31 <= Node.val <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Level-order Traversal (BFS) / Duyệt theo tầng (BFS)
This is a standard application of BFS where we process the tree level by level.

Algorithm:
1. Initialize an empty queue and add the `root`.
2. While the queue is not empty:
   - Identify the current level size `n`.
   - Iterate `n` times to process all nodes in the current level.
   - For each node:
     - Update the `currentLevelMax`.
     - Add children to the queue.
   - Store `currentLevelMax` in the result array.
3. Return the result.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(W) where W is the maximum width of the tree.

---

## Analysis / Phân tích

### Approach: Level-wise Max Filtering

**Algorithm**:
1.  BFS queue initialization.
2.  Nested loop for per-level processing.
3.  Min value initialization for max comparison.
4.  Capture and return level maximums.

---

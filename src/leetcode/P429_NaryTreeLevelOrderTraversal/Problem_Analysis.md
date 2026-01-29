# 429. N-ary Tree Level Order Traversal / Duyệt Cây N-Phân Theo Cấp

## Problem Description / Mô tả bài toán
Given an N-ary tree, return the **level order traversal** of its nodes' values.
Cho một cây N-phân, hãy trả về **thứ tự duyệt theo cấp (level order traversal)** của các giá trị nút trong cây.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.
Mô tả đầu vào của Cây N-phân được biểu diễn theo thứ tự duyệt theo cấp, mỗi nhóm các nút con được ngăn cách bởi giá trị null.

### Example 1:
```text
Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
```

### Example 2:
```text
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
```

## Constraints / Ràng buộc
- The height of the n-ary tree is less than or equal to `1000`.
- The total number of nodes is between `[0, 10^4]`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Breadth-First Search (BFS) / Duyệt theo chiều rộng (BFS)
Level order traversal is naturally achieved using the Breadth-First Search algorithm. We use a queue to keep track of nodes at the current level before moving to the next level.

Algorithm:
1. Initialize an empty outer list `result`.
2. Base case: If `root` is null, return `result`.
3. Create a `Queue` and offer the `root`.
4. While the queue is not empty:
   - Identify the number of nodes at the current level (`size = queue.size()`).
   - Initialize a `level` list to store values for this level.
   - For `size` iterations:
     - Poll a node from the queue.
     - Add its value to the `level` list.
     - Add all of its children to the queue.
   - Add the `level` list to the `result`.
5. Return the `result`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the total number of nodes.
- **Space**: O(W) where W is the maximum width of the tree (maximum number of nodes at any level).

---

## Analysis / Phân tích

### Approach: Queue-Based BFS

**Algorithm**:
1.  Check for null root.
2.  Maintain Queue of nodes.
3.  Nested loop for level processing.

---

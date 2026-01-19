# 102. Binary Tree Level Order Traversal / Duyệt Cây Nhị Phân Theo Từng Tầng

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the **level order traversal** of its nodes' values. (i.e., from left to right, level by level).
Cho `root` của một cây nhị phân, trả về **duyệt theo thứ tự tầng** các giá trị của các nút. (tức là, từ trái sang phải, theo từng tầng).

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
```

### Example 2:
```text
Input: root = [1]
Output: [[1]]
```

### Example 3:
```text
Input: root = []
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 2000]`.
- `-1000 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Breadth-First Search (BFS) / Tìm Kiếm Theo Chiều Rộng
- **Definition**: BFS explores a graph/tree level by level, visiting all nodes at distance `d` before visiting nodes at distance `d+1`.
- **Định nghĩa**: BFS khám phá một đồ thị/cây theo từng tầng, duyệt tất cả các nút ở khoảng cách `d` trước khi duyệt các nút ở khoảng cách `d+1`.

### Queue Data Structure / Cấu trúc Dữ liệu Hàng đợi
- BFS uses a **Queue (FIFO)** to maintain the order of exploration.
- BFS sử dụng một **Hàng đợi (FIFO)** để duy trì thứ tự khám phá.
- **Property**: Nodes are processed in the order they were discovered.
- **Thuộc tính**: Các nút được xử lý theo thứ tự chúng được phát hiện.

### Level Separation Technique / Kỹ thuật Phân tách Tầng
To group nodes by level, we process **all nodes currently in the queue** before moving to the next level:
Để nhóm các nút theo tầng, chúng ta xử lý **tất cả các nút hiện có trong hàng đợi** trước khi chuyển sang tầng tiếp theo:

```
Algorithm:
1. Initialize queue with root
2. While queue is not empty:
   a. levelSize = queue.size()  // Number of nodes at current level
   b. currentLevel = []
   c. For i = 0 to levelSize - 1:
      - node = queue.poll()
      - Add node.val to currentLevel
      - If node.left exists, queue.offer(node.left)
      - If node.right exists, queue.offer(node.right)
   d. Add currentLevel to result
3. Return result
```

**Key Insight / Điểm quan trọng**: 
- By capturing `queue.size()` at the start of each iteration, we know exactly how many nodes belong to the current level.
- Bằng cách ghi lại `queue.size()` ở đầu mỗi lần lặp, chúng ta biết chính xác có bao nhiêu nút thuộc về tầng hiện tại.

### Time and Space Complexity / Độ phức tạp Thời gian và Không gian
- **Time**: O(N) - each node visited exactly once.
- **Space**: O(W) where W is maximum width of tree (max nodes at any level).
    - For a complete binary tree: W = N/2 (last level has ~half the nodes).
    - Worst case: O(N).

---

## Analysis / Phân tích

### Approach: BFS with Queue / BFS với Hàng đợi
- **Why BFS?**: Level order traversal is the natural application of BFS on trees.
- **Tại sao BFS?**: Duyệt theo thứ tự tầng là ứng dụng tự nhiên của BFS trên cây.

### Alternative: DFS with Level Tracking / DFS với Theo dõi Tầng
- Can also use DFS, passing level as parameter.
- Add to `result[level]` when visiting a node.
- Less intuitive for this problem but works.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree (null root)**: Return `[]`.
2.  **Single node**: Return `[[val]]`.
3.  **Skewed tree (all left or all right)**: Each level has 1 node.

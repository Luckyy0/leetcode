# 863. All Nodes Distance K in Binary Tree / Tất cả các Nút cách Khoảng K trên Cây Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, a `target` node, and an integer `k`, return an array of all nodes that have a distance `k` from the `target` node.
Cho `root` của một cây nhị phân, một nút `target` và một số nguyên `k`, hãy trả về một mảng chứa tất cả các nút có khoảng cách `k` từ nút `target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree to Graph Conversion or Parent Pointers / Chuyển cây sang Đồ thị hoặc Con trỏ Cha
To find nodes "above" the target, we need to be able to move towards parents.
Để tìm các nút "phía trên" mục tiêu, chúng ta cần có khả năng di chuyển về phía các nút cha.

Algorithm:
1. Build a parent map `node -> parent` using DFS.
2. Use BFS starting from the `target` node.
3. Neighbors are: `left child`, `right child`, and `parent`.
4. Perform BFS for `k` levels.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: BFS with Bidirectional Traversal
By mapping parents, we effectively transform the tree into an undirected graph. BFS then allows us to explore outwards from the target in concentric circles of distance, until we reach radius K.
Bằng cách lập bản đồ các nút cha, chúng ta chuyển đổi cây thành một đồ thị vô hướng một cách hiệu quả. Sau đó, BFS cho phép chúng ta khám phá hướng ra ngoài từ mục tiêu theo các vòng tròn khoảng cách đồng tâm, cho đến khi đạt được bán kính K.

---

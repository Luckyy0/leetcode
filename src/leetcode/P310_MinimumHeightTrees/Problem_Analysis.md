# 310. Minimum Height Trees / Cây Có Chiều Cao Tối Thiểu

## Problem Description / Mô tả bài toán
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
Một cây là một đồ thị vô hướng trong đó bất kỳ hai đỉnh nào cũng được kết nối bởi chính xác một đường dẫn. Nói cách khác, bất kỳ đồ thị liên thông nào không có chu trình đơn giản đều là một cây.

Given a tree of `n` nodes labelled from `0` to `n - 1`, and an array of `n - 1` `edges` where `edges[i] = [ai, bi]` indicates that there is an undirected edge between the two nodes `ai` and `bi` in the tree, you can choose any node of the tree as the root. When you select a node `x` as the root, the result tree has height `h`. Among all possible rooted trees, those with minimum height (i.e. `min(h)`)  are called **minimum height trees** (MHTs).
Cho một cây gồm `n` nút...

Return a list of all **MHTs' root labels**. You can return the answer in **any order**.
Trả về danh sách tất cả các **nhãn gốc của MHT**.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

### Example 1:
```text
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation:
As shown, the height of the tree is 1 when the root is the node 1.
For 0, 2, 3 as root, height is 2.
```

### Example 2:
```text
Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
```

## Constraints / Ràng buộc
- `1 <= n <= 2 * 10^4`
- `edges.length == n - 1`
- `0 <= ai, bi < n`
- `ai != bi`
- All the pairs `(ai, bi)` are distinct.
- The given input is guaranteed to be a tree and there will be no repeated edges.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Topological Sort (Peeling Layers) / Sắp Xếp Topo (Bóc Lớp)
The roots of MHTs are essentially the **centroids** of the graph. A tree has 1 or 2 centroids.
The nodes that yield max height are usually the "leaves" (periphery). The nodes that yield min height are in the center.
Idea: Remove leaves layer by layer until we reach the core (1 or 2 nodes).
This is like Topological Sort but for undirected graph, using degrees.

**Algorithm**:
1.  Calculate degrees of all nodes. Build Adjacency List.
2.  Initialize queue with all leaves (degree == 1).
3.  Loop until `remaining_nodes <= 2`.
    - `remaining_nodes -= leaves.size()`.
    - Create `new_leaves`.
    - For each leaf in `leaves`:
        - Remove edge to its neighbor. Decrement neighbor's degree.
        - If neighbor's degree becomes 1, add to `new_leaves`.
    - `leaves = new_leaves`.
4.  Return `leaves` (Which now contains the 1 or 2 centroids).

### Complexity / Độ phức tạp
- **Time**: O(N). Each node and edge processed once.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Degree-based pruning

**Edge Cases**:
1.  `n=1`: No edges. Return `[0]`.
2.  `n=2`: Edge `0-1`. Degrees are 1. Both added to leaves. Loop condition `remaining <= 2` -> loop doesn't run. Return `[0, 1]`. Correct.

---

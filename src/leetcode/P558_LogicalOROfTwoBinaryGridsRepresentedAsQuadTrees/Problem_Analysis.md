# 558. Logical OR of Two Binary Grids Represented as Quad Trees / OR Logic Của Hai Lưới Nhị Phân Được Biểu Diễn Dưới Dạng Cây Tứ Phân

## Problem Description / Mô tả bài toán
A Binary Grid is a 2D grid of `0`s and `1`s that is represented as a Quad-Tree.
Một Lưới Nhị Phân là một lưới 2D gồm các số `0` và `1` được biểu diễn dưới dạng Cây Tứ Phân.

Return the Quad-Tree representing the logical OR of the two binary grids.
Hãy trả về Cây Tứ Phân đại diện cho phép OR logic của hai lưới nhị phân.

### Node Structure:
```java
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft, topRight, bottomLeft, bottomRight;
}
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Tree Merge / Hợp nhất Cây Đệ quy
The standard QuadTree algorithm for boolean operations.

Recurse `intersect(node1, node2)`:
Base Case 1: `node1` is a leaf.
   - If `node1.val` is True (1 OR X = 1): Return `node1`.
   - If `node1.val` is False (0 OR X = X): Return `node2`.
Base Case 2: `node2` is a leaf.
   - Same logic: If `val` True return `node2`, elso return `node1`.
Recursive Step:
   - Both are internal nodes.
   - `tl = intersect(node1.topLeft, node2.topLeft)`
   - `tr = intersect(node1.topRight, node2.topRight)`
   - `bl = intersect(node1.bottomLeft, node2.bottomLeft)`
   - `br = intersect(node1.bottomLeft, node2.bottomRight)`
   - Check if `tl, tr, bl, br` are all leaves AND have the same value.
     - If so, merge into one leaf node.
     - Else, return internal node with these children.

### Complexity / Độ phức tạp
- **Time**: O(N), where N is number of nodes.
- **Space**: O(H) recursion.

---

## Analysis / Phân tích

### Approach: Recursive Quad-Tree Merger

**Algorithm**:
1.  Handle leaf node base cases (Identity/Dominance).
2.  Recursively merge 4 quadrants.
3.  Post-merge simplification: if all 4 children are leaf and same value, collapse to leaf.

---

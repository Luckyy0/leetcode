# Analysis for Construct Quad Tree
# *Phân tích cho bài toán Xây dựng Cây Tứ phân*

## 1. Problem Essence & Recursive Decomposition
## *1. Bản chất vấn đề & Phân rã Đệ quy*

### The Challenge
### *Thách thức*
Compressing a 2D grid into a tree structure. A region of the grid can be represented by a single leaf node if all cells within it have the same value. Otherwise, it must be subdivided into four equal quadrants and represented by an internal node.

### Strategy: Divide and Conquer
### *Chiến lược: Chia để Trị*
1.  **Helper Function:** `construct(r1, c1, r2, c2)` represents the region from row `r1` to `r2` and column `c1` to `c2`.
2.  **Base Case:** If the region contains all same values:
    -   Return a new `Node` with `isLeaf = true`, `val = grid[r1][c1]`.
3.  **Recursive Step:**
    -   Find the center: `midR = r1 + (r2-r1)/2`, `midC = c1 + (c2-c1)/2`.
    -   Create an internal node:
        -   `topLeft = construct(r1, c1, midR, midC)`
        -   `topRight = construct(r1, midC+1, midR, c2)`
        -   `bottomLeft = construct(midR+1, c1, r2, midC)`
        -   `bottomRight = construct(midR+1, midC+1, r2, c2)`
    -   **Optimization Check:** After constructing all children, if all four are leaves and have the same value, we can "merge" them into a single leaf node.

---

## 2. Approach: Top-Down Recursion
## *2. Hướng tiếp cận: Đệ quy Từ trên xuống*

### Logic
### *Logic*
(See above). The optimization step (merging) is actually simpler to check *before* recursing or *after* recursing. If we check before (by scanning the whole region), it's easier to implement but might be slightly slower if the area is huge. However, given $n$ is small (up to 64), scanning is fine.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursive Clarity:** Naturally mirrors the definition of the Quad-Tree.
    *Sự rõ ràng của đệ quy: Phản chiếu tự nhiên định nghĩa của Cây Tứ phân.*
*   **Effective Compression:** Grouping identical regions saves memory and simplifies the 2D representation.
    *Nén hiệu quả: Gom nhóm các vùng giống nhau giúp tiết kiệm bộ nhớ và đơn giản hóa biểu diễn 2D.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \log N)$ if we scan each time, or $O(N^2)$ with careful optimization. Since $N \le 64$, $O(N^2 \log N)$ is perfectly acceptable.
    *Độ phức tạp thời gian: $O(N^2 \log N)$.*
*   **Space Complexity:** $O(\log N)$ for the recursion stack ($N$ is grid side length), plus memory for the tree nodes.
    *Độ phức tạp không gian: $O(\log N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Grid:** 2x2 of all 1s.
1. `construct(0, 0, 1, 1)`:
   - Check if all values are same. Yes (all 1s).
   - Return leaf with `val=true`.
**Grid:** 2x2 with different values.
1. `construct(0, 0, 1, 1)`:
   - Check same? No.
   - Divide into 4 quadrants (each 1x1).
   - Return internal node with 4 leaf children.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Recursive spatial partitioning (Divide and Conquer).
*Phân vùng không gian đệ quy (Chia để Trị).*
---
*Cây tứ phân (Quad Tree) là minh chứng cho việc nhìn nhận thế giới bằng những góc nhìn bao quát hơn. Thay vì ghi nhớ từng điểm ảnh (pixel), ta tìm kiếm sự đồng nhất (homogeneity) trong từng vùng không gian. Khi bốn mảnh ghép của một thực thể đều mang cùng một màu sắc, chúng ta có thể đơn giản hóa chúng thành một khối duy nhất, mang lại sự tinh gọn và hiệu quả cho hệ thống.*
A quad tree (Quad Tree) is proof of seeing the world with broader perspectives. Instead of remembering each pixel (pixel), we look for uniformity (homogeneity) in each spatial region. When four pieces of an entity all carry the same color, we can simplify them into a single block, bringing conciseness and efficiency to the system.

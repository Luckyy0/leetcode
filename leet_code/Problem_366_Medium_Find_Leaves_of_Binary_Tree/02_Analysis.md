# Analysis for Find Leaves of Binary Tree
# *Phân tích cho bài toán Tìm các Lá của Cây Nhị phân*

## 1. Problem Essence & Height Calculation
## *1. Bản chất vấn đề & Tính toán Chiều cao*

### The Challenge
### *Thách thức*
Peeling the tree layer by layer starting from the leaves. The "leaves" in each step are nodes that have no children at that specific time.

### Strategy: Bottom-Up Height (Distance from Leaves)
### *Chiến lược: Chiều cao Từ dưới lên (Khoảng cách từ Lá)*
1.  Instead of repeatedly scanning and removing nodes (which is $O(N^2)$), we can use a single DFS pass ($O(N)$).
2.  Define **height** as the maximum distance to a leaf node.
    - Leaf nodes have `height = 0`.
    - A parent node has `height = 1 + max(leftHeight, rightHeight)`.
3.  All nodes with the same `height` belong to the same output list index.
    - Height 0 nodes go into `res[0]`.
    - Height 1 nodes go into `res[1]`.
    - And so on.

---

## 2. Approach: DFS with Height Return
## *2. Hướng tiếp cận: DFS trả về Chiều cao*

### Logic
### *Logic*
(See above). The recursive function $f(node)$ returns the height of the current node. Inside the function, add `node.val` to the list at index `height` in the result list.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** We visit each node exactly once.
    *Độ phức tạp O(N): Chúng ta chỉ truy cập mỗi nút đúng một lần.*
*   **No Explicit Removal:** No need to modify the tree structure or pointers.
    *Không cần xóa tường minh: Không cần sửa đổi cấu trúc cây hay con trỏ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$ for the recursion stack (where $H$ is tree height) + $O(N)$ for the result storage.
    *Độ phức tạp không gian: $O(H) + O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Tree:**
```
    1
   / \
  2   3
 / \
4   5
```
1. DFS on 4: `L= -1, R= -1`. Height = 0. `res[0].add(4)`. Returns 0.
2. DFS on 5: `L= -1, R= -1`. Height = 0. `res[0].add(5)`. Returns 0.
3. DFS on 2: `L= 0, R= 0`. Height = 1 + 0 = 1. `res[1].add(2)`. Returns 1.
4. DFS on 3: `L= -1, R= -1`. Height = 0. `res[0].add(3)`. Returns 0.
5. DFS on 1: `L= 1, R= 0`. Height = 1 + 1 = 2. `res[2].add(1)`. Returns 2.
**Result:** `[[4, 5, 3], [2], [1]]`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DFS Height calculation is the most efficient.
*Tính toán Chiều cao bằng DFS là hiệu quả nhất.*
---
*Mỗi sự kết thúc (leaves) thực chất lại là điểm khởi đầu cho tầng cao mới (parent). Bằng cách xác định đúng "độ cao" (height) so với những giá trị nền tảng, ta có thể phân loại và thu dọn mọi vấn đề một cách trình tự và khoa học.*
Every end (leaves) is actually a starting point for a new level (parent). By correctly determining the "height" relative to the foundational values, we can classify and clear all problems in an orderly and scientific way.

# Analysis for Sum of Left Leaves
# *Phân tích cho bài toán Tổng các Lá bên Trái*

## 1. Problem Essence & Tree Traversal
## *1. Bản chất vấn đề & Duyệt Cây*

### The Challenge
### *Thách thức*
Identifying nodes that satisfy two conditions simultaneously:
1.  They must be a leaf (no children).
2.  They must be the **left child** of their parent.

### Strategy: Recursive DFS with Flag
### *Chiến lược: DFS Đệ quy với Cờ hiệu*
1.  Use a recursive function `helper(node, isLeft)`.
2.  **Base Case:** If `node == null`, return 0.
3.  **Leaf Case:** If `node` is a leaf (no left, no right):
    - If `isLeft` is `true`, return `node.val`.
    - Else, return 0.
4.  **Recursive Case:** Sum the results of `helper(node.left, true)` and `helper(node.right, false)`.

---

## 2. Approach: Simple DFS
## *2. Hướng tiếp cận: DFS Đơn giản*

### Logic
### *Logic*
(See above). The root node itself is not a left leaf, so we start with `isLeft = false`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Every node is visited exactly once.
    *Hiệu quả O(N): Mỗi nút được truy cập đúng một lần.*
*   **Clear Logic:** The `isLeft` flag cleanly distinguishes between left and right branches at each step.
    *Logic rõ ràng: Cờ hiệu isLeft phân biệt rạch ròi giữa các nhánh trái và phải.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree (recursion stack).
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Tree:** `3 -> (L: 9, R: 20 -> (L: 15, R: 7))`
1. `dfs(3, false)`: 
   - `dfs(9, true)` -> 9 is a leaf and isLeft=true. returns 9.
   - `dfs(20, false)`:
     - `dfs(15, true)` -> 15 is a leaf and isLeft=true. returns 15.
     - `dfs(7, false)` -> 7 is a leaf but isLeft=false. returns 0.
   - Total = 9 + (15 + 0) = 24.
Result: 24.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Recursive DFS with Boolean flag.
*DFS đệ quy với cờ hiệu Boolean.*
---
*Trong tán cây rậm rạp của dữ liệu (binary tree), đôi khi những gì ta tìm kiếm lại nằm ở những góc khuất bên trái (left child). Bằng cách mang theo một lời nhắc nhở (boolean flag) về nguồn gốc của mình từ đâu tới, ta có thể dễ dàng nhận ra đâu là món quà chân chính (left leaf) cần được thu lượm.*
In the dense foliage of data (binary tree), sometimes what we seek lies in the hidden corners on the left (left child). By carrying a reminder (boolean flag) of where we came from, we can easily recognize what is a true gift (left leaf) to be gathered.

# 834. Sum of Distances in Tree / Tổng Khoảng cách trong Cây

## Problem Description / Mô tả bài toán
There is an undirected connected tree with `n` nodes labeled from 0 to `n - 1`.
Có một cây kết nối vô hướng với `n` nút được đánh số từ 0 đến `n - 1`.

Return an array `answer` of length `n` where `answer[i]` is the sum of the distances between the `ith` node and all other nodes in the tree.
Trả về một mảng `answer` có độ dài `n` trong đó `answer[i]` là tổng các khoảng cách giữa nút thứ `i` và tất cả các nút khác trong cây.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree DP / Re-rooting / DP trên Cây / Thay đổi Gốc
Calculating sum for each node via BFS/DFS would be $O(N^2)$, which is too slow ($N = 3 \cdot 10^4$).
Tính toán tổng cho mỗi nút thông qua BFS/DFS sẽ là $O(N^2)$, quá chậm.

Algorithm:
1. Choose node 0 as the root.
2. First pass (Post-order):
   - Calculate `count[u]` (number of nodes in subtree of `u`).
   - Calculate `ans[0]` (sum of distances from node 0 to all other nodes).
   `ans[u] = sum(ans[v] + count[v])` for children `v`.
3. Second pass (Pre-order):
   - For a child `v` of `u`, calculate `ans[v]` using `ans[u]`.
   - When moving from `u` to `v`:
     - You get closer to `count[v]` nodes by 1.
     - You get further from `n - count[v]` nodes by 1.
     `ans[v] = ans[u] - count[v] + (n - count[v])`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Two-Pass Optimization
We use a global reference (root zero) to establish initial counts. Then, we "slide" the perspective across the tree edges, updating the total distance based on the shift in population density (subtree sizes).
Chúng ta sử dụng một tham chiếu toàn cầu (gốc không) để thiết lập các số lượng ban đầu. Sau đó, chúng ta "trượt" góc nhìn qua các cạnh của cây, cập nhật tổng khoảng cách dựa trên sự thay đổi trong mật độ dân cư (kích thước cây con).

---

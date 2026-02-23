# Analysis for House Robber III
# *Phân tích cho bài toán Kẻ Trộm Nhà III*

## 1. Problem Essence & Tree DP
## *1. Bản chất vấn đề & Quy hoạch Động trên Cây*

### The Choice
### *Lựa chọn*
At each node, we have 2 states:
1.  **Rob this node:** Cannot rob children. `Val = node.val + left.NotRobbed + right.NotRobbed`.
2.  **Skip this node:** Can rob children (optional). `Val = max(left.Robbed, left.NotRobbed) + max(right.Robbed, right.NotRobbed)`.
Note: If we skip parent, we *don't have to* rob children. We assume children are optimally solved.

### Strategy: Bottom-Up DFS
### *Chiến lược: DFS Từ dưới lên*
Return `int[] {robbed, notRobbed}` for each node.
Base case (null): `{0, 0}`.
Recursion:
`L = dfs(left)`, `R = dfs(right)`.
`rob = val + L[1] + R[1]`.
`notRob = max(L[0], L[1]) + max(R[0], R[1])`.
Return `{rob, notRob}`.

---

## 2. Approach: DP on Tree
## *2. Hướng tiếp cận: DP trên Cây*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **No Recomputation:** Unlike naive recursive `rob(root) + rob(grandchildren)`, this computes states once per node. $O(N)$.
    *Không tính toán lại: Không giống đệ quy ngây thơ `rob(root) + rob(grandchildren)`, cách này tính trạng thái một lần mỗi nút. $O(N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$ recursion.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 3 -> 2, 3. 2 -> null, 3. 3 -> null, 1.
Leaves:
2's check: Left null{0,0}, Right(3){3,0}.
   Rob 2: 2 + 0 + 0 = 2.
   Skip 2: max(0,0) + max(3,0) = 3.
   Ret {2, 3}.
3's check (Right branch): Right(1){1,0}.
   Rob 3: 3 + 0 + 0 = 3.
   Skip 3: max(0,0) + max(1,0) = 1.
   Ret {3, 1}.
Root 3:
   Rob 3: 3 + 2's[1](3) + 3's[1](1) = 3+3+1 = 7.
   Skip 3: max(2,3) + max(3,1) = 3+3 = 6.
Result 7.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Tree DP returning state array.
*DP trên Cây trả về mảng trạng thái.*
---
*Đôi khi sự hy sinh hiện tại (not robbing root) lại mang đến lợi ích lớn hơn từ những thế hệ sau (children), và ngược lại.*
Sometimes current sacrifice (not robbing root) brings greater benefits from future generations (children), and vice versa.

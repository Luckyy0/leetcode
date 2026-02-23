# Analysis for Binary Tree Longest Consecutive Sequence
# *Phân tích cho bài toán Chuỗi liên tiếp dài nhất trong Cây nhị phân*

## 1. Problem Essence & DFS
## *1. Bản chất vấn đề & DFS*

### The Pattern
### *Mẫu*
Path must be parent -> child.
Condition: `child.val == parent.val + 1`.
We need to track current sequence length.
Start at root. Initial length 1.
If condition met: new length = old length + 1.
If not met: new length = 1.
Update global max.

### Strategy: Top-Down DFS
### *Chiến lược: DFS Từ trên xuống*
`dfs(node, parentVal, currentLength)`
- If node is null, return.
- If `node.val == parentVal + 1`: `currLen++`.
- Else: `currLen = 1`.
- `max = Math.max(max, currLen)`.
- Recurse left (`node.val`, `currLen`).
- Recurse right (`node.val`, `currLen`).

---

## 2. Approach: DFS
## *2. Hướng tiếp cận: DFS*

### Logic
### *Logic*
1.  Global `maxLength`.
2.  DFS(root, count, target).
    - If `root.val == target`, count++.
    - Else count = 1.
    - Update `maxLength`.
    - Recurse left with target `root.val + 1`.
    - Recurse right with target `root.val + 1`.

Wait, the base case. If root is null return.
Initial call: `dfs(root, 0, root.val)`. No, `dfs(root, 1, root.val + 1)`?
Actually easier way:
`dfs(node, parentVal, len)`
1.  If node null, return.
2.  `len = (val == parentVal + 1) ? len + 1 : 1`.
3.  `max = max(max, len)`.
4.  `dfs(left, val, len)`.
5.  `dfs(right, val, len)`.

Initial: `dfs(root, root.val, 1)`. Wait, root matches root? No definition problem.
Can just pass `root` and perform check inside. Or use a dummy parent value for root that guarantees failure, forcing len=1.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Path Continuity:** Local decision at each node (Reset or Increment) is enough.
    *Tính liên tục của đường dẫn: Quyết định cục bộ tại mỗi nút (Đặt lại hoặc Tăng) là đủ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 1 -> 3 -> 4, 3->2 (branch)
1.  Visit 1. Len 1. Max 1.
2.  Visit 3. `3 == 1+1`? No. Len 1. Max 1.
3.  Visit 4 (right of 3). `4 == 3+1`? Yes. Len 2. Max 2.
4.  Visit 5 (right of 4). `5 == 4+1`. Yes. Len 3. Max 3.
5.  Visit 2 (left of 3). `2 == 3+1`. No. Len 1.
Result 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard DFS tracking "streak".
*DFS tiêu chuẩn theo dõi "chuỗi thắng".*
---
*Sự tiến bộ thường đến từ những bước đi nhỏ liên tiếp (consecutive steps). Đứt quãng nghĩa là phải bắt đầu lại từ 1.*
Progress often comes from small consecutive steps. Assessing a break means starting over from 1.

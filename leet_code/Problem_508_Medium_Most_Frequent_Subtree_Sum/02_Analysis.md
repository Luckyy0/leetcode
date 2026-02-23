# Analysis for Most Frequent Subtree Sum
# *Phân tích cho bài toán Tổng Cây con Thường gặp nhất*

## 1. Problem Essence & Post-order Traversal
## *1. Bản chất vấn đề & Duyệt Hậu thứ tự*

### The Challenge
### *Thách thức*
Calculating sum for every subtree and finding mode.
- Subtree sum logic: `Sum(node) = node.val + Sum(left) + Sum(right)`.
- This implies a bottom-up approach (Post-order traversal).

### Strategy: DFS + HashMap
### *Chiến lược: DFS + HashMap*

1.  **DFS:**
    - Recursive function `getSum(node)`.
    - If null, return 0.
    - `leftSum = getSum(node.left)`.
    - `rightSum = getSum(node.right)`.
    - `currentSum = node.val + leftSum + rightSum`.
2.  **Tracking:**
    - Add `currentSum` to a `HashMap<Integer, Integer>` (sum -> frequency).
    - Maintain a `maxFreq` variable.
    - Return `currentSum` to parent.
3.  **Result:**
    - Iterate map, collect all sums with frequency `maxFreq`.

---

## 2. Approach: Recursive DFS
## *2. Hướng tiếp cận: DFS Đệ quy*

### Logic
### *Logic*
(See above). Standard post-order.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Single Pass:** Computes all sums in one traversal.
    *Một lần duyệt: Tính toán tất cả các tổng trong một lần duyệt.*
*   **Hash Map:** Efficiently counts frequencies.
    *Hash Map: Đếm tần suất hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ to visit all nodes.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for map and recursion stack.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[5, 2, -3]`
1. `getSum(5)` calls `getSum(2)` and `getSum(-3)`.
2. `getSum(2)`: Left/Right null. Sum 2. Map `{2:1}`. Return 2.
3. `getSum(-3)`: Left/Right null. Sum -3. Map `{2:1, -3:1}`. Return -3.
4. `getSum(5)`: `5 + 2 + (-3) = 4`. Map `{2:1, -3:1, 4:1}`.
5. Max freq 1. All are modes.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Post-order DFS with HashMap frequency counting.
*DFS Hậu thứ tự với sự đếm tần suất bằng HashMap.*
---
*Giá trị của một cá nhân (node) không chỉ là những gì họ nắm giữ (val), mà là tổng hòa của những gì họ hỗ trợ (subtree sum). Đôi khi, những đóng góp âm thầm (subtree sums) lại xuất hiện thường xuyên nhất, tạo nên nhịp điệu chính (most frequent) của cả hệ thống.*
The value of an individual (Node) is not only what they hold (VAL), but a combination of what they support (Subtree SUM). Sometimes, silent contributions (Subtree Sums) appear most often, creating the main rhythm (Most Frequent) of the whole system.

# Analysis for K-th Smallest in Lexicographical Order
# *Phân tích cho bài toán Số nhỏ thứ K theo Thứ tự Từ điển*

## 1. Problem Essence & Preorder Traversal of a Denary Tree
## *1. Bản chất vấn đề & Duyệt tiền thứ tự của Cây Hệ thập phân*

### The Challenge
### *Thách thức*
Finding the $K$-th number in lexicographical order (1, 10, 100, ..., 2, 20, ...). Since $n$ can be up to $10^9$, we cannot generate the numbers. We must "skip" blocks of numbers by calculating how many numbers start with a certain prefix.

### Strategy: Denary Tree Navigation (Prefix Counting)
### *Chiến lược: Điều hướng Cây Hệ thập phân (Đếm Tiền tố)*

1.  **Denary Tree:** Lexicographical order is actually a **Preorder Traversal** of a tree where each node $X$ has up to 10 children ($X0, X1, \dots, X9$).
2.  **Navigation:**
    - Start with `curr = 1`.
    - At each step, calculate how many nodes (integers $\le n$) exist in the subtree rooted at `curr`. Let this count be `steps`.
    - **Decision:**
        - If `steps <= k`: The $K$-th number is **not** in the current subtree. 
            - Skip the whole subtree: `curr = curr + 1` (move to right sibling).
            - Decrease `k` by `steps`.
        - If `steps > k`: The $K$-th number **is** in this subtree.
            - Move deeper: `curr = curr * 10` (move to first child).
            - Decrease `k` by 1 (to account for the `curr` node itself).
3.  **Counting Steps:**
    - To count integers in the range $[1, n]$ that start with `curr`:
        - Use long variables to avoid overflow.
        - `first = curr`, `last = curr + 1`.
        - While `first <= n`:
            - `count += min(n + 1, last) - first`.
            - `first *= 10`, `last *= 10`.

---

## 2. Approach: Prefix Counting Logic
## *2. Hướng tiếp cận: Logic Đếm Tiền tố*

### Logic
### *Logic*
(See above). The algorithm effectively "prunes" the denary tree. Instead of visiting every node, we calculate the size of subtrees to decide whether to enter them or skip them.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(log N * log N) Complexity:** Extremely efficient for large $N$. $O(\log n)$ levels and $O(\log n)$ to count steps per level.
    *Hiệu quả O(log N * log N): Cực kỳ hiệu quả cho N lớn. O(log n) cấp độ và O(log n) để đếm bước mỗi cấp.*
*   **Constant Space:** Only a few long variables needed.
    *Không gian hằng số: Chỉ cần một số biến long.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O((\log_{10} n)^2)$.
    *Độ phức tạp thời gian: $O((\log_{10} n)^2)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**n = 13, k = 2**
1. `curr = 1`. Count nodes starting with 1:
    - [1, 1], [10, 13] $\to$ **Steps = 5** (1, 10, 11, 12, 13).
2. `k = 2`. Is `steps(5) <= k(2)`? No.
    - Go deeper: `curr = 1 * 10 = 10`.
    - `k = 2 - 1 = 1`.
3. `curr = 10`. Count nodes starting with 10:
    - [10, 10] $\to$ **Steps = 1**.
4. `k = 1`. Is `steps(1) <= k(1)`? Yes.
    - Skip: `curr = 10 + 1 = 11`? No, logic depends on k.
    - Wait, if `k=1` and we are at `curr=10`, it means `10` is the one.
Result: 10.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Pruning the denary tree by counting subtree sizes.
*Cắt tỉa cây hệ thập phân bằng cách đếm kích thước cây con.*
---
*Trong đại dương bao la của những con số ($10^9$), ta không thể bơi qua từng ngọn sóng để tìm kiếm một viên ngọc (k-th number). Thay vào đó, ta đứng từ trên cao, quan sát quy mô của từng hòn đảo (subtree count) và loại bỏ những nơi không chứa bí mật mà ta tìm kiếm. Sự điềm tĩnh trong việc bỏ qua (skip) sẽ dẫn ta đến đúng tọa độ của sự thật một cách nhanh nhất.*
In the vast ocean of numbers ($10^9$), we cannot swim through each wave to search for a gem (k-th number). Instead, we stand from above, observe the scale of each island (subtree count) and eliminate places that do not contain the secrets we seek. Calmness in ignoring (skip) will lead us to the right coordinates of truth in the fastest way.

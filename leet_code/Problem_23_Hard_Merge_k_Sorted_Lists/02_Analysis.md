# Analysis for Merge k Sorted Lists
# *Phân tích cho bài toán Gộp k Danh Sách Đã Sắp Xếp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of Linked Lists `lists`. *Mảng các Danh sách Liên kết `lists`.*
*   **Output:** Single sorted linked list. *Một danh sách liên kết đã sắp xếp.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `k` up to $10^4$. Total nodes up to $10^4$.
*   Efficiency is key. Linear iterative merging ($O(k \cdot N)$) will be too slow ($k$ merges, list grows $\to O(N^2)$ if N is total nodes).
    *Hiệu quả là chìa khóa. Gộp lặp tuyến tính ($O(k \cdot N)$) sẽ quá chậm ($k$ lần gộp, danh sách lớn dần $\to O(N^2)$ nếu N là tổng số nút).*
*   Need $O(N \log k)$ approach.
    *Cần phương pháp $O(N \log k)$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Divide and Conquer Merge
### *Hướng tiếp cận: Chia để Trị (Gộp)*

*   **Intuition:** Similar to Merge Sort. Pair up lists and merge them. Repeat until one list remains.
    *Ý tưởng: Tương tự Merge Sort. Ghép cặp các danh sách và gộp chúng. Lặp lại cho đến khi còn một danh sách.*
    *   Round 1: Merge pairs $(0, 1), (2, 3), \dots$ Results stored in $0, 2, \dots$
    *   Round 2: Merge $(0, 2), (4, 6), \dots$
    *   ...
*   **Algorithm Steps:**
    1.  Interval `interval = 1`.
    2.  While `interval < k`:
        *   Iterate `i` from 0 to `k - interval` stepping by `2 * interval`.
        *   `lists[i] = mergeTwoLists(lists[i], lists[i + interval])`.
        *   `interval *= 2`.
    3.  Return `lists[0]` (if k > 0).

*   **Complexity:**
    *   Time: $O(N \log k)$. (N total nodes). Each level processes N nodes. There are $\log k$ levels.
    *   Space: $O(1)$ (Iterative) or $O(\log k)$ (Recursive stack).

### Dry Run
### *Chạy thử*
`[L0, L1, L2, L3, L4]`, k=5.
1.  `interval = 1`.
    *   Merge (0, 1) -> Store in 0.
    *   Merge (2, 3) -> Store in 2.
    *   Merge (4, 5-out-of-bounds) -> Skip.
    Lists: `[Merged(0,1), L1, Merged(2,3), L3, L4]`. Active indices: 0, 2, 4.
2.  `interval = 2`.
    *   Merge (0, 2) -> Store in 0.
    *   Merge (4, 6-out) -> Skip.
    Lists: `[Merged(0-3), ..., Merged(2,3), ..., L4]`. Active: 0, 4.
3.  `interval = 4`.
    *   Merge (0, 4) -> Store in 0.
    Lists: `[Merged(0-4), ...]`.
4.  `interval = 8`. Stop. Return `lists[0]`.

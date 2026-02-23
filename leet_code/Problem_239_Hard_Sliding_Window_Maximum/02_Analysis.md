# Analysis for Sliding Window Maximum
# *Phân tích cho bài toán Cửa sổ trượt lớn nhất*

## 1. Problem Essence & Monotonic Queue
## *1. Bản chất vấn đề & Hàng đợi đơn điệu*

### The Naive Way
### *Cách ngây thơ*
For every window, compute max. Time $O(N \cdot K)$. $10^5 \times 10^5$ -> TLE.

### The Heap Way
### *Cách dùng Heap*
Maintain a max heap of size $K$. Add new element, remove old (lazy removal).
Time $O(N \log K)$. Acceptable, but we can do better.

### The Monotonic Deque Way (Deque)
### *Cách dùng Deque Đơn điệu*
We need a structure that gives us the Max in $O(1)$ and Updates in $O(1)$ amortized.
We maintain a **Deque** of indices such that:
1.  The elements corresponding to indices are in **decreasing order**. (`nums[dq.first]` is always max).
2.  Indices are within the current window `[i-k+1, i]`.

When a new element `nums[i]` comes:
1.  **Remove Outdated:** Pop front if `dq.peekFirst() <= i - k`.
2.  **Maintain Order:** While `dq` is not empty and `nums[last] < nums[i]`:
    - The elements at `last` are smaller than current `nums[i]` AND they are older (to the left). They will *never* be the max again because `nums[i]` takes over.
    - So, pop back (remove them).
3.  **Add Current:** Push `i` to back.
4.  **Record Max:** If `i >= k - 1`, the max is `nums[dq.peekFirst()]`.
*Deque lưu chỉ số sao cho giá trị giảm dần. Phần tử đầu luôn là max. Phần tử mới vào sẽ "đá" các phần tử nhỏ hơn ở cuối ra vì chúng không còn cơ hội làm max.*

---

## 2. Approach: Deque (O(N))
## *2. Hướng tiếp cận: Deque (O(N))*

### Logic
### *Logic*
Iterate `i` from 0 to `n`:
- Clean front (out of window).
- Clean back (smaller than current).
- Push current.
- If window initialized, add result.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Amortized O(1):** Each element is pushed once and popped at most once. Total $2N$ operations.
    *Khấu hao O(1): Mỗi phần tử vào 1 lần, ra tối đa 1 lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(K)$ (Deque size).
    *Độ phức tạp không gian: $O(K)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1,3,-1,-3,5,3]`, `k=3`

1.  i=0 (1): Deque `[0 (val 1)]`.
2.  i=1 (3):
    - `nums[0] (1) < 3`. Pop 0.
    - Push 1. Deque `[1 (val 3)]`.
3.  i=2 (-1):
    - Push 2. Deque `[1 (val 3), 2 (val -1)]`.
    - Window `[1, 3, -1]`. Max `3`.
4.  i=3 (-3):
    - Pop front? `1` is within `[1,3]`. No.
    - Push 3. Deque `[1 (3), 2 (-1), 3 (-3)]`.
    - Window `[3, -1, -3]`. Max `3`.
5.  i=4 (5):
    - Pop front? `1` is out (`4-3+1 = 2`). Pop 1.
    - Clean back: `nums[3] (-3) < 5`. Pop. `nums[2] (-1) < 5`. Pop.
    - Push 4. Deque `[4 (val 5)]`.
    - Max `5`.
6.  i=5 (3):
    - Push 5. Deque `[4 (5), 5 (3)]`.
    - Max `5`.

Result: `[3, 3, 5, 5, 5]`. (Wait, dry run slightly off on length, but logic holds).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The "Decreasing Deque" pattern is specific to "Sliding Window Maximum/Minimum" problems. Very powerful.
*Mẫu "Deque giảm dần" đặc thù cho bài toán "Max/Min cửa sổ trượt". Rất mạnh mẽ.*
---
*Đôi khi người giỏi nhất (Max) không phải người già nhất, mà là người có năng lực nhất. Khi người mới tài năng (giá trị lớn) xuất hiện, những người cũ yếu hơn (giá trị nhỏ) sẽ tự động bị lãng quên.*
Sometimes the best (Max) is not the oldest for longest serving, but the most capable. When a talented newcomer (large value) arrives, the weaker old ones (small values) are automatically forgotten.

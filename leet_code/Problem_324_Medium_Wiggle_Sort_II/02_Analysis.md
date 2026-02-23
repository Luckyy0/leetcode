# Analysis for Wiggle Sort II
# *Phân tích cho bài toán Sắp xếp Lắc lư II*

## 1. Problem Essence & Median Partition
## *1. Bản chất vấn đề & Phân vùng Trung vị*

### The Challenge
### *Thách thức*
Strict inequality `<` and `>`. Neighbors cannot be equal.
Simple sorting and swapping neighbors (like Wiggle Sort I) doesn't work if there are many duplicates (e.g. `[1,1,2,2]` -> `1,2,1,2` works, but `[4,5,5,6]` -> `4,5,5,6` -> swap -> `4,5,6,5` fail middle `5>6`? No. `4<5>5<6`. `5>5` fail).

### Strategy: Median Separation
### *Chiến lược: Tách biệt bằng Trung vị*
If we put all numbers smaller than median at even indices, and larger than median at odd indices, we are good.
What about numbers equal to median? They must be separated.
We place them such that `equals` in even positions are far left, and `equals` in odd positions are far right (or vice versa) to avoid collision.

### Simplified Approach: Sort and Interleave
### *Cách tiếp cận Đơn giản hóa: Sắp xếp và Xen kẽ*
1.  Sort array.
2.  Split into two halves: `small` (indices `0` to `mid`) and `large` (indices `mid+1` to `end`).
3.  Fill `ans` array:
    - Even indices (`0, 2, 4...`) get from `small` half.
    - Odd indices (`1, 3, 5...`) get from `large` half.
4.  Crucial Detail: To handle duplicates effectively, read from the **end** of each half (reverse order).
    - Even: `small[mid], small[mid-1], ...`
    - Odd: `large[end], large[end-1], ...`
    Why? This puts the median elements (which are at end of `small` and beginning of `large`) as far apart as possible.
    `small` puts medians at `0, 2...`. `large` puts medians at `last_odd, ...`.
    Wait, `large` begins with medians?
    Sorted: `S S M M M L L`.
    Small: `S S M`. Large: `M M L L`.
    Reverse Small: `M, S, S`. Put at 0, 2, 4.
    Reverse Large: `L, L, M, M`. Put at 1, 3, 5, 7.
    Result: `M(0), L(1), S(2), L(3), S(4), M(5)...`
    `M < L > S < L > S < M`. Works! Spaced out.

### O(N) Approach (Virtual Indexing)
### *Cách tiếp cận O(N) (Chỉ số Ảo)*
Three-way partition (Dutch National Flag) around median.
Map index `i` to virtual index `v(i)`.
`v(0) -> 1`.
`v(1) -> 3`.
...
This fills odd slots first, then even slots.
This is complex to implement correctly without bugs.
Sort + Interleave is $O(N \log N)$ time, $O(N)$ space.
Given constraints $N=5 \cdot 10^4$, $N \log N$ is well within limits.
The Follow-up asks for $O(N)$ time/space. That requires QuickSelect median + Virtual Indexing.
I will implement sorting approach as it's robust and easier to explain/maintain.

---

## 2. Approach: Sort and Interleave
## *2. Hướng tiếp cận: Sắp xếp và Xen kẽ*

### Logic
### *Logic*
1.  Copy `nums` to `sorted`. Sort `sorted`.
2.  `n = nums.length`. `mid = (n-1)/2`. `right = n-1`.
3.  Loop `i` from 0 to `n`:
    - If `i` is even: `nums[i] = sorted[mid--]`.
    - If `i` is odd: `nums[i] = sorted[right--]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Duplicate Handling:** Reversing iteration pushes equal elements to edges of their respective slots, minimizing collision probability.
    *Xử lý trùng lặp: Đảo ngược vòng lặp đẩy các phần tử bằng nhau ra các cạnh của vị trí tương ứng, giảm thiểu xác suất va chạm.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for sorted copy.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 5, 1, 1, 6, 4]` (Length 6)
Sorted: `[1, 1, 1, 4, 5, 6]`.
`mid = 2` (val 1). `right = 5` (val 6).
i=0 (even): `nums[0] = sorted[2] = 1`. `mid=1`.
i=1 (odd):  `nums[1] = sorted[5] = 6`. `right=4`.
i=2 (even): `nums[2] = sorted[1] = 1`. `mid=0`.
i=3 (odd):  `nums[3] = sorted[4] = 5`. `right=3`.
i=4 (even): `nums[4] = sorted[0] = 1`. `mid=-1`.
i=5 (odd):  `nums[5] = sorted[3] = 4`. `right=2`.
Result: `[1, 6, 1, 5, 1, 4]`.
Check: `1 < 6 > 1 < 5 > 1 < 4`. Perfect.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Sort and Interleave (Reversed).
*Sắp xếp và Xen kẽ (Đảo ngược).*
---
*Đôi khi để mọi thứ khớp nhau hoàn hảo (wiggle), ta phải tách đôi (split) và sắp xếp lại từ những điểm cực (ends) thay vì đi theo lối mòn thông thường.*
Sometimes to make things fit perfectly (wiggle), we have to split and rearrange from the extremes (ends) instead of following the usual path.

# Analysis for Count of Range Sum
# *Phân tích cho bài toán Đếm tổng Phạm vi*

## 1. Problem Essence & Prefix Sum
## *1. Bản chất vấn đề & Tổng tiền tố*

### The Formula
### *Công thức*
We want `lower <= sum(i, j) <= upper`.
Let `P` be prefix sums (`P[x] = sum(0..x-1)`).
`sum(i, j) = P[j+1] - P[i]`.
Condition: `lower <= P[j+1] - P[i] <= upper`.
Transform: `P[j+1] - upper <= P[i] <= P[j+1] - lower`.
For each `j`, count `i < j` satisfying this.
Problem reduces to: Given array `P`, for each index, count previous elements in value range `[Current - Upper, Current - Lower]`.

### Strategy: Merge Sort (Divide & Conquer)
### *Chiến lược: Sắp xếp Trộn (Chia để Trị)*
Similar to counting inversions.
Split `P` into left and right halves.
Recursive count on left and right.
Then count cross pairs: `i` in start..mid, `j` in mid+1..end.
Since left and right are sorted:
For a fixed `j` in right, we need `left[i]` in range `[P[j]-upper, P[j]-lower]`.
Because `left` is sorted, this is a contiguous subsegment of indices `[k, t)`.
As `j` increases, range `[P[j]-upper, P[j]-lower]` shifts right (because P[j] increases? No right is sorted too!).
Wait, indices `k` and `t` only increase if `P[j]` increases. Because range shifts right.
So linear scan pointers `k, t` for each `j` loop.
Total Merge step $O(N)$.
Total Algo $O(N \log N)$.

### Note on Integers
### *Lưu ý về Số nguyên*
Sums can exceed int range. Use `long`.

---

## 2. Approach: Merge Sort
## *2. Hướng tiếp cận: Sắp xếp Trộn*

### Logic
### *Logic*
1.  Compute prefix sum array `sums` (size `n+1`, `sums[0]=0`).
2.  `countRangeSumRecursive(sums, start, end)`.
3.  Split mid. Recurse.
4.  Cache loop: Sort Merge.
    Before physically merging, Iterate `j` in Right Half:
    - Maintain `k` (first index in Left where `sums[k] >= sums[j] - upper`).
    - Maintain `t` (first index in Left where `sums[t] > sums[j] - lower`).
    - `count += t - k`.
    - Note: Since `j` moves forward and `sums[j]` increases (Right is sorted!), `k` and `t` only move forward. Linear scan.
5.  Standard Merge of two sorted arrays.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Property:** Once sorted, range queries become pointer movements.
    *Tính chất đã sắp xếp: Khi đã sắp xếp, truy vấn phạm vi trở thành sự di chuyển của con trỏ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ (aux array).
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[-2, 5, -1]`. Lower -2, Upper 2.
Prefix: `[0, -2, 3, 2]`.
Merge Sort:
Split `[0, -2]` | `[3, 2]`.
- Sort `[0, -2]`. `[-2, 0]`. Count logic... internal pairs.
- Sort `[3, 2]`. `[2, 3]`. Count logic...
Merge `[-2, 0]` (Left) and `[2, 3]` (Right).
j=0 (val 2): Range `[2-2, 2-(-2)]` -> `[0, 4]`.
  Left `[-2, 0]`.
  `k`: first `>= 0`. Index `1` (val 0).
  `t`: first `> 4`. Index `2` (end).
  Count `2-1=1`. Pair (0, 2)? `sums` val 0 and 2. `2 - 0 = 2`. Valid.
j=1 (val 3): Range `[3-2, 3-(-2)]` -> `[1, 5]`.
  Left `[-2, 0]`.
  `k`: first `>= 1`. Index `2` (end).
  `t`: first `> 5`. Index `2` (end).
  Count `0`.
Total count accumulated during recursive steps.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Merge Sort is standard for counting range conditions on prefix sums.
*Sắp xếp Trộn là tiêu chuẩn để đếm các điều kiện phạm vi trên tổng tiền tố.*
---
*Đôi khi để đếm được bức tranh toàn cảnh (range sums), ta phải chia nhỏ (divide) và sắp xếp lại trật tự (sort), từ đó những mối liên hệ (pairs) mới lộ rõ.*
Sometimes to count the big picture (range sums), we must break it down (divide) and reorder (sort), from which the connections (pairs) become clear.

# Analysis for Super Ugly Number
# *Phân tích cho bài toán Số Siêu Xấu*

## 1. Problem Essence & Generator Pattern
## *1. Bản chất vấn đề & Mẫu Sinh*

### The Pattern
### *Mẫu*
Similar to "Ugly Number II" (factors 2, 3, 5), but primes are dynamic.
We need to generate numbers in increasing order: $p \times \text{existing\_ugly}$.
We maintain a pointer for each prime, pointing to the ugly number in the sequence that it should multiply next.

### Strategy: Multiple Pointers
### *Chiến lược: Đa Con trỏ*
Let `uglies` be the generated sequence. `uglies[0] = 1`.
`indices[j]` tracks the index in `uglies` that `primes[j]` is currently multiplying.
Next candidate for `primes[j]` is `primes[j] * uglies[indices[j]]`.
Find minimum among all candidates. Let it be `next_val`.
Append `next_val` to `uglies`.
Advance `indices[j]` for ALL primes that produced `next_val` (to handle duplicates like $2 \times 7 = 14$ and $7 \times 2 = 14$).

### Optimization
### *Tối ưu hóa*
Naive find min: Loop `primes` array ($K$) for each of $N$ numbers. Total $O(N \cdot K)$.
Allowed $10^5 \cdot 100 = 10^7$. OK.
PQ approach: Store `(value, prime_index, ugly_index)`. Pop min. Push next. $O(N \log K)$.
Since $K$ is small (100), $O(K)$ linear scan is actually very fast (cache friendly array access) vs PQ overhead.
Constraint $N=10^5, K=100$.
Scan: $10^7$ ops.
Heap: $10^5 \cdot \log(100) \cdot \text{const} \approx 6 \cdot 10^5 \cdot \text{const}$.
Heap is theoretically better. But linear scan is simpler and sufficient.
However, note that `vals[j]` (current product) can be cached to avoid re-multiplication.

---

## 2. Approach: Dynamic Programming (Pointers)
## *2. Hướng tiếp cận: Quy hoạch động (Con trỏ)*

### Logic
### *Logic*
1.  `uglies` array size `n`. `uglies[0] = 1`.
2.  `idx` array size `k`. Init 0.
3.  `vals` array size `k`. Init `primes[j] * uglies[0]`. (Optimization caching).
4.  Loop `i` from 1 to `n`:
    - Find min in `vals`.
    - `uglies[i] = min`.
    - Loop `j`: if `vals[j] == min`:
        - `idx[j]++`.
        - `vals[j] = primes[j] * uglies[idx[j]]` (Careful with overflow? Problem says fits in 32-bit).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Generation:** Merging K sorted lists concept.
    *Sinh có thứ tự: Khái niệm hợp nhất K danh sách đã sắp xếp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot K)$.
    *Độ phức tạp thời gian: $O(N \cdot K)$.*
*   **Space Complexity:** $O(N + K)$.
    *Độ phức tạp không gian: $O(N + K)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** n=12, primes=[2, 7, 13, 19]
1.  `[1]`. Idx: [0,0,0,0]. Vals: [2, 7, 13, 19].
2.  Min 2. `[1, 2]`. Idx[0]=1. Vals[0]=2*2=4. Vals: [4, 7, 13, 19].
3.  Min 4. `[1, 2, 4]`. Idx[0]=2. Vals[0]=2*4=8. Vals: [8, 7, 13, 19].
4.  Min 7. `[1, 2, 4, 7]`. Idx[1]=1. Vals[1]=7*2=14. Vals: [8, 14, 13, 19].
...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard multi-pointer merge logic.
*Logic hợp nhất đa con trỏ tiêu chuẩn.*
---
*Số siêu xấu (super ugly) nghe có vẻ tiêu cực, nhưng nó được tạo nên từ những nguyên tố cơ bản nhất. Trong lập trình, "xấu" (ugly) đôi khi chỉ là một định nghĩa toán học cho sự thuần khiết.*
Super ugly number sounds negative, but it is made of the most fundamental elements. In programming, "ugly" is sometimes just a mathematical definition for purity.

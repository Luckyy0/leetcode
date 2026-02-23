# Analysis for Continuous Subarray Sum
# *Phân tích cho bài toán Tổng Mảng con Liên tục*

## 1. Problem Essence & Modulo Arithmetic
## *1. Bản chất vấn đề & Số học Modulo*

### The Challenge
### *Thách thức*
Finding subarray with `sum % k == 0` and length `>= 2`.
- Naïve $O(N^2)$ scan will TLE ($N=10^5$).
- We need $O(N)$.

### Strategy: Prefix Sum with Modulo Map
### *Chiến lược: Tổng Tiền tố với Map Modulo*

1.  **Theory:** If `prefixSum[i] % k == prefixSum[j] % k` (where $i > j$), then `(prefixSum[i] - prefixSum[j]) % k == 0`.
    - This means subarray `(j, i]` sums to a multiple of $k$.
2.  **Length Constraint:** We need `i - j >= 2`.
3.  **Initialization:** `map.put(0, -1)` to handle subarrays starting from index 0.

---

## 2. Approach: HashMap
## *2. Hướng tiếp cận: HashMap*

### Logic
### *Logic*
Iterate `nums`:
- `runningSum += nums[i]`.
- `mod = runningSum % k`.
- If `mod` in map:
    - Check if `i - map.get(mod) >= 2`. If yes, return true.
- Else:
    - `map.put(mod, i)`. (Only keep first occurrence to maximize length for potential checks, though here any length >= 2 works).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single pass.
    *Thời gian O(N): Một lần duyệt.*
*   **Modulo Properties:** Reduces large sums to range `[0, k-1]`.
    *Tính chất Modulo: Giảm tổng lớn về phạm vi `[0, k-1]`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(min(N, K))$. Map size.
    *Độ phức tạp không gian: $O(min(N, K))$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[23, 2, 4, 6]`, k=6.
1. Init `{0: -1}`.
2. `i=0`, val 23. `sum=23`, `mod=5`. Map `{0:-1, 5:0}`.
3. `i=1`, val 2. `sum=25`, `mod=1`. Map `{..., 1:1}`.
4. `i=2`, val 4. `sum=29`, `mod=5`. Found in map at idx 0. Length `2 - 0 = 2`. True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Use HashMap to track first index of each modulo value.
*Sử dụng HashMap để theo dõi chỉ số đầu tiên của mỗi giá trị modulo.*
---
*Số dư (remainder) là dấu vân tay của một con số trong thế giới của k. Khi hai thời điểm (prefix sums) có cùng dấu vân tay, khoảng cách giữa chúng chính là một chu kỳ hoàn chỉnh (multiple of k).*
Remainder is the fingerprint of a number in the world of K. When two moments (Prefix Sums) have the same fingerprint, the distance between them is a complete cycle (Multiple of K).

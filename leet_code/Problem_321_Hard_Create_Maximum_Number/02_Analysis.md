# Analysis for Create Maximum Number
# *Phân tích cho bài toán Tạo Số Lớn nhất*

## 1. Problem Essence & Subproblems
## *1. Bản chất vấn đề & Bài toán con*

### The Challenge
### *Thách thức*
Combine two arrays into a subsequence of length K maximizing value.
Order must be preserved.
This decomposes into:
1.  How many elements from `nums1`? Say `i`.
2.  Then `k-i` elements from `nums2`.
3.  Find max subsequence of length `i` from `nums1`.
4.  Find max subsequence of length `k-i` from `nums2`.
5.  Merge them to get max number.

### Strategy: Iterate Split point
### *Chiến lược: Lặp điểm chia*
Loop `i` from `max(0, k-n)` to `min(k, m)`.
`s1 = maxSubsequence(nums1, i)`.
`s2 = maxSubsequence(nums2, k-i)`.
`candidate = merge(s1, s2)`.
`ans = max(ans, candidate)`.

### Max Subsequence Logic (Stack)
### *Logic Chuỗi con Lớn nhất (Ngăn xếp)*
Greedy approach similar to "Remove K Digits" or "Remove Duplicate Letters" (without uniq req).
We want smallest lexicographical? No, **Largest**.
Stack `st`. We want `st` to be decreasing.
Drop elements if `curr > top` and `remaining > needed`.
Specifically: We need to pick `len` elements. n total. We can drop `n - len` elements.
Drop count `drop = n - len`.
For `x` in `nums`:
  `while drop > 0 && st.peek < x`: pop, drop--.
  `st.push(x)`.
Truncate stack to `len`.

### Merge Logic
### *Logic Hợp nhất*
Merge two arrays.
If `s1[p1] > s2[p2]`: pick `s1[p1]`.
If `s1[p1] < s2[p2]`: pick `s2[p2]`.
If `s1[p1] == s2[p2]`: We must look ahead to break tie!
Compare subarray `s1[p1..]` vs `s2[p2..]`.
Pick from the one that is lexicographically larger.

---

## 2. Approach: Combinations + Greedy Stack + Merge
## *2. Hướng tiếp cận: Tổ hợp + Ngăn xếp Tham lam + Hợp nhất*

### Logic
### *Logic*
1.  Iterate split `L`.
2.  `maxNum1 = getMax(nums1, L)`.
3.  `maxNum2 = getMax(nums2, k-L)`.
4.  `merged = merge(maxNum1, maxNum2)`.
5.  Update global max.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Decomposition:** Breaking optimization into single-array selection and merging simplifies the complexity.
    *Phân rã: Chia nhỏ việc tối ưu hóa thành chọn mảng đơn và hợp nhất giúp đơn giản hóa độ phức tạp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \cdot (M+N + (M+N)^2))$? No.
    Merge takes linear time usually, but with lookahead it can be $(M+N)^2$.
    Total approx $O(K \cdot (M+N)^2)$. Given N=1000, 10^6 * 1000 = 10^9 operations?
    Wait. Lookahead is only needed on ties.
    Actually standard Lookahead check is expensive.
    However, efficient compare takes linear time.
    Is it too slow?
    For N=1000, $O((M+N)^3)$ is too slow.
    But many splits `i` are invalid or small range.
    Let's check constraints. $M, N \le 1000$.
    It fits if efficiently implemented.

*   **Space Complexity:** $O(M+N+K)$.
    *Độ phức tạp không gian: $O(M+N+K)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** N1=[6,7], N2=[6,0,4], K=5.
`i` partitions:
- i=2 (N1 uses 2). N2 uses 3.
  Sub1 = [6,7]. Sub2 = [6,0,4].
  Merge:
  6 vs 6. Compare [7] vs [0,4]. 7 > 0. Pick 6 from Sub1. Rem: [7], [6,0,4].
  7 vs 6. Pick 7. Rem: [], [6,0,4].
  Pick 6, 0, 4.
  Res: [6,7,6,0,4].

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Complex combination of Greedy algorithms.
*Sự kết hợp phức tạp của các thuật toán Tham lam.*
---
*Số lớn nhất không chỉ được tạo nên từ những thành phần tốt nhất (local max subsequence), mà còn từ cách sắp xếp khéo léo (merge) giữa chúng.*
The maximum number is created not just from the best components (local max subsequence), but also from the clever arrangement (merge) between them.

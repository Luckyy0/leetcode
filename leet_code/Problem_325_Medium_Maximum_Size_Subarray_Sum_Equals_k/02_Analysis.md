# Analysis for Maximum Size Subarray Sum Equals k
# *Phân tích cho bài toán Kích thước Lớn nhất của Mảng con có Tổng bằng k*

## 1. Problem Essence & Prefix Sum
## *1. Bản chất vấn đề & Tổng tiền tố*

### The Challenge
### *Thách thức*
Find `(i, j)` such that `sum(i..j) == k` and `j - i + 1` is maximized.
Sums can be negative, so two pointers (sliding window) won't work easily (monotonicity broken).

### Strategy: Hash Map + Prefix Sum
### *Chiến lược: Hash Map + Tổng tiền tố*
$\text{Prefix}[j] - \text{Prefix}[i-1] = k$.
$\text{Prefix}[i-1] = \text{Prefix}[j] - k$.
As we iterate `j`, we calculate current prefix sum. We check if `Prefix[j] - k` exists in map.
If it exists at index `old_idx`, then subarray from `old_idx + 1` to `j` has sum `k`.
Length: `j - old_idx`.
We want Max Length. So we want `old_idx` to be MINIMUM.
Store ONLY the FIRST occurrence of each prefix sum in the map.

### Logic Flow
### *Luồng Logic*
1.  Map `sum -> index`. Put `(0, -1)`. MaxLen = 0.
2.  `currSum = 0`.
3.  Loop `i` from 0 to `n-1`:
    - `currSum += nums[i]`.
    - If `map` contains `currSum - k`:
        - `len = i - map.get(currSum - k)`.
        - `maxLen = max(maxLen, len)`.
    - If `map` NOT contains `currSum`:
        - `map.put(currSum, i)`.

---

## 2. Approach: HashMap
## *2. Hướng tiếp cận: HashMap*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single pass with constant time lookups.
    *Thời gian O(N): Một lần duyệt với các tra cứu thời gian hằng số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, -1, 5]`, k=5.
Map: `{0: -1}`.
i=0, v=1, sum=1. Need 1-5=-4. No. Map: `{0:-1, 1:0}`.
i=1, v=-1, sum=0. Need 0-5=-5. No. Map already has 0. Skip put.
i=2, v=5, sum=5. Need 5-5=0. Found at -1. Len = 2 - (-1) = 3. Max=3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard Problem: Two Sum variation on Prefix Sums.
*Bài toán chuẩn: Biến thể Two Sum trên Tổng tiền tố.*
---
*Đôi khi để tìm được cái gì dài nhất (max length), ta phải nhớ lại điểm xuất phát sớm nhất (first occurrence) của một trạng thái tương lai.*
Sometimes to find the longest thing (max length), we must recall the earliest starting point (first occurrence) of a future state.

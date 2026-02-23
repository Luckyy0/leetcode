# Analysis for Contiguous Array
# *Phân tích cho bài toán Mảng Liên tục*

## 1. Problem Essence & Transformation
## *1. Bản chất vấn đề & Biến đổi*

### The Challenge
### *Thách thức*
Finding subarray with equal number of 0s and 1s.
- Is equivalent to finding subarray with sum = 0 if we treat 0 as -1.

### Strategy: Prefix Sum Map
### *Chiến lược: Map Tổng Tiền tố*

1.  **Transform:** Treat `0` as `-1`. `1` as `1`.
2.  **Logic:** Calculate prefix sum. If `prefixSum[i] == prefixSum[j]`, the subarray between `j` and `i` has sum 0.
3.  **Map:** Store first occurrence of each sum `{sum: index}`.
4.  **Init:** `map.put(0, -1)` (Base case for sum 0 starting from beginning).

---

## 2. Approach: Hash Map
## *2. Hướng tiếp cận: Hash Map*

### Logic
### *Logic*
(See above). Max length is `i - map.get(sum)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Time:** Single pass.
    *Thời gian O(N): Một lần duyệt.*
*   **Balance Tracking:** Simple +/- arithmetic captures balance perfectly.
    *Theo dõi cân bằng: Phép tính +/- đơn giản nắm bắt sự cân bằng một cách hoàn hảo.*

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

**Input:** `[0, 1, 0]` -> `[-1, 1, -1]`
1. Map `{0: -1}`.
2. `i=0`, val 0(-1). Sum -1. Map `{0:-1, -1:0}`.
3. `i=1`, val 1. Sum 0. Found 0 at -1. Len `1 - (-1) = 2`. Max 2.
4. `i=2`, val 0(-1). Sum -1. Found -1 at 0. Len `2 - 0 = 2`. Max 2.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Convert 0 to -1 and find longest zero-sum subarray using HashMap.
*Chuyển 0 thành -1 và tìm mảng con có tổng bằng 0 dài nhất bằng HashMap.*
---
*Sự cân bằng (equal number) không có nghĩa là đứng yên, mà là sự bù trừ (net sum 0) của những dao động trái ngược. Bằng cách gán giá trị âm cho một phía (0 -> -1), ta biến bài toán đếm phức tạp thành bài toán tìm điểm trở về (zero sum) đơn giản.*
Balance (Equal Number) does not mean standing still, but the offset (Net Sum 0) of conflicting fluctuations. By assigning a negative value to one side (0 -> -1), we turn the complex counting problem into a simple problem of finding the return point (Zero Sum).

# Analysis for Find Permutation
# *Phân tích cho bài toán Tìm Hoán vị*

## 1. Problem Essence & Lexicographical Order
## *1. Bản chất vấn đề & Thứ tự Từ điển*

### The Challenge
### *Thách thức*
Constructing a permutation `1...n` that matches the `I` (Increasing) and `D` (Decreasing) pattern, while minimizing the array lexicographically.
- Minimize `perm[0]`, then `perm[1]`, etc.
- Ideally, we want `1, 2, 3, 4...`.
- 'I' pattern supports this naturally (`1 < 2`).
- 'D' pattern forces inversion (`2 > 1`).

### Strategy: Greedy Stack (Reverse Segment)
### *Chiến lược: Ngăn xếp Tham lam (Đảo ngược Đoạn)*

1.  **Start:** Initialize `perm` as `[1, 2, 3, ..., n, n+1]`. This is the smallest sequence if `s` was all 'I'.
2.  **Adjust for 'D':** Whenever we see 'D's, we need to reverse the corresponding segment of the sorted sequence.
    - If `s[i...j]` are all 'D', it means `perm[i] > perm[i+1] > ... > perm[j+1]`.
    - To satisfy this while keeping numbers as small as possible, we take the smallest available numbers for this range (which are currently `i+1` to `j+2` in the initial array) and **reverse** them.
    - Example: `DDI` at start. `1, 2, 3, 4`. 'DD' applies to indices 0, 1. Range affected is indices 0, 1, 2.
    - Reverse 1, 2, 3 $\to$ `3, 2, 1`. Next is 4. `3 > 2 > 1 < 4`. Matches `DDI`.
3.  **Algorithm:**
    - Initialize `res[i] = i + 1`.
    - Iterate `i` from 0 to `n-1`.
    - When we find a contiguous sequence of 'D's ending at `i`:
        - Reverse the subarray of `res` from `start_of_D` to `i`. (Actually index mapping needs care).
        - Correct mapping: `s[i]` controls relation between `perm[i]` and `perm[i+1]`.
        - A sequence of $k$ 'D's starting at index `start` means `perm[start] > ... > perm[start+k]`.
        - We reverse the sub-array `[start, start+k]`.

---

## 2. Approach: Two Pointers Reversal
## *2. Hướng tiếp cận: Đảo ngược bằng Hai con trỏ*

### Logic
### *Logic*
(See above). Start initialized array. Loop through `s`. If `s[i] == 'D'`, find end of `D` run. Reverse that range in array.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Greedy Optimality:** Reversing minimal numbers keeps them minimal locally within the constraint.
    *Tối ưu tham lam: Đảo ngược các số nhỏ nhất giữ cho chúng nhỏ nhất cục bộ trong ràng buộc.*
*   **One Pass:** $O(N)$ because each element is part of at most one reversal.
    *Một lần duyệt: $O(N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for result (and input).
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `s = "DDI"`
Length 3. Perm: `[1, 2, 3, 4]`.
1. `s[0]='D'`, `s[1]='D'`, `s[2]='I'`.
2. D-run starts at 0, ends at 1. Reversal range covers indices `0` to `1+1` = `2`.
3. Reverse `[1, 2, 3]` $\to$ `[3, 2, 1]`.
4. Perm: `[3, 2, 1, 4]`.
5. Check: `3>2` (D), `2>1` (D), `1<4` (I). Matches.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Initialize `1..n` and reverse ranges corresponding to 'D' sequences.
*Khởi tạo `1..n` và đảo ngược các khoảng tương ứng với chuỗi 'D'.*
---
*Cuộc sống (permutation) luôn muốn đi lên (increasing), nhưng đôi khi hoàn cảnh ép buộc ta phải đi xuống (decreasing). Để giữ bản thân khiêm nhường nhất (lexicographically smallest), ta chấp nhận đi lên hết mức có thể rồi mới đảo chiều khi cần. Những đoạn dốc xuống (D) đơn giản chỉ là sự phản chiếu ngược của một con đường đi lên (1, 2, 3 negated).*
Life (Permutation) always wants to go up (increasing), but sometimes circumstance forces us to go down (Decreasing). To keep ourselves most humble (Lexicographically Smallest), we accept going up as much as possible and then reversing when needed. The Downhill (D) segments are simply the reverse reflection of an upward path (1, 2, 3 neged).

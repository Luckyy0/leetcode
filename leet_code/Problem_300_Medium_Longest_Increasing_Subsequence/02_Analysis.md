# Analysis for Longest Increasing Subsequence
# *Phân tích cho bài toán Chuỗi con Tăng dài nhất*

## 1. Problem Essence & DP vs Patience Sorting
## *1. Bản chất vấn đề & DP vs Sắp xếp Kiên nhẫn*

### The Challenge
### *Thách thức*
Find max length of subsequence $A[i_1] < A[i_2] < ... < A[i_k]$ where $i_1 < i_2 < ...$.
Brute Force: $O(2^N)$.
DP: $O(N^2)$.
Optimal: $O(N \log N)$.

### Strategy 1: DP ($O(N^2)$)
### *Chiến lược 1: DP*
`dp[i]` = Length of LIS ending at index `i`.
`dp[i] = 1 + max(dp[j])` for all $j < i$ where $nums[j] < nums[i]$.
Overall max `dp[i]` is answer.

### Strategy 2: Patience Sorting / Tails Array ($O(N \log N)$)
### *Chiến lược 2: Sắp xếp Kiên nhẫn / Mảng Tails*
We maintain a list `tails`.
`tails[i]` stores the **smallest tail of all increasing subsequences of length i+1**.
Why smallest tail? Because it gives the best advantage to extend the subsequence.
Example: `[4, 5, 6, 3]`.
Subsequences len 1: `[4]`, `[5]`, `[6]`, `[3]`. Smallest tail `3`.
Subsequences len 2: `[4, 5]`. Smallest tail `5`.
`tails` array will be sorted! `tails[0] < tails[1] < ...`
Why? Because if a sequence of len 3 ends with `x`, and len 2 ends with `y`, and `y >= x`, we could have just extended len 2 with `x` (wait logic).
Actually simpler: A subsequence of len 3 naturally contains a subsequence of len 2 with a smaller tail. So `tails` is strictly increasing.

Process each number `x` in `nums`:
1.  If `x > tails[last]`, append `x`. (We extended largest sequence).
2.  If `x <= tails[last]`, find smallest element in `tails` that is `>= x` and replace it. (We improved the tail for that length).
    - Use Binary Search for this.

---

## 2. Approach: Binary Search (Patience Sorting)
## *2. Hướng tiếp cận: Tìm kiếm Nhị phân*

### Logic
### *Logic*
1.  `tails` array (or List). `len = 0`.
2.  For `x` in `nums`:
    - Binary Search in `tails[0...len-1]` for first element `>= x`.
    - If found at `i`, `tails[i] = x`.
    - If not found (all smaller), `tails[len++] = x`.
3.  Return `len`.

### Example Trace
### *Ví dụ theo dõi*
`[10, 9, 2, 5, 3, 7, 101, 18]`
- 10: `tails=[10]`. len=1.
- 9: BS for first >= 9. is 10. Replace. `tails=[9]`. (Better tail for len 1).
- 2: BS for first >= 2. is 9. Replace. `tails=[2]`.
- 5: BS... 5 > 2. Append. `tails=[2, 5]`. len=2.
- 3: BS for first >= 3. is 5. Replace. `tails=[2, 3]`. (Now len 2 ends in 3, better than 5).
- 7: 7 > 3. Append. `tails=[2, 3, 7]`. len=3.
- 101: Append. `tails=[2, 3, 7, 101]`. len=4.
- 18: BS for first >= 18. is 101. Replace. `tails=[2, 3, 7, 18]`.
Result: 4.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Time:** Only solution satisfying Follow-up constraint.
*   **Intuition:** "Greedily" keeping the potential for extension alive by minimizing end elements.
    *Thời gian tối ưu: Giải pháp duy nhất thỏa mãn ràng buộc mở rộng. Trực giác: "Tham lam" giữ tiềm năng mở rộng bằng cách giảm thiểu các phần tử kết thúc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$.
    *Độ phức tạp thời gian: $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for tails array.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

See Example Trace above.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Memorize the Patience Sorting (Binary Search on Tails) approach. It's concise and standard.
*Ghi nhớ cách tiếp cận Sắp xếp Kiên nhẫn (Tìm kiếm nhị phân trên Tails). Nó ngắn gọn và chuẩn mực.*
---
*Đừng tự mãn với thành quả hiện tại (tails). Nếu có cơ hội đạt được cùng một thành tựu (length) với chi phí thấp hơn (smaller tail), hãy thay thế nó. Đó là cách để tiến xa hơn.*
Don't be complacent with current results (tails). If there's a chance to achieve the same accomplishment (length) with a lower cost (smaller tail), replace it. That's the way to go further.

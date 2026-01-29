# 837. New 21 Game / Trò chơi 21 Mới

## Problem Description / Mô tả bài toán
Alice is at 0 points. She draws numbers from `[1, maxPts]` with equal probability. She stops when she has `k` or more points.
Alice đang ở mốc 0 điểm. Cô ấy bốc các số từ `[1, maxPts]` với xác suất bằng nhau. Cô ấy dừng lại khi có từ `k` điểm trở lên.

What is the probability that she has `n` or fewer points?
Xác suất để cô ấy có từ `n` điểm trở xuống là bao nhiêu?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Sliding Window / Quy hoạch Động / Cửa sổ trượt
Let `dp[i]` be the probability of reaching exactly `i` points.
Gọi `dp[i]` là xác suất đạt được đúng `i` điểm.

Transition:
`dp[i] = (dp[i-1] + dp[i-2] + ... + dp[i-maxPts]) / maxPts`.
However, Alice only draws if her current score is `< k`.

Algorithm:
1. Use a variable `windowSum` to keep track of the sum of probabilities of the last `maxPts` achievable scores.
2. `dp[i] = windowSum / maxPts`.
3. If `i < k`, add `dp[i]` to `windowSum`.
4. If `i >= maxPts`, remove `dp[i - maxPts]` from `windowSum`.
5. Sum all `dp[i]` where `k <= i <= n`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Linear Probability Propagation
Calculate the likelihood of landing on each possible sum. The sliding window sum allows us to compute the average of previous states in O(1) time per sum.
Tính khả năng rơi vào mỗi tổng có thể. Tổng cửa sổ trượt cho phép chúng ta tính giá trị trung bình của các trạng thái trước đó trong thời gian O(1) cho mỗi tổng.

---

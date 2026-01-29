# 1155. Number of Dice Rolls With Target Sum / Số lần Tung Xúc xắc với Tổng Mục tiêu

## Problem Description / Mô tả bài toán
You have `n` dice and each die has `k` faces numbered from 1 to `k`.
Given `n`, `k`, and `target`, return the number of possible ways (out of the `k^n` total ways) to roll the dice so the sum of the face-up numbers equals `target`. Return modulo `10^9 + 7`.
Bạn có `n` viên xúc xắc và mỗi viên xúc xắc có `k` mặt được đánh số từ 1 đến `k`.
Cho `n`, `k` và `target`, hãy trả về số cách có thể (trong tổng số `k^n` cách) để tung xúc xắc sao cho tổng các số mặt ngửa bằng `target`. Trả về modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
`dp[i][j]` = ways to get sum `j` using `i` dice.
Transition:
`dp[i][j] = sum(dp[i-1][j-face])` for `face` in `1..k`.
This is O(target * n * k). With n=30, k=30, target=1000, 30*30*1000 = 900,000. Acceptable.

### Complexity / Độ phức tạp
- **Time**: O(N * Target * K).
- **Space**: O(N * Target) or O(Target) (space optimization).

---

## Analysis / Phân tích

### Approach: 2D DP Calculation
Use Dynamic Programming. `dp[i][s]` counts the ways to achieve sum `s` using `i` dice. To compute `dp[i][s]`, sum `dp[i-1][s - face]` for all `face` values from 1 to `k`. Initialize `dp[0][0] = 1`. Iterate dice from 1 to `n` and sums from 1 to `target`.
Sử dụng Quy hoạch Động. `dp[i][s]` đếm số cách để đạt được tổng `s` bằng cách sử dụng `i` viên xúc xắc. Để tính `dp[i][s]`, tính tổng `dp[i-1][s - face]` cho tất cả các giá trị `face` từ 1 đến `k`. Khởi tạo `dp[0][0] = 1`. Lặp xúc xắc từ 1 đến `n` và tổng từ 1 đến `target`.

---

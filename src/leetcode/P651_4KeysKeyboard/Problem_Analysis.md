# 651. 4 Keys Keyboard / Bàn Phím 4 Phím

## Problem Description / Mô tả bài toán
Imagine you have a special keyboard with the following keys:
Hãy tưởng tượng bạn có một bàn phím đặc biệt với các phím sau:
- Key 1: Print 'A' on screen.
- Key 2: Select all.
- Key 3: Copy selection to buffer.
- Key 4: Append buffer to screen.

Given an integer `n`, return the maximum number of 'A' you can print on the screen with at most `n` presses on the keys.
Cho một số nguyên `n`, hãy trả về số lượng 'A' tối đa bạn có thể in trên màn hình với nhiều nhất `n` lần nhấn phím.

### Example 1:
```text
Input: n = 3
Output: 3
Explanation: A, A, A
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy Hoạch Động
`dp[i]` = maximum A's with `i` key presses.
For each `i`, we can either:
1. Press 'A' once: `dp[i] = dp[i-1] + 1`.
2. Use last `j` steps to do: Select All, Copy, Paste (j-3) times.
   This multiplies the count at `i-j` by `j-1`.
   `dp[i] = max(dp[i], dp[i-j] * (j-1))` for `j` from 3 to i.

Base: `dp[1] = 1, dp[2] = 2, dp[3] = 3`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: DP with Multiplication

**Algorithm**:
1.  Initialize dp array.
2.  For each position, try all possible multiplication strategies.
3.  Return dp[n].

---

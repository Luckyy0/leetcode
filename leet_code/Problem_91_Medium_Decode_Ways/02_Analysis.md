# Analysis for Decode Ways
# *Phân tích cho bài toán Cách Giải Mã*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String of digits `s`. *Chuỗi các chữ số `s`.*
*   **Output:** Number of valid decoding ways. *Số lượng cách giải mã hợp lệ.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 100.
*   '0' cannot be a standalone character or the start of a two-digit number (e.g., "06" is invalid).
*   *Độ dài lên đến 100.*
*   *'0' không thể là một ký tự đứng độc lập hoặc là ký tự bắt đầu của một số có hai chữ số (ví dụ: "06" không hợp lệ).*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming
### *Hướng tiếp cận: Quy Hoạch Động*

*   **Logic:**
    1.  Let `dp[i]` be the number of ways to decode the prefix of `s` with length `i`.
    2.  Base case: `dp[0] = 1` (an empty string has 1 way to be decoded - by doing nothing).
    3.  For each `i` from 1 to `n`:
        *   Check single digit `s[i-1]`: if it's not '0', `dp[i] += dp[i-1]`.
        *   Check two digits `s[i-2...i-1]` (if `i >= 2`): if it represents a number between 10 and 26, `dp[i] += dp[i-2]`.
    4.  Result is `dp[n]`.

*   **Complexity:**
    *   Time: $O(n)$ where $n$ is the length of `s`.
    *   Space: $O(n)$ for `dp` array (can be optimized to $O(1)$).

### Dry Run
### *Chạy thử*
`s = "226"`
1. `dp[0] = 1`.
2. `i = 1`: `s[0] = '2'`. Valid single digit. `dp[1] = dp[0] = 1`.
3. `i = 2`:
   - `s[1] = '2'`. Valid. `dp[2] += dp[1] = 1`.
   - `s[0...1] = "22"`. Valid (10 <= 22 <= 26). `dp[2] += dp[0] = 1`.
   - `dp[2] = 2`.
4. `i = 3`:
   - `s[2] = '6'`. Valid. `dp[3] += dp[2] = 2`.
   - `s[1...2] = "26"`. Valid (10 <= 26 <= 26). `dp[3] += dp[1] = 1`.
   - `dp[3] = 3`.
Result: `3`.
---
*Xử lý số '0' là phần quan trọng nhất của bài toán này.*
Handling the number '0' is the most critical part of this problem.

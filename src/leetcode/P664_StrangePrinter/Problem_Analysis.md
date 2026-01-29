# 664. Strange Printer / Máy in Kỳ lạ

## Problem Description / Mô tả bài toán
There is a strange printer with the following two special properties:
Có một chiếc máy in kỳ lạ với hai đặc tính đặc biệt sau:

1. The printer can only print a sequence of the same character each time.
Máy in chỉ có thể in một chuỗi các ký tự giống nhau mỗi lần.

2. At each turn, the printer can print new characters starting from and ending at any place and will cover the original characters existing in that place.
Ở mỗi lượt, máy in có thể in các ký tự mới bắt đầu và kết thúc ở bất kỳ vị trí nào và sẽ bao phủ các ký tự ban đầu hiện có ở vị trí đó.

Given a string `s`, return the minimum number of turns the printer needed to print it.
Cho một chuỗi `s`, hãy trả về số lượt tối thiểu mà máy in cần để in nó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
This is an interval DP problem. Let `dp[i][j]` be the minimum turns to print the substring `s[i...j]`.
Đây là một bài toán DP khoảng. Gọi `dp[i][j]` là số lượt tối thiểu để in chuỗi con `s[i...j]`.

Base Case: `dp[i][i] = 1`.
Trường hợp cơ bản: `dp[i][i] = 1`.

Transition:
`dp[i][j] = dp[i][j-1] + 1` (starting by printing `s[j]` separately).
If there exists an index `k` such that `s[k] == s[j]`, then `dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j-1])`.

### Complexity / Độ phức tạp
- **Time**: O(N^3) where N is the length of the string.
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Interval DP
The goal is to find identical characters within a range to save turns. If the last character `s[j]` is the same as some `s[k]` in the range, we can merge the printing tasks.
Mục tiêu là tìm các ký tự giống nhau trong một phạm vi để tiết kiệm lượt in. Nếu ký tự cuối cùng `s[j]` giống với một `s[k]` nào đó trong phạm vi, chúng ta có thể gộp các tác vụ in.

---

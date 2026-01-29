# 1259. Handshakes That Don't Cross / Những cái Bắt tay Không cắt nhau

## Problem Description / Mô tả bài toán
Given `numPeople`. Return number of ways to pair them up (handshakes) such that no handshakes cross.
`numPeople` is even.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Catalan Numbers / Dynamic Programming
Let `dp[n]` be ways for `n` people.
Fix person 1. Person 1 must shake hands with someone `k` such that the group is split into two non-crossing sets.
For no crossing, the line `(1, k)` splits the circle into `k-2` people on one side and `n-k` on other.
Both groups must have even number of people to be fully paired.
So `k` must be even (2, 4, 6...).
State transition:
`dp[n] = sum(dp[i] * dp[n - 2 - i])` for `i` items on one side (where `i` is even count).
Wait.
If 1 shakes with `k`. Inside group `(2...k-1)` has `k-2` people. Outside `(k+1...n)` has `n-k` people.
`k` ranges from 2, 4, ..., n.
Let `2m = n`.
`dp[2m] = sum(dp[2i] * dp[2(m-1-i)])` for i from 0 to m-1.
This is exactly Catalan number definition `C_m = sum(C_i * C_{m-1-i})`.
Result is `Catalan(numPeople / 2)`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) for DP or O(N) for formula.
- **Space**: O(N) for DP.

---

## Analysis / Phân tích

### Approach: Dynamic Programming (Catalan Logic)
Use DP where `dp[i]` is the number of ways for `i` people. Fix one person (say, person 1). They can shake hands with person `k` (where `k` is even, ensuring `k-2` people between them can pair up). This splits the remaining people into two valid subproblems: `k-2` people on one side and `i-k` on the other. Sum product `dp[k-2] * dp[i-k]` over all valid `k`.
This recurrence relation corresponds to Catalan numbers.
Sử dụng DP trong đó `dp[i]` là số cách cho `i` người. Cố định một người (giả sử người 1). Họ có thể bắt tay với người `k` (trong đó `k` là số chẵn, đảm bảo `k-2` người ở giữa họ có thể ghép đôi). Điều này chia những người còn lại thành hai bài toán con hợp lệ: `k-2` người ở một bên và `i-k` ở bên kia. Tổng tích `dp[k-2] * dp[i-k]` trên tất cả các `k` hợp lệ.
Mối quan hệ truy hồi này tương ứng với số Catalan.

---
